package com.ljh.vhr.excelmodel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.lang.String;

/**
 * Excel导出模型
 * 员工信息管理
 *
 * @author LuoJiaHui
 * @date 2020/10/30 17:06
 * @description
 */
public class EmployeeModel {

    @ExcelProperty(value = "序号", index = 0)
    private Integer index;
    @ExcelProperty(value = "姓名", index = 1)
    private String name;
    @ExcelProperty(value = "性别", index = 2)
    private String gender;
    @ExcelProperty(value = "出生日期", index = 3)
    private String birthday;
    @ExcelProperty(value = "身份证号", index = 4)
    private String idCard;
    @ExcelProperty(value = "婚姻状况", index = 5)
    private String wedlock;
    @ExcelProperty(value = "民族", index = 6)
    private String nationName;
    @ExcelProperty(value = "籍贯", index = 7)
    private String nativePlace;
    @ExcelProperty(value = "政治面貌", index = 8)
    private String politicName;
    @ExcelProperty(value = "邮箱", index = 9)
    private String email;
    @ExcelProperty(value = "电话号码", index = 10)
    private String phone;
    @ExcelProperty(value = "联系地址", index = 11)
    private String address;
    @ExcelProperty(value = "所属部门", index = 12)
    private String departmentName;
    @ExcelProperty(value = "职称", index = 13)
    private String jobLevelName;
    @ExcelProperty(value = "职位", index = 14)
    private String posName;
    @ExcelProperty(value = "聘用形式", index = 15)
    private String engageForm;
    @ExcelProperty(value = "最高学历", index = 16)
    private String tiptopDegree;
    @ExcelProperty(value = "所属专业", index = 17)
    private String specialty;
    @ExcelProperty(value = "毕业院校", index = 18)
    private String school;
    @ExcelProperty(value = "入职日期", index = 19)
    private String beginDate;
    @ExcelProperty(value = "在职状态", index = 20)
    private String workState;
    @ExcelProperty(value = "工号", index = 21)
    private String workID;
    @ExcelProperty(value = "合同期限", index = 22)
    private String contractTerm;
    @ExcelProperty(value = "转正日期", index = 23)
    private String conversionTime;
    @ExcelProperty(value = "离职日期", index = 24)
    private String notWorkDate;
    @ExcelProperty(value = "合同起始日期", index = 25)
    private String beginContract;
    @ExcelProperty(value = "合同终止日期", index = 26)
    private String endContract;
    @ExcelProperty(value = "工龄",index = 27)
    private String workAge;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
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

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }


    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(String contractTerm) {
        this.contractTerm = contractTerm;
    }

    public String getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(String conversionTime) {
        this.conversionTime = conversionTime;
    }

    public String getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(String notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public String getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(String beginContract) {
        this.beginContract = beginContract;
    }

    public String getEndContract() {
        return endContract;
    }

    public void setEndContract(String endContract) {
        this.endContract = endContract;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkAge() {
        return workAge;
    }

    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getPoliticName() {
        return politicName;
    }

    public void setPoliticName(String politicName) {
        this.politicName = politicName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobLevelName() {
        return jobLevelName;
    }

    public void setJobLevelName(String jobLevelName) {
        this.jobLevelName = jobLevelName;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }
}
