package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Salary)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("salary")
public class Salary extends Base implements Serializable {

    /**
     * 基本工资
     */
    @TableField("basicSalary")
    private Integer basicSalary;
    /**
     * 奖金
     */
    private Integer bonus;
    /**
     * 午餐补助
     */
    @TableField("lunchSalary")
    private Integer lunchSalary;
    /**
     * 交通补助
     */
    @TableField("trafficSalary")
    private Integer trafficSalary;
    /**
     * 应发工资
     */
    @TableField("allSalary")
    private Integer allSalary;
    /**
     * 养老金基数
     */
    @TableField("pensionBase")
    private Integer pensionBase;
    /**
     * 养老金比率
     */
    @TableField("pensionPer")
    private Float pensionPer;
    /**
     * 启用时间
     */
    @TableField("createDate")
    private Date createDate;
    /**
     * 医疗基数
     */
    @TableField("medicalBase")
    private Integer medicalBase;
    /**
     * 医疗保险比率
     */
    @TableField("medicalPer")
    private Float medicalPer;
    /**
     * 公积金基数
     */
    @TableField("accumulationFundBase")
    private Integer accumulationFundBase;
    /**
     * 公积金比率
     */
    @TableField("accumulationFundPer")
    private Float accumulationFundPer;

    private String name;

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getLunchSalary() {
        return lunchSalary;
    }

    public void setLunchSalary(Integer lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public Integer getTrafficSalary() {
        return trafficSalary;
    }

    public void setTrafficSalary(Integer trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public Integer getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(Integer allSalary) {
        this.allSalary = allSalary;
    }

    public Integer getPensionBase() {
        return pensionBase;
    }

    public void setPensionBase(Integer pensionBase) {
        this.pensionBase = pensionBase;
    }

    public Float getPensionPer() {
        return pensionPer;
    }

    public void setPensionPer(Float pensionPer) {
        this.pensionPer = pensionPer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalBase(Integer medicalBase) {
        this.medicalBase = medicalBase;
    }

    public Float getMedicalPer() {
        return medicalPer;
    }

    public void setMedicalPer(Float medicalPer) {
        this.medicalPer = medicalPer;
    }

    public Integer getAccumulationFundBase() {
        return accumulationFundBase;
    }

    public void setAccumulationFundBase(Integer accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }

    public Float getAccumulationFundPer() {
        return accumulationFundPer;
    }

    public void setAccumulationFundPer(Float accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "basicSalary=" + basicSalary +
                ", bonus=" + bonus +
                ", lunchSalary=" + lunchSalary +
                ", trafficSalary=" + trafficSalary +
                ", allSalary=" + allSalary +
                ", pensionBase=" + pensionBase +
                ", pensionPer=" + pensionPer +
                ", createDate=" + createDate +
                ", medicalBase=" + medicalBase +
                ", medicalPer=" + medicalPer +
                ", accumulationFundBase=" + accumulationFundBase +
                ", accumulationFundPer=" + accumulationFundPer +
                ", name='" + name + '\'' +
                '}';
    }
}