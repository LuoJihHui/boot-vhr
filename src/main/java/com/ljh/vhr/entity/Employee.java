package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("employee")
public class Employee extends Base implements Serializable {
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 身份证号
     */
    @TableField("idCard")
    private String idCard;
    /**
     * 婚姻状况
     */
    private Object wedlock;
    /**
     * 民族
     */
    @TableField("nationId")
    private Integer nationId;
    /**
     * 籍贯
     */
    @TableField("nativePlace")
    private String nativePlace;
    /**
     * 政治面貌
     */
    @TableField("politicId")
    private Integer politicId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 所属部门
     */
    @TableField("departmentId")
    private Integer departmentId;
    /**
     * 职称ID
     */
    @TableField("jobLevelId")
    private Integer jobLevelId;
    /**
     * 职位ID
     */
    @TableField("posId")
    private Integer posId;
    /**
     * 聘用形式
     */
    @TableField("engageForm")
    private String engageForm;
    /**
     * 最高学历
     */
    @TableField("tiptopDegree")
    private Object tiptopDegree;
    /**
     * 所属专业
     */
    private String specialty;
    /**
     * 毕业院校
     */
    private String school;
    /**
     * 入职日期
     */
    @TableField("beginDate")
    private Date beginDate;
    /**
     * 在职状态
     */
    @TableField("workState")
    private Object workState;
    /**
     * 工号
     */
    @TableField("workID")
    private String workID;
    /**
     * 合同期限
     */
    @TableField("contractTerm")
    private Object contractTerm;
    /**
     * 转正日期
     */
    @TableField("conversionTime")
    private Date conversionTime;
    /**
     * 离职日期
     */
    @TableField("notWorkDate")
    private Date notWorkDate;
    /**
     * 合同起始日期
     */
    @TableField("beginContract")
    private Date beginContract;
    /**
     * 合同终止日期
     */
    @TableField("endContract")
    private Date endContract;
    /**
     * 工龄
     */
    @TableField("workAge")
    private Integer workAge;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Object getWedlock() {
        return wedlock;
    }

    public void setWedlock(Object wedlock) {
        this.wedlock = wedlock;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getPoliticId() {
        return politicId;
    }

    public void setPoliticId(Integer politicId) {
        this.politicId = politicId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(Integer jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public Object getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(Object tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Object getWorkState() {
        return workState;
    }

    public void setWorkState(Object workState) {
        this.workState = workState;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public Object getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Object contractTerm) {
        this.contractTerm = contractTerm;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Date getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public Date getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", wedlock=" + wedlock +
                ", nationId=" + nationId +
                ", nativePlace='" + nativePlace + '\'' +
                ", politicId=" + politicId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", departmentId=" + departmentId +
                ", jobLevelId=" + jobLevelId +
                ", posId=" + posId +
                ", engageForm='" + engageForm + '\'' +
                ", tiptopDegree=" + tiptopDegree +
                ", specialty='" + specialty + '\'' +
                ", school='" + school + '\'' +
                ", beginDate=" + beginDate +
                ", workState=" + workState +
                ", workID='" + workID + '\'' +
                ", contractTerm=" + contractTerm +
                ", conversionTime=" + conversionTime +
                ", notWorkDate=" + notWorkDate +
                ", beginContract=" + beginContract +
                ", endContract=" + endContract +
                ", workAge=" + workAge +
                '}';
    }
}