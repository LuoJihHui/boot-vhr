package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Joblevel)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("joblevel")
public class JobLevel extends Base implements Serializable {

    /**
     * 职称名称
     */
    private String name;

    @TableField("titleLevel")
    private String titleLevel;

    @TableField("createDate")
    private Date createDate;

    private Boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "JobLevel{" +
                "name='" + name + '\'' +
                ", titleLevel='" + titleLevel + '\'' +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                '}';
    }
}