package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (Oplog)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("oplog")
public class OpLog extends Base implements Serializable {

    /**
     * 添加日期
     */
    @TableField("addDate")
    private Date addDate;
    /**
     * 操作内容
     */
    private String operate;
    /**
     * 操作员ID
     */
    @TableField("hrid")
    private Integer hrId;

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    @Override
    public String toString() {
        return "OpLog{" +
                "addDate=" + addDate +
                ", operate='" + operate + '\'' +
                ", hrId=" + hrId +
                '}';
    }
}