package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (MenuRole)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("menu_role")
public class MenuRole extends Base implements Serializable {

    private Integer mid;

    private Integer rid;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "MenuRole{" +
                "mid=" + mid +
                ", rid=" + rid +
                '}';
    }
}