package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HetongxieyiEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 合同协议 服务类
 */
public interface HetongxieyiService extends IService<HetongxieyiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}