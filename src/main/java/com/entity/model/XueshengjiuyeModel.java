package com.entity.model;

import com.entity.XueshengjiuyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生就业信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengjiuyeModel implements Serializable {
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
     * 就业编号
     */
    private String xueshengjiuyeUuidNumber;


    /**
     * 就业地点
     */
    private String xueshengjiuyeAddress;


    /**
     * 就业公司
     */
    private String xueshengjiuyeGongsi;


    /**
     * 就业职位
     */
    private String xueshengjiuyeZhiwei;


    /**
     * 就业薪资/月
     */
    private Double xueshengjiuyeXinzi;


    /**
     * 就业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiuyeTime;


    /**
     * 就业备注
     */
    private String xueshengjiuyeContent;


    /**
     * 记录时间
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
	 * 获取：就业编号
	 */
    public String getXueshengjiuyeUuidNumber() {
        return xueshengjiuyeUuidNumber;
    }


    /**
	 * 设置：就业编号
	 */
    public void setXueshengjiuyeUuidNumber(String xueshengjiuyeUuidNumber) {
        this.xueshengjiuyeUuidNumber = xueshengjiuyeUuidNumber;
    }
    /**
	 * 获取：就业地点
	 */
    public String getXueshengjiuyeAddress() {
        return xueshengjiuyeAddress;
    }


    /**
	 * 设置：就业地点
	 */
    public void setXueshengjiuyeAddress(String xueshengjiuyeAddress) {
        this.xueshengjiuyeAddress = xueshengjiuyeAddress;
    }
    /**
	 * 获取：就业公司
	 */
    public String getXueshengjiuyeGongsi() {
        return xueshengjiuyeGongsi;
    }


    /**
	 * 设置：就业公司
	 */
    public void setXueshengjiuyeGongsi(String xueshengjiuyeGongsi) {
        this.xueshengjiuyeGongsi = xueshengjiuyeGongsi;
    }
    /**
	 * 获取：就业职位
	 */
    public String getXueshengjiuyeZhiwei() {
        return xueshengjiuyeZhiwei;
    }


    /**
	 * 设置：就业职位
	 */
    public void setXueshengjiuyeZhiwei(String xueshengjiuyeZhiwei) {
        this.xueshengjiuyeZhiwei = xueshengjiuyeZhiwei;
    }
    /**
	 * 获取：就业薪资/月
	 */
    public Double getXueshengjiuyeXinzi() {
        return xueshengjiuyeXinzi;
    }


    /**
	 * 设置：就业薪资/月
	 */
    public void setXueshengjiuyeXinzi(Double xueshengjiuyeXinzi) {
        this.xueshengjiuyeXinzi = xueshengjiuyeXinzi;
    }
    /**
	 * 获取：就业时间
	 */
    public Date getJiuyeTime() {
        return jiuyeTime;
    }


    /**
	 * 设置：就业时间
	 */
    public void setJiuyeTime(Date jiuyeTime) {
        this.jiuyeTime = jiuyeTime;
    }
    /**
	 * 获取：就业备注
	 */
    public String getXueshengjiuyeContent() {
        return xueshengjiuyeContent;
    }


    /**
	 * 设置：就业备注
	 */
    public void setXueshengjiuyeContent(String xueshengjiuyeContent) {
        this.xueshengjiuyeContent = xueshengjiuyeContent;
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
