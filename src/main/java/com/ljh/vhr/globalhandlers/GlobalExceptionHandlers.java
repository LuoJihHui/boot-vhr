package com.ljh.vhr.globalhandlers;

import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.constant.api.ResponseCode;
import com.ljh.vhr.exception.BasicException;
import com.ljh.vhr.exception.ParamsNullException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常或解析报错拦截处理
 *
 * @author luojiahui
 * @date 2019/9/11 16:02
 */
@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandlers {
    /**
     * 自定义通用异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BasicException.class)
    @ResponseBody
    public ResponseBean handleCommonException(BasicException exception) {
        exception.printStackTrace();
        ResponseBean responseBean = new ResponseBean(ResponseCode.ERROR);
        responseBean.setMsg(exception.getMessage());
        return responseBean;
    }

    /**
     * 参数空异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ParamsNullException.class)
    @ResponseBody
    public ResponseBean handleCommonException(ParamsNullException exception) {
        exception.printStackTrace();
        ResponseBean responseBean = new ResponseBean(ResponseCode.PARAMS_NULL);
        responseBean.setMsg("请求参数不能为空!");
        return responseBean;
    }
}
