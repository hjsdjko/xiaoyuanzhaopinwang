
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
 * 招聘会
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhaopinhui")
public class ZhaopinhuiController {
    private static final Logger logger = LoggerFactory.getLogger(ZhaopinhuiController.class);

    @Autowired
    private ZhaopinhuiService zhaopinhuiService;


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
        PageUtils page = zhaopinhuiService.queryPage(params);

        //字典表数据转换
        List<ZhaopinhuiView> list =(List<ZhaopinhuiView>)page.getList();
        for(ZhaopinhuiView c:list){
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
        ZhaopinhuiEntity zhaopinhui = zhaopinhuiService.selectById(id);
        if(zhaopinhui !=null){
            //entity转view
            ZhaopinhuiView view = new ZhaopinhuiView();
            BeanUtils.copyProperties( zhaopinhui , view );//把实体数据重构到view中

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
    public R save(@RequestBody ZhaopinhuiEntity zhaopinhui, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhaopinhui:{}",this.getClass().getName(),zhaopinhui.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhaopinhuiEntity> queryWrapper = new EntityWrapper<ZhaopinhuiEntity>()
            .eq("zhaopinhui_uuid_number", zhaopinhui.getZhaopinhuiUuidNumber())
            .eq("zhaopinhui_name", zhaopinhui.getZhaopinhuiName())
            .eq("zhaopinhui_types", zhaopinhui.getZhaopinhuiTypes())
            .eq("kaishi_time", new SimpleDateFormat("yyyy-MM-dd").format(zhaopinhui.getKaishiTime()))
            .eq("jieshu_time", new SimpleDateFormat("yyyy-MM-dd").format(zhaopinhui.getJieshuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhaopinhuiEntity zhaopinhuiEntity = zhaopinhuiService.selectOne(queryWrapper);
        if(zhaopinhuiEntity==null){
            zhaopinhui.setInsertTime(new Date());
            zhaopinhui.setCreateTime(new Date());
            zhaopinhuiService.insert(zhaopinhui);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhaopinhuiEntity zhaopinhui, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhaopinhui:{}",this.getClass().getName(),zhaopinhui.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhaopinhuiEntity> queryWrapper = new EntityWrapper<ZhaopinhuiEntity>()
            .notIn("id",zhaopinhui.getId())
            .andNew()
            .eq("zhaopinhui_uuid_number", zhaopinhui.getZhaopinhuiUuidNumber())
            .eq("zhaopinhui_name", zhaopinhui.getZhaopinhuiName())
            .eq("zhaopinhui_types", zhaopinhui.getZhaopinhuiTypes())
            .eq("kaishi_time", new SimpleDateFormat("yyyy-MM-dd").format(zhaopinhui.getKaishiTime()))
            .eq("jieshu_time", new SimpleDateFormat("yyyy-MM-dd").format(zhaopinhui.getJieshuTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhaopinhuiEntity zhaopinhuiEntity = zhaopinhuiService.selectOne(queryWrapper);
        if("".equals(zhaopinhui.getZhaopinhuiPhoto()) || "null".equals(zhaopinhui.getZhaopinhuiPhoto())){
                zhaopinhui.setZhaopinhuiPhoto(null);
        }
        if(zhaopinhuiEntity==null){
            zhaopinhuiService.updateById(zhaopinhui);//根据id更新
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
        zhaopinhuiService.deleteBatchIds(Arrays.asList(ids));
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
            List<ZhaopinhuiEntity> zhaopinhuiList = new ArrayList<>();//上传的东西
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
                            ZhaopinhuiEntity zhaopinhuiEntity = new ZhaopinhuiEntity();
//                            zhaopinhuiEntity.setZhaopinhuiUuidNumber(data.get(0));                    //招聘会编号 要改的
//                            zhaopinhuiEntity.setZhaopinhuiName(data.get(0));                    //招聘会名称 要改的
//                            zhaopinhuiEntity.setZhaopinhuiPhoto("");//详情和图片
//                            zhaopinhuiEntity.setZhaopinhuiTypes(Integer.valueOf(data.get(0)));   //招聘会类型 要改的
//                            zhaopinhuiEntity.setKaishiTime(sdf.parse(data.get(0)));          //招聘会开始日期 要改的
//                            zhaopinhuiEntity.setJieshuTime(sdf.parse(data.get(0)));          //招聘会结束日期 要改的
//                            zhaopinhuiEntity.setZhaopinhuiContent("");//详情和图片
//                            zhaopinhuiEntity.setInsertTime(date);//时间
//                            zhaopinhuiEntity.setCreateTime(date);//时间
                            zhaopinhuiList.add(zhaopinhuiEntity);


                            //把要查询是否重复的字段放入map中
                                //招聘会编号
                                if(seachFields.containsKey("zhaopinhuiUuidNumber")){
                                    List<String> zhaopinhuiUuidNumber = seachFields.get("zhaopinhuiUuidNumber");
                                    zhaopinhuiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhaopinhuiUuidNumber = new ArrayList<>();
                                    zhaopinhuiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhaopinhuiUuidNumber",zhaopinhuiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //招聘会编号
                        List<ZhaopinhuiEntity> zhaopinhuiEntities_zhaopinhuiUuidNumber = zhaopinhuiService.selectList(new EntityWrapper<ZhaopinhuiEntity>().in("zhaopinhui_uuid_number", seachFields.get("zhaopinhuiUuidNumber")));
                        if(zhaopinhuiEntities_zhaopinhuiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhaopinhuiEntity s:zhaopinhuiEntities_zhaopinhuiUuidNumber){
                                repeatFields.add(s.getZhaopinhuiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [招聘会编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhaopinhuiService.insertBatch(zhaopinhuiList);
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
        PageUtils page = zhaopinhuiService.queryPage(params);

        //字典表数据转换
        List<ZhaopinhuiView> list =(List<ZhaopinhuiView>)page.getList();
        for(ZhaopinhuiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhaopinhuiEntity zhaopinhui = zhaopinhuiService.selectById(id);
            if(zhaopinhui !=null){


                //entity转view
                ZhaopinhuiView view = new ZhaopinhuiView();
                BeanUtils.copyProperties( zhaopinhui , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZhaopinhuiEntity zhaopinhui, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhaopinhui:{}",this.getClass().getName(),zhaopinhui.toString());
        Wrapper<ZhaopinhuiEntity> queryWrapper = new EntityWrapper<ZhaopinhuiEntity>()
            .eq("zhaopinhui_uuid_number", zhaopinhui.getZhaopinhuiUuidNumber())
            .eq("zhaopinhui_name", zhaopinhui.getZhaopinhuiName())
            .eq("zhaopinhui_types", zhaopinhui.getZhaopinhuiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhaopinhuiEntity zhaopinhuiEntity = zhaopinhuiService.selectOne(queryWrapper);
        if(zhaopinhuiEntity==null){
            zhaopinhui.setInsertTime(new Date());
            zhaopinhui.setCreateTime(new Date());
        zhaopinhuiService.insert(zhaopinhui);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
