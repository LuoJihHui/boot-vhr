package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * (Appraise)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:33:55
 */
@TableName("appraise")
public class Appraise extends Base implements Serializable {

    private Integer eid;
    /**
     * 考评日期
     */
    @TableField("appDate")
    private Date appDate;
    /**
     * 考评结果
     */
    @TableField("appResult")
    private String appResult;
    /**
     * 考评内容
     */
    @TableField("appContent")
    private String appContent;
    /**
     * 备注
     */
    private String remark;

    @Override
    public String toString() {
        return "Appraise{" +
                "eid=" + eid +
                ", appDate=" + appDate +
                ", appResult='" + appResult + '\'' +
                ", appContent='" + appContent + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getAppResult() {
        return appResult;
    }

    public void setAppResult(String appResult) {
        this.appResult = appResult;
    }

    public String getAppContent() {
        return appContent;
    }

    public void setAppContent(String appContent) {
        this.appContent = appContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}