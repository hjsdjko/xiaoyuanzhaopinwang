
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 合同协议
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hetongxieyi")
public class HetongxieyiController {
    private static final Logger logger = LoggerFactory.getLogger(HetongxieyiController.class);

    @Autowired
    private HetongxieyiService hetongxieyiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private GongsiService gongsiService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("公司".equals(role))
            params.put("gongsiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = hetongxieyiService.queryPage(params);

        //字典表数据转换
        List<HetongxieyiView> list =(List<HetongxieyiView>)page.getList();
        for(HetongxieyiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HetongxieyiEntity hetongxieyi = hetongxieyiService.selectById(id);
        if(hetongxieyi !=null){
            //entity转view
            HetongxieyiView view = new HetongxieyiView();
            BeanUtils.copyProperties( hetongxieyi , view );//把实体数据重构到view中

                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(hetongxieyi.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //级联表
                GongsiEntity gongsi = gongsiService.selectById(hetongxieyi.getGongsiId());
                if(gongsi != null){
                    BeanUtils.copyProperties( gongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongsiId(gongsi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HetongxieyiEntity hetongxieyi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hetongxieyi:{}",this.getClass().getName(),hetongxieyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("公司".equals(role))
            hetongxieyi.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("学生".equals(role))
            hetongxieyi.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HetongxieyiEntity> queryWrapper = new EntityWrapper<HetongxieyiEntity>()
            .eq("hetongxieyi_uuid_number", hetongxieyi.getHetongxieyiUuidNumber())
            .eq("gongsi_id", hetongxieyi.getGongsiId())
            .eq("xuesheng_id", hetongxieyi.getXueshengId())
            .eq("hetongxieyi_biaoti", hetongxieyi.getHetongxieyiBiaoti())
            .eq("hetongxieyi_types", hetongxieyi.getHetongxieyiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongxieyiEntity hetongxieyiEntity = hetongxieyiService.selectOne(queryWrapper);
        if(hetongxieyiEntity==null){
            hetongxieyi.setInsertTime(new Date());
            hetongxieyi.setCreateTime(new Date());
            hetongxieyiService.insert(hetongxieyi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HetongxieyiEntity hetongxieyi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,hetongxieyi:{}",this.getClass().getName(),hetongxieyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("公司".equals(role))
//            hetongxieyi.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("学生".equals(role))
//            hetongxieyi.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<HetongxieyiEntity> queryWrapper = new EntityWrapper<HetongxieyiEntity>()
            .notIn("id",hetongxieyi.getId())
            .andNew()
            .eq("hetongxieyi_uuid_number", hetongxieyi.getHetongxieyiUuidNumber())
            .eq("gongsi_id", hetongxieyi.getGongsiId())
            .eq("xuesheng_id", hetongxieyi.getXueshengId())
            .eq("hetongxieyi_biaoti", hetongxieyi.getHetongxieyiBiaoti())
            .eq("hetongxieyi_types", hetongxieyi.getHetongxieyiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongxieyiEntity hetongxieyiEntity = hetongxieyiService.selectOne(queryWrapper);
        if("".equals(hetongxieyi.getHetongxieyiFile()) || "null".equals(hetongxieyi.getHetongxieyiFile())){
                hetongxieyi.setHetongxieyiFile(null);
        }
        if(hetongxieyiEntity==null){
            hetongxieyiService.updateById(hetongxieyi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        hetongxieyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HetongxieyiEntity> hetongxieyiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HetongxieyiEntity hetongxieyiEntity = new HetongxieyiEntity();
//                            hetongxieyiEntity.setHetongxieyiUuidNumber(data.get(0));                    //协议编号 要改的
//                            hetongxieyiEntity.setGongsiId(Integer.valueOf(data.get(0)));   //公司 要改的
//                            hetongxieyiEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            hetongxieyiEntity.setHetongxieyiBiaoti(data.get(0));                    //协议标题 要改的
//                            hetongxieyiEntity.setHetongxieyiTypes(Integer.valueOf(data.get(0)));   //协议类型 要改的
//                            hetongxieyiEntity.setHetongxieyiFile(data.get(0));                    //协议文件 要改的
//                            hetongxieyiEntity.setQiandingTime(sdf.parse(data.get(0)));          //协议签订时间 要改的
//                            hetongxieyiEntity.setHetongxieyiContent("");//详情和图片
//                            hetongxieyiEntity.setInsertTime(date);//时间
//                            hetongxieyiEntity.setCreateTime(date);//时间
                            hetongxieyiList.add(hetongxieyiEntity);


                            //把要查询是否重复的字段放入map中
                                //协议编号
                                if(seachFields.containsKey("hetongxieyiUuidNumber")){
                                    List<String> hetongxieyiUuidNumber = seachFields.get("hetongxieyiUuidNumber");
                                    hetongxieyiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> hetongxieyiUuidNumber = new ArrayList<>();
                                    hetongxieyiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("hetongxieyiUuidNumber",hetongxieyiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //协议编号
                        List<HetongxieyiEntity> hetongxieyiEntities_hetongxieyiUuidNumber = hetongxieyiService.selectList(new EntityWrapper<HetongxieyiEntity>().in("hetongxieyi_uuid_number", seachFields.get("hetongxieyiUuidNumber")));
                        if(hetongxieyiEntities_hetongxieyiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HetongxieyiEntity s:hetongxieyiEntities_hetongxieyiUuidNumber){
                                repeatFields.add(s.getHetongxieyiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [协议编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        hetongxieyiService.insertBatch(hetongxieyiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = hetongxieyiService.queryPage(params);

        //字典表数据转换
        List<HetongxieyiView> list =(List<HetongxieyiView>)page.getList();
        for(HetongxieyiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HetongxieyiEntity hetongxieyi = hetongxieyiService.selectById(id);
            if(hetongxieyi !=null){


                //entity转view
                HetongxieyiView view = new HetongxieyiView();
                BeanUtils.copyProperties( hetongxieyi , view );//把实体数据重构到view中

                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(hetongxieyi.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //级联表
                    GongsiEntity gongsi = gongsiService.selectById(hetongxieyi.getGongsiId());
                if(gongsi != null){
                    BeanUtils.copyProperties( gongsi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongsiId(gongsi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HetongxieyiEntity hetongxieyi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,hetongxieyi:{}",this.getClass().getName(),hetongxieyi.toString());
        Wrapper<HetongxieyiEntity> queryWrapper = new EntityWrapper<HetongxieyiEntity>()
            .eq("hetongxieyi_uuid_number", hetongxieyi.getHetongxieyiUuidNumber())
            .eq("gongsi_id", hetongxieyi.getGongsiId())
            .eq("xuesheng_id", hetongxieyi.getXueshengId())
            .eq("hetongxieyi_biaoti", hetongxieyi.getHetongxieyiBiaoti())
            .eq("hetongxieyi_types", hetongxieyi.getHetongxieyiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongxieyiEntity hetongxieyiEntity = hetongxieyiService.selectOne(queryWrapper);
        if(hetongxieyiEntity==null){
            hetongxieyi.setInsertTime(new Date());
            hetongxieyi.setCreateTime(new Date());
        hetongxieyiService.insert(hetongxieyi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
