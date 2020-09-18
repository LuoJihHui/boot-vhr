package com.ljh.vhr.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hr相关
 *
 * @author LuoJiaHui
 * @date 2020/9/15 12:28
 * @description
 */
@RestController
public class HrApi {

    @GetMapping("hello")
    public String hello() {
        return "hello hr";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2() {
        return "hello SecurityAuth";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3() {
        return "hello employee/advanced";
    }
}
