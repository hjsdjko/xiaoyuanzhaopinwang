package com.entity.vo;

import com.entity.YaoqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 邀请面试
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yaoqing")
public class YaoqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


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

}
