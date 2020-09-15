package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 前端路由表中的额外自定义字段
 *
 * @author LuoJiaHui
 * @date 2020/9/15 17:28
 * @description
 */
public class Meta {

    @TableField("keepAlive")
    private Boolean keepalive;

    @TableField("requireAuth")
    private Boolean requireAuth;

    public Boolean getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "keepalive=" + keepalive +
                ", requireAuth=" + requireAuth +
                '}';
    }
}
