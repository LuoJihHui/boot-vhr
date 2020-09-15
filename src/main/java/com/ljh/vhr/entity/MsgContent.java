package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Msgcontent)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("msgcontent")
public class MsgContent extends Base implements Serializable {

    private String title;

    private String message;

    @TableField("createDate")
    private Date createDate;


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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "MsgContent{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}