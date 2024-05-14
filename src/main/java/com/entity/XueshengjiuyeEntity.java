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
 * 学生就业信息
 *
 * @author 
 * @email
 */
@TableName("xueshengjiuye")
public class XueshengjiuyeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengjiuyeEntity() {

	}

	public XueshengjiuyeEntity(T t) {
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
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 就业编号
     */
    @TableField(value = "xueshengjiuye_uuid_number")

    private String xueshengjiuyeUuidNumber;


    /**
     * 就业地点
     */
    @TableField(value = "xueshengjiuye_address")

    private String xueshengjiuyeAddress;


    /**
     * 就业公司
     */
    @TableField(value = "xueshengjiuye_gongsi")

    private String xueshengjiuyeGongsi;


    /**
     * 就业职位
     */
    @TableField(value = "xueshengjiuye_zhiwei")

    private String xueshengjiuyeZhiwei;


    /**
     * 就业薪资/月
     */
    @TableField(value = "xueshengjiuye_xinzi")

    private Double xueshengjiuyeXinzi;


    /**
     * 就业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jiuye_time")

    private Date jiuyeTime;


    /**
     * 就业备注
     */
    @TableField(value = "xueshengjiuye_content")

    private String xueshengjiuyeContent;


    /**
     * 记录时间
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
	 * 设置：就业编号
	 */
    public String getXueshengjiuyeUuidNumber() {
        return xueshengjiuyeUuidNumber;
    }
    /**
	 * 获取：就业编号
	 */

    public void setXueshengjiuyeUuidNumber(String xueshengjiuyeUuidNumber) {
        this.xueshengjiuyeUuidNumber = xueshengjiuyeUuidNumber;
    }
    /**
	 * 设置：就业地点
	 */
    public String getXueshengjiuyeAddress() {
        return xueshengjiuyeAddress;
    }
    /**
	 * 获取：就业地点
	 */

    public void setXueshengjiuyeAddress(String xueshengjiuyeAddress) {
        this.xueshengjiuyeAddress = xueshengjiuyeAddress;
    }
    /**
	 * 设置：就业公司
	 */
    public String getXueshengjiuyeGongsi() {
        return xueshengjiuyeGongsi;
    }
    /**
	 * 获取：就业公司
	 */

    public void setXueshengjiuyeGongsi(String xueshengjiuyeGongsi) {
        this.xueshengjiuyeGongsi = xueshengjiuyeGongsi;
    }
    /**
	 * 设置：就业职位
	 */
    public String getXueshengjiuyeZhiwei() {
        return xueshengjiuyeZhiwei;
    }
    /**
	 * 获取：就业职位
	 */

    public void setXueshengjiuyeZhiwei(String xueshengjiuyeZhiwei) {
        this.xueshengjiuyeZhiwei = xueshengjiuyeZhiwei;
    }
    /**
	 * 设置：就业薪资/月
	 */
    public Double getXueshengjiuyeXinzi() {
        return xueshengjiuyeXinzi;
    }
    /**
	 * 获取：就业薪资/月
	 */

    public void setXueshengjiuyeXinzi(Double xueshengjiuyeXinzi) {
        this.xueshengjiuyeXinzi = xueshengjiuyeXinzi;
    }
    /**
	 * 设置：就业时间
	 */
    public Date getJiuyeTime() {
        return jiuyeTime;
    }
    /**
	 * 获取：就业时间
	 */

    public void setJiuyeTime(Date jiuyeTime) {
        this.jiuyeTime = jiuyeTime;
    }
    /**
	 * 设置：就业备注
	 */
    public String getXueshengjiuyeContent() {
        return xueshengjiuyeContent;
    }
    /**
	 * 获取：就业备注
	 */

    public void setXueshengjiuyeContent(String xueshengjiuyeContent) {
        this.xueshengjiuyeContent = xueshengjiuyeContent;
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
        return "Xueshengjiuye{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", xueshengjiuyeUuidNumber=" + xueshengjiuyeUuidNumber +
            ", xueshengjiuyeAddress=" + xueshengjiuyeAddress +
            ", xueshengjiuyeGongsi=" + xueshengjiuyeGongsi +
            ", xueshengjiuyeZhiwei=" + xueshengjiuyeZhiwei +
            ", xueshengjiuyeXinzi=" + xueshengjiuyeXinzi +
            ", jiuyeTime=" + jiuyeTime +
            ", xueshengjiuyeContent=" + xueshengjiuyeContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
