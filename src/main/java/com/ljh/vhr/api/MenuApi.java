package com.ljh.vhr.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 菜单接口
 *
 * @author LuoJiaHui
 * @date 2020/9/15 17:27
 * @description
 */
@RestController
@RequestMapping("/menu")
public class MenuApi {

    /**
     * 获取列表菜单树
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/15 17:37
     **/
    @GetMapping("/tree/info")
    public List<Map<String, Object>> listMenuTree() {
        return null;
    }
}
