package com.ljh.vhr.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuoJiaHui
 * @date 2020/9/15 12:28
 * @description
 */
@RestController
@RequestMapping("hr")
public class HrApi {

    @GetMapping("hello")
    public String hello() {
        return "hello hr";
    }
}
