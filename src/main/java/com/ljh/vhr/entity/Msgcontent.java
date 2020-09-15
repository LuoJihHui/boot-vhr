package com.ljh.vhr.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Msgcontent)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
public class Msgcontent implements Serializable {
    private static final long serialVersionUID = 372277028001562791L;
    
    private Integer id;
    
    private String title;
    
    private String message;
    
    private Date createdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

}