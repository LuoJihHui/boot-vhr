package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Sysmsg)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("sysmsg")
public class SysMsg extends Base implements Serializable {

    /**
     * 消息id
     */
    private Integer mid;
    /**
     * 0表示群发消息
     */
    private Integer type;
    /**
     * 这条消息是给谁的
     */
    @TableField("hrid")
    private Integer hrId;
    /**
     * 0 未读 1 已读
     */
    private Integer state;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SysMsg{" +
                "mid=" + mid +
                ", type=" + type +
                ", hrId=" + hrId +
                ", state=" + state +
                '}';
    }
}