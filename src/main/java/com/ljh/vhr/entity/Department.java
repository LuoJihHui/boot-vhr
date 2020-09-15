package com.ljh.vhr.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 336493910360861280L;
    
    private Integer id;
    /**
    * 部门名称
    */
    private String name;
    
    private Integer parentid;
    
    private String deppath;
    
    private Boolean enabled;
    
    private Boolean isparent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDeppath() {
        return deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIsparent() {
        return isparent;
    }

    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }

}