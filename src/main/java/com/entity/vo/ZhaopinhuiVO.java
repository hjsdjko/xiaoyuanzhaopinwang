package com.entity.vo;

import com.entity.ZhaopinhuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 招聘会
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhaopinhui")
public class ZhaopinhuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 招聘会编号
     */

    @TableField(value = "zhaopinhui_uuid_number")
    private String zhaopinhuiUuidNumber;


    /**
     * 招聘会名称
     */

    @TableField(value = "zhaopinhui_name")
    private String zhaopinhuiName;


    /**
     * 招聘会照片
     */

    @TableField(value = "zhaopinhui_photo")
    private String zhaopinhuiPhoto;


    /**
     * 招聘会类型
     */

    @TableField(value = "zhaopinhui_types")
    private Integer zhaopinhuiTypes;


    /**
     * 招聘会开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kaishi_time")
    private Date kaishiTime;


    /**
     * 招聘会结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieshu_time")
    private Date jieshuTime;


    /**
     * 招聘会详情
     */

    @TableField(value = "zhaopinhui_content")
    private String zhaopinhuiContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：招聘会编号
	 */
    public String getZhaopinhuiUuidNumber() {
        return zhaopinhuiUuidNumber;
    }


    /**
	 * 获取：招聘会编号
	 */

    public void setZhaopinhuiUuidNumber(String zhaopinhuiUuidNumber) {
        this.zhaopinhuiUuidNumber = zhaopinhuiUuidNumber;
    }
    /**
	 * 设置：招聘会名称
	 */
    public String getZhaopinhuiName() {
        return zhaopinhuiName;
    }


    /**
	 * 获取：招聘会名称
	 */

    public void setZhaopinhuiName(String zhaopinhuiName) {
        this.zhaopinhuiName = zhaopinhuiName;
    }
    /**
	 * 设置：招聘会照片
	 */
    public String getZhaopinhuiPhoto() {
        return zhaopinhuiPhoto;
    }


    /**
	 * 获取：招聘会照片
	 */

    public void setZhaopinhuiPhoto(String zhaopinhuiPhoto) {
        this.zhaopinhuiPhoto = zhaopinhuiPhoto;
    }
    /**
	 * 设置：招聘会类型
	 */
    public Integer getZhaopinhuiTypes() {
        return zhaopinhuiTypes;
    }


    /**
	 * 获取：招聘会类型
	 */

    public void setZhaopinhuiTypes(Integer zhaopinhuiTypes) {
        this.zhaopinhuiTypes = zhaopinhuiTypes;
    }
    /**
	 * 设置：招聘会开始日期
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }


    /**
	 * 获取：招聘会开始日期
	 */

    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 设置：招聘会结束日期
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 获取：招聘会结束日期
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 设置：招聘会详情
	 */
    public String getZhaopinhuiContent() {
        return zhaopinhuiContent;
    }


    /**
	 * 获取：招聘会详情
	 */

    public void setZhaopinhuiContent(String zhaopinhuiContent) {
        this.zhaopinhuiContent = zhaopinhuiContent;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
