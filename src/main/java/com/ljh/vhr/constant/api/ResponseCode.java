package com.ljh.vhr.constant.api;

/**
 * @author LuoJiaHui
 * @date 2020/9/15 12:37
 * @description
 */
public enum ResponseCode {
    /**
     * 基础错误
     *
     * @auth LuoJiaHui
     * @Date 2020/9/15 12:41
     **/
    ERROR(-1, "error"),
    NO_LOGIN(40001, "Not logged in yet"),
    PROCESS(403, "Resolve processing current request"),
    NO_DATA_FOUND(40010, "No data found");

    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
