package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Employeeec)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("employeeec")
public class EmployeeC extends Base implements Serializable {

    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 奖罚日期
     */
    @TableField("ecDate")
    private Date ecDate;
    /**
     * 奖罚原因
     */
    @TableField("ecReason")
    private String ecReason;
    /**
     * 奖罚分
     */
    @TableField("ecPoint")
    private Integer ecPoint;
    /**
     * 奖罚类别，0：奖，1：罚
     */
    @TableField("ecType")
    private Integer ecType;
    /**
     * 备注
     */
    private String remark;


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getEcDate() {
        return ecDate;
    }

    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }

    public String getEcReason() {
        return ecReason;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }

    public Integer getEcPoint() {
        return ecPoint;
    }

    public void setEcPoint(Integer ecPoint) {
        this.ecPoint = ecPoint;
    }

    public Integer getEcType() {
        return ecType;
    }

    public void setEcType(Integer ecType) {
        this.ecType = ecType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "EmployeeC{" +
                "eid=" + eid +
                ", ecDate=" + ecDate +
                ", ecReason='" + ecReason + '\'' +
                ", ecPoint=" + ecPoint +
                ", ecType=" + ecType +
                ", remark='" + remark + '\'' +
                '}';
    }
}