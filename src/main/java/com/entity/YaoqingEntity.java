package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 邀请面试
 *
 * @author 
 * @email
 */
@TableName("yaoqing")
public class YaoqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YaoqingEntity() {

	}

	public YaoqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 简历
     */
    @TableField(value = "jianli_id")

    private Integer jianliId;


    /**
     * 招聘
     */
    @TableField(value = "zhaopin_id")

    private Integer zhaopinId;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "mianshi_time")

    private Date mianshiTime;


    /**
     * 面试地点
     */
    @TableField(value = "mianshi_address")

    private String mianshiAddress;


    /**
     * 面试需知
     */
    @TableField(value = "mianshi_text")

    private String mianshiText;


    /**
     * 邀请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：简历
	 */
    public Integer getJianliId() {
        return jianliId;
    }
    /**
	 * 获取：简历
	 */

    public void setJianliId(Integer jianliId) {
        this.jianliId = jianliId;
    }
    /**
	 * 设置：招聘
	 */
    public Integer getZhaopinId() {
        return zhaopinId;
    }
    /**
	 * 获取：招聘
	 */

    public void setZhaopinId(Integer zhaopinId) {
        this.zhaopinId = zhaopinId;
    }
    /**
	 * 设置：面试时间
	 */
    public Date getMianshiTime() {
        return mianshiTime;
    }
    /**
	 * 获取：面试时间
	 */

    public void setMianshiTime(Date mianshiTime) {
        this.mianshiTime = mianshiTime;
    }
    /**
	 * 设置：面试地点
	 */
    public String getMianshiAddress() {
        return mianshiAddress;
    }
    /**
	 * 获取：面试地点
	 */

    public void setMianshiAddress(String mianshiAddress) {
        this.mianshiAddress = mianshiAddress;
    }
    /**
	 * 设置：面试需知
	 */
    public String getMianshiText() {
        return mianshiText;
    }
    /**
	 * 获取：面试需知
	 */

    public void setMianshiText(String mianshiText) {
        this.mianshiText = mianshiText;
    }
    /**
	 * 设置：邀请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：邀请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yaoqing{" +
            "id=" + id +
            ", jianliId=" + jianliId +
            ", zhaopinId=" + zhaopinId +
            ", mianshiTime=" + mianshiTime +
            ", mianshiAddress=" + mianshiAddress +
            ", mianshiText=" + mianshiText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
