
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
 * 学生就业信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xueshengjiuye")
public class XueshengjiuyeController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengjiuyeController.class);

    @Autowired
    private XueshengjiuyeService xueshengjiuyeService;


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
        PageUtils page = xueshengjiuyeService.queryPage(params);

        //字典表数据转换
        List<XueshengjiuyeView> list =(List<XueshengjiuyeView>)page.getList();
        for(XueshengjiuyeView c:list){
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
        XueshengjiuyeEntity xueshengjiuye = xueshengjiuyeService.selectById(id);
        if(xueshengjiuye !=null){
            //entity转view
            XueshengjiuyeView view = new XueshengjiuyeView();
            BeanUtils.copyProperties( xueshengjiuye , view );//把实体数据重构到view中

                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(xueshengjiuye.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R save(@RequestBody XueshengjiuyeEntity xueshengjiuye, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xueshengjiuye:{}",this.getClass().getName(),xueshengjiuye.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xueshengjiuye.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueshengjiuyeEntity> queryWrapper = new EntityWrapper<XueshengjiuyeEntity>()
            .eq("xuesheng_id", xueshengjiuye.getXueshengId())
            .eq("xueshengjiuye_uuid_number", xueshengjiuye.getXueshengjiuyeUuidNumber())
            .eq("xueshengjiuye_address", xueshengjiuye.getXueshengjiuyeAddress())
            .eq("xueshengjiuye_gongsi", xueshengjiuye.getXueshengjiuyeGongsi())
            .eq("xueshengjiuye_zhiwei", xueshengjiuye.getXueshengjiuyeZhiwei())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengjiuyeEntity xueshengjiuyeEntity = xueshengjiuyeService.selectOne(queryWrapper);
        if(xueshengjiuyeEntity==null){
            xueshengjiuye.setInsertTime(new Date());
            xueshengjiuye.setCreateTime(new Date());
            xueshengjiuyeService.insert(xueshengjiuye);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengjiuyeEntity xueshengjiuye, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xueshengjiuye:{}",this.getClass().getName(),xueshengjiuye.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xueshengjiuye.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XueshengjiuyeEntity> queryWrapper = new EntityWrapper<XueshengjiuyeEntity>()
            .notIn("id",xueshengjiuye.getId())
            .andNew()
            .eq("xuesheng_id", xueshengjiuye.getXueshengId())
            .eq("xueshengjiuye_uuid_number", xueshengjiuye.getXueshengjiuyeUuidNumber())
            .eq("xueshengjiuye_address", xueshengjiuye.getXueshengjiuyeAddress())
            .eq("xueshengjiuye_gongsi", xueshengjiuye.getXueshengjiuyeGongsi())
            .eq("xueshengjiuye_zhiwei", xueshengjiuye.getXueshengjiuyeZhiwei())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengjiuyeEntity xueshengjiuyeEntity = xueshengjiuyeService.selectOne(queryWrapper);
        if(xueshengjiuyeEntity==null){
            xueshengjiuyeService.updateById(xueshengjiuye);//根据id更新
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
        xueshengjiuyeService.deleteBatchIds(Arrays.asList(ids));
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
            List<XueshengjiuyeEntity> xueshengjiuyeList = new ArrayList<>();//上传的东西
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
                            XueshengjiuyeEntity xueshengjiuyeEntity = new XueshengjiuyeEntity();
//                            xueshengjiuyeEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xueshengjiuyeEntity.setXueshengjiuyeUuidNumber(data.get(0));                    //就业编号 要改的
//                            xueshengjiuyeEntity.setXueshengjiuyeAddress(data.get(0));                    //就业地点 要改的
//                            xueshengjiuyeEntity.setXueshengjiuyeGongsi(data.get(0));                    //就业公司 要改的
//                            xueshengjiuyeEntity.setXueshengjiuyeZhiwei(data.get(0));                    //就业职位 要改的
//                            xueshengjiuyeEntity.setXueshengjiuyeXinzi(data.get(0));                    //就业薪资/月 要改的
//                            xueshengjiuyeEntity.setJiuyeTime(sdf.parse(data.get(0)));          //就业时间 要改的
//                            xueshengjiuyeEntity.setXueshengjiuyeContent("");//详情和图片
//                            xueshengjiuyeEntity.setInsertTime(date);//时间
//                            xueshengjiuyeEntity.setCreateTime(date);//时间
                            xueshengjiuyeList.add(xueshengjiuyeEntity);


                            //把要查询是否重复的字段放入map中
                                //就业编号
                                if(seachFields.containsKey("xueshengjiuyeUuidNumber")){
                                    List<String> xueshengjiuyeUuidNumber = seachFields.get("xueshengjiuyeUuidNumber");
                                    xueshengjiuyeUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengjiuyeUuidNumber = new ArrayList<>();
                                    xueshengjiuyeUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xueshengjiuyeUuidNumber",xueshengjiuyeUuidNumber);
                                }
                        }

                        //查询是否重复
                         //就业编号
                        List<XueshengjiuyeEntity> xueshengjiuyeEntities_xueshengjiuyeUuidNumber = xueshengjiuyeService.selectList(new EntityWrapper<XueshengjiuyeEntity>().in("xueshengjiuye_uuid_number", seachFields.get("xueshengjiuyeUuidNumber")));
                        if(xueshengjiuyeEntities_xueshengjiuyeUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengjiuyeEntity s:xueshengjiuyeEntities_xueshengjiuyeUuidNumber){
                                repeatFields.add(s.getXueshengjiuyeUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [就业编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xueshengjiuyeService.insertBatch(xueshengjiuyeList);
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
        PageUtils page = xueshengjiuyeService.queryPage(params);

        //字典表数据转换
        List<XueshengjiuyeView> list =(List<XueshengjiuyeView>)page.getList();
        for(XueshengjiuyeView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XueshengjiuyeEntity xueshengjiuye = xueshengjiuyeService.selectById(id);
            if(xueshengjiuye !=null){


                //entity转view
                XueshengjiuyeView view = new XueshengjiuyeView();
                BeanUtils.copyProperties( xueshengjiuye , view );//把实体数据重构到view中

                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(xueshengjiuye.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R add(@RequestBody XueshengjiuyeEntity xueshengjiuye, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xueshengjiuye:{}",this.getClass().getName(),xueshengjiuye.toString());
        Wrapper<XueshengjiuyeEntity> queryWrapper = new EntityWrapper<XueshengjiuyeEntity>()
            .eq("xuesheng_id", xueshengjiuye.getXueshengId())
            .eq("xueshengjiuye_uuid_number", xueshengjiuye.getXueshengjiuyeUuidNumber())
            .eq("xueshengjiuye_address", xueshengjiuye.getXueshengjiuyeAddress())
            .eq("xueshengjiuye_gongsi", xueshengjiuye.getXueshengjiuyeGongsi())
            .eq("xueshengjiuye_zhiwei", xueshengjiuye.getXueshengjiuyeZhiwei())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengjiuyeEntity xueshengjiuyeEntity = xueshengjiuyeService.selectOne(queryWrapper);
        if(xueshengjiuyeEntity==null){
            xueshengjiuye.setInsertTime(new Date());
            xueshengjiuye.setCreateTime(new Date());
        xueshengjiuyeService.insert(xueshengjiuye);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
