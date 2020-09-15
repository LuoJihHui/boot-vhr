package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (HrRole)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("hr_role")
public class HrRole extends Base implements Serializable {

    @TableField("hrid")
    private Integer hrId;

    private Integer rid;

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "HrRole{" +
                "hrId=" + hrId +
                ", rid=" + rid +
                '}';
    }
}