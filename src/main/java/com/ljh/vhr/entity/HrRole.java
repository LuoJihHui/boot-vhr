package com.ljh.vhr.entity;

import java.io.Serializable;

/**
 * (HrRole)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
public class HrRole implements Serializable {
    private static final long serialVersionUID = 798769571608492790L;
    
    private Integer id;
    
    private Integer hrid;
    
    private Integer rid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}