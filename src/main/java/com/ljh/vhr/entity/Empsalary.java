package com.ljh.vhr.entity;

import java.io.Serializable;

/**
 * (Empsalary)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
public class Empsalary implements Serializable {
    private static final long serialVersionUID = 827601895228090214L;
    
    private Integer id;
    
    private Integer eid;
    
    private Integer sid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

}