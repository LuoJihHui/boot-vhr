package com.ljh.vhr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.io.Serializable;

/**
 * (MailSendLog)实体类
 *
 * @author makejava
 * @since 2020-09-15 10:34:07
 */
@TableName("mail_send_log")
public class MailSendLog implements Serializable {

    @TableField("msgId")
    private String msgId;

    @TableField("empId")
    private Integer empId;
    /**
     * 0发送中，1发送成功，2发送失败
     */
    private Integer status;

    @TableField("routeKey")
    private String routeKey;

    private String exchange;
    /**
     * 重试次数
     */
    private Integer count;
    /**
     * 第一次重试时间
     */
    @TableField("tryTime")
    private Date tryTime;

    @TableField("createTime")
    private Date createTime;

    @TableField("updateTime")
    private Date updateTime;


    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    public Date getTryTime() {
        return tryTime;
    }

    public void setTryTime(Date tryTime) {
        this.tryTime = tryTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MailSendLog{" +
                "msgId='" + msgId + '\'' +
                ", empId=" + empId +
                ", status=" + status +
                ", routeKey='" + routeKey + '\'' +
                ", exchange='" + exchange + '\'' +
                ", count=" + count +
                ", tryTime=" + tryTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}