package com.entity.model;

import com.entity.HetongxieyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 合同协议
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HetongxieyiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 协议编号
     */
    private String hetongxieyiUuidNumber;


    /**
     * 公司
     */
    private Integer gongsiId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 协议标题
     */
    private String hetongxieyiBiaoti;


    /**
     * 协议类型
     */
    private Integer hetongxieyiTypes;


    /**
     * 协议文件
     */
    private String hetongxieyiFile;


    /**
     * 协议签订时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qiandingTime;


    /**
     * 协议详情
     */
    private String hetongxieyiContent;


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
	 * 获取：协议编号
	 */
    public String getHetongxieyiUuidNumber() {
        return hetongxieyiUuidNumber;
    }


    /**
	 * 设置：协议编号
	 */
    public void setHetongxieyiUuidNumber(String hetongxieyiUuidNumber) {
        this.hetongxieyiUuidNumber = hetongxieyiUuidNumber;
    }
    /**
	 * 获取：公司
	 */
    public Integer getGongsiId() {
        return gongsiId;
    }


    /**
	 * 设置：公司
	 */
    public void setGongsiId(Integer gongsiId) {
        this.gongsiId = gongsiId;
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
	 * 获取：协议标题
	 */
    public String getHetongxieyiBiaoti() {
        return hetongxieyiBiaoti;
    }


    /**
	 * 设置：协议标题
	 */
    public void setHetongxieyiBiaoti(String hetongxieyiBiaoti) {
        this.hetongxieyiBiaoti = hetongxieyiBiaoti;
    }
    /**
	 * 获取：协议类型
	 */
    public Integer getHetongxieyiTypes() {
        return hetongxieyiTypes;
    }


    /**
	 * 设置：协议类型
	 */
    public void setHetongxieyiTypes(Integer hetongxieyiTypes) {
        this.hetongxieyiTypes = hetongxieyiTypes;
    }
    /**
	 * 获取：协议文件
	 */
    public String getHetongxieyiFile() {
        return hetongxieyiFile;
    }


    /**
	 * 设置：协议文件
	 */
    public void setHetongxieyiFile(String hetongxieyiFile) {
        this.hetongxieyiFile = hetongxieyiFile;
    }
    /**
	 * 获取：协议签订时间
	 */
    public Date getQiandingTime() {
        return qiandingTime;
    }


    /**
	 * 设置：协议签订时间
	 */
    public void setQiandingTime(Date qiandingTime) {
        this.qiandingTime = qiandingTime;
    }
    /**
	 * 获取：协议详情
	 */
    public String getHetongxieyiContent() {
        return hetongxieyiContent;
    }


    /**
	 * 设置：协议详情
	 */
    public void setHetongxieyiContent(String hetongxieyiContent) {
        this.hetongxieyiContent = hetongxieyiContent;
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
