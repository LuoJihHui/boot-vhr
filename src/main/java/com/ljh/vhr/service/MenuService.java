package com.ljh.vhr.service;

import com.ljh.vhr.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/16 9:10
 * @description
 */
public interface MenuService {

    /**
     * 获取列表菜单树
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/15 17:37
     **/
    List<Map<String, Object>> listMenuTree();

    /**
     * 获取所有菜单及其角色信息
     *
     * @param
     * @return java.util.List<com.ljh.vhr.entity.Menu>
     * @auth LuoJiaHui
     * @Date 2020/9/16 15:57
     **/
    List<Menu> getAllMenuWithRole();
}
