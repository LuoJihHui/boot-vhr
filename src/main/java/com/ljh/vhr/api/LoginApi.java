package com.ljh.vhr.api;

import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.constant.api.ResponseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuoJiaHui
 * @date 2020/9/15 13:10
 * @description
 */
@RestController
public class LoginApi {

    @GetMapping("/login")
    public ResponseBean login() {
        ResponseBean responseBean = new ResponseBean(ResponseCode.NO_LOGIN);
        responseBean.setData("尚未登录,请登录!");
        return responseBean;
    }
}
