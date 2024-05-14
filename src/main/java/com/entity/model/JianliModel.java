package com.entity.model;

import com.entity.JianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 简历
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 简历唯一编号
     */
    private String jianliUuidNumber;


    /**
     * 简历名称
     */
    private String jianliName;


    /**
     * 姓名
     */
    private String jianliXingming;


    /**
     * 性别
     */
    private Integer jianliSexTypes;


    /**
     * 手机号
     */
    private String jianliPhone;


    /**
     * 照片
     */
    private String jianliPhoto;


    /**
     * 院系
     */
    private Integer yuanxiTypes;


    /**
     * 教育经历
     */
    private String jiaoyuText;


    /**
     * 实习或工作经历
     */
    private String shixiText;


    /**
     * 个人介绍
     */
    private String gerenText;


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
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：简历唯一编号
	 */
    public String getJianliUuidNumber() {
        return jianliUuidNumber;
    }


    /**
	 * 设置：简历唯一编号
	 */
    public void setJianliUuidNumber(String jianliUuidNumber) {
        this.jianliUuidNumber = jianliUuidNumber;
    }
    /**
	 * 获取：简历名称
	 */
    public String getJianliName() {
        return jianliName;
    }


    /**
	 * 设置：简历名称
	 */
    public void setJianliName(String jianliName) {
        this.jianliName = jianliName;
    }
    /**
	 * 获取：姓名
	 */
    public String getJianliXingming() {
        return jianliXingming;
    }


    /**
	 * 设置：姓名
	 */
    public void setJianliXingming(String jianliXingming) {
        this.jianliXingming = jianliXingming;
    }
    /**
	 * 获取：性别
	 */
    public Integer getJianliSexTypes() {
        return jianliSexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setJianliSexTypes(Integer jianliSexTypes) {
        this.jianliSexTypes = jianliSexTypes;
    }
    /**
	 * 获取：手机号
	 */
    public String getJianliPhone() {
        return jianliPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setJianliPhone(String jianliPhone) {
        this.jianliPhone = jianliPhone;
    }
    /**
	 * 获取：照片
	 */
    public String getJianliPhoto() {
        return jianliPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setJianliPhoto(String jianliPhoto) {
        this.jianliPhoto = jianliPhoto;
    }
    /**
	 * 获取：院系
	 */
    public Integer getYuanxiTypes() {
        return yuanxiTypes;
    }


    /**
	 * 设置：院系
	 */
    public void setYuanxiTypes(Integer yuanxiTypes) {
        this.yuanxiTypes = yuanxiTypes;
    }
    /**
	 * 获取：教育经历
	 */
    public String getJiaoyuText() {
        return jiaoyuText;
    }


    /**
	 * 设置：教育经历
	 */
    public void setJiaoyuText(String jiaoyuText) {
        this.jiaoyuText = jiaoyuText;
    }
    /**
	 * 获取：实习或工作经历
	 */
    public String getShixiText() {
        return shixiText;
    }


    /**
	 * 设置：实习或工作经历
	 */
    public void setShixiText(String shixiText) {
        this.shixiText = shixiText;
    }
    /**
	 * 获取：个人介绍
	 */
    public String getGerenText() {
        return gerenText;
    }


    /**
	 * 设置：个人介绍
	 */
    public void setGerenText(String gerenText) {
        this.gerenText = gerenText;
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
