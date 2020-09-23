package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * (Position)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("position")
public class Position extends Base implements Serializable {

    /**
     * 职位
     */
    private String name;

    @TableField("createDate")
//    @JsonFormat(pattern = SystemConstant.DEFAULT_DATE_FORMAT, timezone = SystemConstant.DEFAULT_TIME_ZONE)
    private Date createDate;

    private Boolean enabled;

    private Date updateDate;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                ", updateDate=" + updateDate +
                '}';
    }
}