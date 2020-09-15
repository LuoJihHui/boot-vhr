package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Employeeremove)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("employeeremove")
public class EmployeeRemove extends Base implements Serializable {

    private Integer eid;
    /**
     * 调动后部门
     */
    @TableField("afterDepId")
    private Integer afterDepId;
    /**
     * 调动后职位
     */
    @TableField("afterJobId")
    private Integer afterJobId;
    /**
     * 调动日期
     */
    @TableField("removeDate")
    private Date removeDate;
    /**
     * 调动原因
     */
    private String reason;

    private String remark;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getAfterDepId() {
        return afterDepId;
    }

    public void setAfterDepId(Integer afterDepId) {
        this.afterDepId = afterDepId;
    }

    public Integer getAfterJobId() {
        return afterJobId;
    }

    public void setAfterJobId(Integer afterJobId) {
        this.afterJobId = afterJobId;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
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

    @Override
    public String toString() {
        return "EmployeeRemove{" +
                "eid=" + eid +
                ", afterDepId=" + afterDepId +
                ", afterJobId=" + afterJobId +
                ", removeDate=" + removeDate +
                ", reason='" + reason + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}