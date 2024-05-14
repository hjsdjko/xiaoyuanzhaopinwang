package com.entity.view;

import com.entity.ZhaopinhuiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 招聘会
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhaopinhui")
public class ZhaopinhuiView extends ZhaopinhuiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 招聘会类型的值
		*/
		private String zhaopinhuiValue;



	public ZhaopinhuiView() {

	}

	public ZhaopinhuiView(ZhaopinhuiEntity zhaopinhuiEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinhuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 招聘会类型的值
			*/
			public String getZhaopinhuiValue() {
				return zhaopinhuiValue;
			}
			/**
			* 设置： 招聘会类型的值
			*/
			public void setZhaopinhuiValue(String zhaopinhuiValue) {
				this.zhaopinhuiValue = zhaopinhuiValue;
			}















}
