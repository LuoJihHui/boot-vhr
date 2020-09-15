package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * (Adjustsalary)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:29:05
 */
@TableName("adjustsalary")
public class AdjustSalary extends Base implements Serializable {

    private Integer eid;
    /**
     * 调薪日期
     */
    @TableField("asDate")
    private Date asDate;
    /**
     * 调前薪资
     */
    @TableField("beforeSalary")
    private Integer beforeSalary;
    /**
     * 调后薪资
     */
    @TableField("afterSalary")
    private Integer afterSalary;
    /**
     * 调薪原因
     */
    private String reason;
    /**
     * 备注
     */
    private String remark;

    @Override
    public String toString() {
        return "AdjustSalary{" +
                "eid=" + eid +
                ", asDate=" + asDate +
                ", beforeSalary=" + beforeSalary +
                ", afterSalary=" + afterSalary +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAsDate() {
        return asDate;
    }

    public void setAsDate(Date asDate) {
        this.asDate = asDate;
    }

    public Integer getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Integer beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Integer getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Integer afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}