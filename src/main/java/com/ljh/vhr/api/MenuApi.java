package com.ljh.vhr.api;

import com.ljh.vhr.entity.Menu;
import com.ljh.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MenuService menuService;

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
        return menuService.listMenuTree();
    }

    /**
     * 获取所有菜单及其角色
     *
     * @param
     * @return java.util.List<com.ljh.vhr.entity.Menu>
     * @auth LuoJiaHui
     * @Date 2020/9/16 16:49
     **/
    @GetMapping("/all")
    public List<Menu> getAll() {
        return menuService.getAllMenuWithRole();
    }

    /**
     * 获取所有菜单-树状结构
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/25 13:45
     **/
    @GetMapping("/all/tree")
    public List<Map<String, Object>> listAllMenuTree() {
        return menuService.listAllMenuTree();
    }
}
