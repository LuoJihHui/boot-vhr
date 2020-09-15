package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Politicsstatus)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("politicsstatus")
public class PoliticsStatus extends Base implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PoliticsStatus{" +
                "name='" + name + '\'' +
                '}';
    }
}