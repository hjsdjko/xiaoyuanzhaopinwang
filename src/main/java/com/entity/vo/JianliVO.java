package com.entity.vo;

import com.entity.JianliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 简历
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianli")
public class JianliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 简历唯一编号
     */

    @TableField(value = "jianli_uuid_number")
    private String jianliUuidNumber;


    /**
     * 简历名称
     */

    @TableField(value = "jianli_name")
    private String jianliName;


    /**
     * 姓名
     */

    @TableField(value = "jianli_xingming")
    private String jianliXingming;


    /**
     * 性别
     */

    @TableField(value = "jianli_sex_types")
    private Integer jianliSexTypes;


    /**
     * 手机号
     */

    @TableField(value = "jianli_phone")
    private String jianliPhone;


    /**
     * 照片
     */

    @TableField(value = "jianli_photo")
    private String jianliPhoto;


    /**
     * 院系
     */

    @TableField(value = "yuanxi_types")
    private Integer yuanxiTypes;


    /**
     * 教育经历
     */

    @TableField(value = "jiaoyu_text")
    private String jiaoyuText;


    /**
     * 实习或工作经历
     */

    @TableField(value = "shixi_text")
    private String shixiText;


    /**
     * 个人介绍
     */

    @TableField(value = "geren_text")
    private String gerenText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：简历唯一编号
	 */
    public String getJianliUuidNumber() {
        return jianliUuidNumber;
    }


    /**
	 * 获取：简历唯一编号
	 */

    public void setJianliUuidNumber(String jianliUuidNumber) {
        this.jianliUuidNumber = jianliUuidNumber;
    }
    /**
	 * 设置：简历名称
	 */
    public String getJianliName() {
        return jianliName;
    }


    /**
	 * 获取：简历名称
	 */

    public void setJianliName(String jianliName) {
        this.jianliName = jianliName;
    }
    /**
	 * 设置：姓名
	 */
    public String getJianliXingming() {
        return jianliXingming;
    }


    /**
	 * 获取：姓名
	 */

    public void setJianliXingming(String jianliXingming) {
        this.jianliXingming = jianliXingming;
    }
    /**
	 * 设置：性别
	 */
    public Integer getJianliSexTypes() {
        return jianliSexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setJianliSexTypes(Integer jianliSexTypes) {
        this.jianliSexTypes = jianliSexTypes;
    }
    /**
	 * 设置：手机号
	 */
    public String getJianliPhone() {
        return jianliPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setJianliPhone(String jianliPhone) {
        this.jianliPhone = jianliPhone;
    }
    /**
	 * 设置：照片
	 */
    public String getJianliPhoto() {
        return jianliPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setJianliPhoto(String jianliPhoto) {
        this.jianliPhoto = jianliPhoto;
    }
    /**
	 * 设置：院系
	 */
    public Integer getYuanxiTypes() {
        return yuanxiTypes;
    }


    /**
	 * 获取：院系
	 */

    public void setYuanxiTypes(Integer yuanxiTypes) {
        this.yuanxiTypes = yuanxiTypes;
    }
    /**
	 * 设置：教育经历
	 */
    public String getJiaoyuText() {
        return jiaoyuText;
    }


    /**
	 * 获取：教育经历
	 */

    public void setJiaoyuText(String jiaoyuText) {
        this.jiaoyuText = jiaoyuText;
    }
    /**
	 * 设置：实习或工作经历
	 */
    public String getShixiText() {
        return shixiText;
    }


    /**
	 * 获取：实习或工作经历
	 */

    public void setShixiText(String shixiText) {
        this.shixiText = shixiText;
    }
    /**
	 * 设置：个人介绍
	 */
    public String getGerenText() {
        return gerenText;
    }


    /**
	 * 获取：个人介绍
	 */

    public void setGerenText(String gerenText) {
        this.gerenText = gerenText;
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

}
