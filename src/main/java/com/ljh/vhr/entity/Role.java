package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("role")
public class Role extends Base implements Serializable {

    private String name;
    /**
     * 角色名称
     */
    @TableField("nameZh")
    private String nameZh;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                '}';
    }
}