package com.ljh.vhr.constant.api;

/**
 * @author LuoJiaHui
 * @date 2020/9/15 12:36
 * @description
 */
public class ResponseBean {

    private Integer code = 0;
    private String msg = "success";
    private Object data;

    public ResponseBean() {
    }

    public ResponseBean(Object data) {
        this.setData(data);
    }

    public ResponseBean(ResponseCode code) {
        this.setCode(code.getCode());
        this.setMsg(code.getMsg());
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
