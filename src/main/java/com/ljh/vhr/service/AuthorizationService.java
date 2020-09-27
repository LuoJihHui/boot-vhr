package com.ljh.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ljh.vhr.constant.api.ResponseBean;

import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/25 11:18
 * @description
 */
public interface AuthorizationService {

    /**
     * 获取所有角色信息
     *
     * @param num
     * @param size
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @auth LuoJiaHui
     * @Date 2020/9/25 11:18
     **/
    IPage<Map<String, Object>> allRoles(Integer num, Integer size);

    /**
     * 根据角色id获取菜单id
     *
     * @param roleId
     * @return java.util.List<java.lang.Integer>
     * @auth LuoJiaHui
     * @Date 2020/9/25 14:30
     **/
    List<Integer> listMenuIdByRoleId(Integer roleId);

    /**
     * 授予菜单给角色
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 15:11
     **/
    ResponseBean grantMenuToRole(Map<String, Object> params);

    /**
     * 新增角色
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 16:11
     **/
    ResponseBean addRole(Map<String, String> params);

    /**
     * 删除角色
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 16:29
     **/
    ResponseBean delRole(Integer id);
}
