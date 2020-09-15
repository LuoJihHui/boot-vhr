package com.ljh.vhr.entity;

import java.io.Serializable;

/**
 * (Nation)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
public class Nation implements Serializable {
    private static final long serialVersionUID = -31082413950653528L;
    
    private Integer id;
    
    private String name;


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

}