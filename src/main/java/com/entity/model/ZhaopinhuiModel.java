package com.entity.model;

import com.entity.ZhaopinhuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 招聘会
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhaopinhuiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 招聘会编号
     */
    private String zhaopinhuiUuidNumber;


    /**
     * 招聘会名称
     */
    private String zhaopinhuiName;


    /**
     * 招聘会照片
     */
    private String zhaopinhuiPhoto;


    /**
     * 招聘会类型
     */
    private Integer zhaopinhuiTypes;


    /**
     * 招聘会开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaishiTime;


    /**
     * 招聘会结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshuTime;


    /**
     * 招聘会详情
     */
    private String zhaopinhuiContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：招聘会编号
	 */
    public String getZhaopinhuiUuidNumber() {
        return zhaopinhuiUuidNumber;
    }


    /**
	 * 设置：招聘会编号
	 */
    public void setZhaopinhuiUuidNumber(String zhaopinhuiUuidNumber) {
        this.zhaopinhuiUuidNumber = zhaopinhuiUuidNumber;
    }
    /**
	 * 获取：招聘会名称
	 */
    public String getZhaopinhuiName() {
        return zhaopinhuiName;
    }


    /**
	 * 设置：招聘会名称
	 */
    public void setZhaopinhuiName(String zhaopinhuiName) {
        this.zhaopinhuiName = zhaopinhuiName;
    }
    /**
	 * 获取：招聘会照片
	 */
    public String getZhaopinhuiPhoto() {
        return zhaopinhuiPhoto;
    }


    /**
	 * 设置：招聘会照片
	 */
    public void setZhaopinhuiPhoto(String zhaopinhuiPhoto) {
        this.zhaopinhuiPhoto = zhaopinhuiPhoto;
    }
    /**
	 * 获取：招聘会类型
	 */
    public Integer getZhaopinhuiTypes() {
        return zhaopinhuiTypes;
    }


    /**
	 * 设置：招聘会类型
	 */
    public void setZhaopinhuiTypes(Integer zhaopinhuiTypes) {
        this.zhaopinhuiTypes = zhaopinhuiTypes;
    }
    /**
	 * 获取：招聘会开始日期
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }


    /**
	 * 设置：招聘会开始日期
	 */
    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 获取：招聘会结束日期
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 设置：招聘会结束日期
	 */
    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 获取：招聘会详情
	 */
    public String getZhaopinhuiContent() {
        return zhaopinhuiContent;
    }


    /**
	 * 设置：招聘会详情
	 */
    public void setZhaopinhuiContent(String zhaopinhuiContent) {
        this.zhaopinhuiContent = zhaopinhuiContent;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
