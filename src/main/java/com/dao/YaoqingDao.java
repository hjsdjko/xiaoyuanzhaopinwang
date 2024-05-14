package com.dao;

import com.entity.YaoqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YaoqingView;

/**
 * 邀请面试 Dao 接口
 *
 * @author 
 */
public interface YaoqingDao extends BaseMapper<YaoqingEntity> {

   List<YaoqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
