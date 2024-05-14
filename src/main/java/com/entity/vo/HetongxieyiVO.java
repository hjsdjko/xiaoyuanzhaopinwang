package com.entity.vo;

import com.entity.HetongxieyiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 合同协议
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hetongxieyi")
public class HetongxieyiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 协议编号
     */

    @TableField(value = "hetongxieyi_uuid_number")
    private String hetongxieyiUuidNumber;


    /**
     * 公司
     */

    @TableField(value = "gongsi_id")
    private Integer gongsiId;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 协议标题
     */

    @TableField(value = "hetongxieyi_biaoti")
    private String hetongxieyiBiaoti;


    /**
     * 协议类型
     */

    @TableField(value = "hetongxieyi_types")
    private Integer hetongxieyiTypes;


    /**
     * 协议文件
     */

    @TableField(value = "hetongxieyi_file")
    private String hetongxieyiFile;


    /**
     * 协议签订时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qianding_time")
    private Date qiandingTime;


    /**
     * 协议详情
     */

    @TableField(value = "hetongxieyi_content")
    private String hetongxieyiContent;


    /**
     * 记录时间
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
	 * 设置：协议编号
	 */
    public String getHetongxieyiUuidNumber() {
        return hetongxieyiUuidNumber;
    }


    /**
	 * 获取：协议编号
	 */

    public void setHetongxieyiUuidNumber(String hetongxieyiUuidNumber) {
        this.hetongxieyiUuidNumber = hetongxieyiUuidNumber;
    }
    /**
	 * 设置：公司
	 */
    public Integer getGongsiId() {
        return gongsiId;
    }


    /**
	 * 获取：公司
	 */

    public void setGongsiId(Integer gongsiId) {
        this.gongsiId = gongsiId;
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
	 * 设置：协议标题
	 */
    public String getHetongxieyiBiaoti() {
        return hetongxieyiBiaoti;
    }


    /**
	 * 获取：协议标题
	 */

    public void setHetongxieyiBiaoti(String hetongxieyiBiaoti) {
        this.hetongxieyiBiaoti = hetongxieyiBiaoti;
    }
    /**
	 * 设置：协议类型
	 */
    public Integer getHetongxieyiTypes() {
        return hetongxieyiTypes;
    }


    /**
	 * 获取：协议类型
	 */

    public void setHetongxieyiTypes(Integer hetongxieyiTypes) {
        this.hetongxieyiTypes = hetongxieyiTypes;
    }
    /**
	 * 设置：协议文件
	 */
    public String getHetongxieyiFile() {
        return hetongxieyiFile;
    }


    /**
	 * 获取：协议文件
	 */

    public void setHetongxieyiFile(String hetongxieyiFile) {
        this.hetongxieyiFile = hetongxieyiFile;
    }
    /**
	 * 设置：协议签订时间
	 */
    public Date getQiandingTime() {
        return qiandingTime;
    }


    /**
	 * 获取：协议签订时间
	 */

    public void setQiandingTime(Date qiandingTime) {
        this.qiandingTime = qiandingTime;
    }
    /**
	 * 设置：协议详情
	 */
    public String getHetongxieyiContent() {
        return hetongxieyiContent;
    }


    /**
	 * 获取：协议详情
	 */

    public void setHetongxieyiContent(String hetongxieyiContent) {
        this.hetongxieyiContent = hetongxieyiContent;
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

}
