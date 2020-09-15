package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Empsalary)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("empsalary")
public class EmpSalary extends Base implements Serializable {

    private Integer eid;
    
    private Integer sid;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "EmpSalary{" +
                "eid=" + eid +
                ", sid=" + sid +
                '}';
    }
}