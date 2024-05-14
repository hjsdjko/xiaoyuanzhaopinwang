package com.dao;

import com.entity.HetongxieyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HetongxieyiView;

/**
 * 合同协议 Dao 接口
 *
 * @author 
 */
public interface HetongxieyiDao extends BaseMapper<HetongxieyiEntity> {

   List<HetongxieyiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
