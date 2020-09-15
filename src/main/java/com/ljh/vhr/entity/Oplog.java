package com.ljh.vhr.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Oplog)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
public class Oplog implements Serializable {
    private static final long serialVersionUID = 768102942261315311L;
    
    private Integer id;
    /**
    * 添加日期
    */
    private Date adddate;
    /**
    * 操作内容
    */
    private String operate;
    /**
    * 操作员ID
    */
    private Integer hrid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

}