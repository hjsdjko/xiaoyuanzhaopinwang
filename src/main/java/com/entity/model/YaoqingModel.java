package com.entity.model;

import com.entity.YaoqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 邀请面试
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YaoqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 简历
     */
    private Integer jianliId;


    /**
     * 招聘
     */
    private Integer zhaopinId;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date mianshiTime;


    /**
     * 面试地点
     */
    private String mianshiAddress;


    /**
     * 面试需知
     */
    private String mianshiText;


    /**
     * 邀请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：简历
	 */
    public Integer getJianliId() {
        return jianliId;
    }


    /**
	 * 设置：简历
	 */
    public void setJianliId(Integer jianliId) {
        this.jianliId = jianliId;
    }
    /**
	 * 获取：招聘
	 */
    public Integer getZhaopinId() {
        return zhaopinId;
    }


    /**
	 * 设置：招聘
	 */
    public void setZhaopinId(Integer zhaopinId) {
        this.zhaopinId = zhaopinId;
    }
    /**
	 * 获取：面试时间
	 */
    public Date getMianshiTime() {
        return mianshiTime;
    }


    /**
	 * 设置：面试时间
	 */
    public void setMianshiTime(Date mianshiTime) {
        this.mianshiTime = mianshiTime;
    }
    /**
	 * 获取：面试地点
	 */
    public String getMianshiAddress() {
        return mianshiAddress;
    }


    /**
	 * 设置：面试地点
	 */
    public void setMianshiAddress(String mianshiAddress) {
        this.mianshiAddress = mianshiAddress;
    }
    /**
	 * 获取：面试需知
	 */
    public String getMianshiText() {
        return mianshiText;
    }


    /**
	 * 设置：面试需知
	 */
    public void setMianshiText(String mianshiText) {
        this.mianshiText = mianshiText;
    }
    /**
	 * 获取：邀请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：邀请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
