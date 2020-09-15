package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Employeetrain)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("employeetrain")
public class EmployeeTrain extends Base implements Serializable {

    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 培训日期
     */
    @TableField("trainDate")
    private Date trainDate;
    /**
     * 培训内容
     */
    @TableField("trainContent")
    private String trainContent;
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

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "EmployeeTrain{" +
                "eid=" + eid +
                ", trainDate=" + trainDate +
                ", trainContent='" + trainContent + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}