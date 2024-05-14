package com.entity.view;

import com.entity.HetongxieyiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 合同协议
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("hetongxieyi")
public class HetongxieyiView extends HetongxieyiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 协议类型的值
		*/
		private String hetongxieyiValue;



		//级联表 xuesheng
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 是否就业
			*/
			private Integer jiuyeTypes;
				/**
				* 是否就业的值
				*/
				private String jiuyeValue;
			/**
			* 学院
			*/
			private Integer xueyuanTypes;
				/**
				* 学院的值
				*/
				private String xueyuanValue;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

		//级联表 gongsi
			/**
			* 公司名称
			*/
			private String gongsiName;
			/**
			* 所在行业
			*/
			private Integer hanyeTypes;
				/**
				* 所在行业的值
				*/
				private String hanyeValue;
			/**
			* 联系方式
			*/
			private String gongsiPhone;
			/**
			* 邮箱
			*/
			private String gongsiEmail;
			/**
			* 营业执照展示
			*/
			private String gongsiPhoto;
			/**
			* 公司简介
			*/
			private String gongsiContent;
			/**
			* 逻辑删除
			*/
			private Integer gongsiDelete;

	public HetongxieyiView() {

	}

	public HetongxieyiView(HetongxieyiEntity hetongxieyiEntity) {
		try {
			BeanUtils.copyProperties(this, hetongxieyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 协议类型的值
			*/
			public String getHetongxieyiValue() {
				return hetongxieyiValue;
			}
			/**
			* 设置： 协议类型的值
			*/
			public void setHetongxieyiValue(String hetongxieyiValue) {
				this.hetongxieyiValue = hetongxieyiValue;
			}























				//级联表的get和set xuesheng

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 是否就业
					*/
					public Integer getJiuyeTypes() {
						return jiuyeTypes;
					}
					/**
					* 设置： 是否就业
					*/
					public void setJiuyeTypes(Integer jiuyeTypes) {
						this.jiuyeTypes = jiuyeTypes;
					}


						/**
						* 获取： 是否就业的值
						*/
						public String getJiuyeValue() {
							return jiuyeValue;
						}
						/**
						* 设置： 是否就业的值
						*/
						public void setJiuyeValue(String jiuyeValue) {
							this.jiuyeValue = jiuyeValue;
						}

					/**
					* 获取： 学院
					*/
					public Integer getXueyuanTypes() {
						return xueyuanTypes;
					}
					/**
					* 设置： 学院
					*/
					public void setXueyuanTypes(Integer xueyuanTypes) {
						this.xueyuanTypes = xueyuanTypes;
					}


						/**
						* 获取： 学院的值
						*/
						public String getXueyuanValue() {
							return xueyuanValue;
						}
						/**
						* 设置： 学院的值
						*/
						public void setXueyuanValue(String xueyuanValue) {
							this.xueyuanValue = xueyuanValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}














				//级联表的get和set gongsi

					/**
					* 获取： 公司名称
					*/
					public String getGongsiName() {
						return gongsiName;
					}
					/**
					* 设置： 公司名称
					*/
					public void setGongsiName(String gongsiName) {
						this.gongsiName = gongsiName;
					}

					/**
					* 获取： 所在行业
					*/
					public Integer getHanyeTypes() {
						return hanyeTypes;
					}
					/**
					* 设置： 所在行业
					*/
					public void setHanyeTypes(Integer hanyeTypes) {
						this.hanyeTypes = hanyeTypes;
					}


						/**
						* 获取： 所在行业的值
						*/
						public String getHanyeValue() {
							return hanyeValue;
						}
						/**
						* 设置： 所在行业的值
						*/
						public void setHanyeValue(String hanyeValue) {
							this.hanyeValue = hanyeValue;
						}

					/**
					* 获取： 联系方式
					*/
					public String getGongsiPhone() {
						return gongsiPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setGongsiPhone(String gongsiPhone) {
						this.gongsiPhone = gongsiPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getGongsiEmail() {
						return gongsiEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setGongsiEmail(String gongsiEmail) {
						this.gongsiEmail = gongsiEmail;
					}

					/**
					* 获取： 营业执照展示
					*/
					public String getGongsiPhoto() {
						return gongsiPhoto;
					}
					/**
					* 设置： 营业执照展示
					*/
					public void setGongsiPhoto(String gongsiPhoto) {
						this.gongsiPhoto = gongsiPhoto;
					}

					/**
					* 获取： 公司简介
					*/
					public String getGongsiContent() {
						return gongsiContent;
					}
					/**
					* 设置： 公司简介
					*/
					public void setGongsiContent(String gongsiContent) {
						this.gongsiContent = gongsiContent;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getGongsiDelete() {
						return gongsiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setGongsiDelete(Integer gongsiDelete) {
						this.gongsiDelete = gongsiDelete;
					}




}
