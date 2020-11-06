package com.ljh.vhr.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.entity.MenuRole;
import com.ljh.vhr.entity.Role;
import com.ljh.vhr.exception.ParamsNullException;
import com.ljh.vhr.mapper.MenuRoleMapper;
import com.ljh.vhr.mapper.RoleMapper;
import com.ljh.vhr.service.AuthorizationService;
import com.ljh.vhr.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author LuoJiaHui
 * @date 2020/9/25 11:18
 * @description
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private MenuRoleMapper menuRoleMapper;
    @Autowired
    private MenuRoleService menuRoleService;

    /**
     * 获取所有角色信息
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @auth LuoJiaHui
     * @Date 2020/9/25 11:18
     **/
    @Override
    public IPage<Map<String, Object>> allRoles(Integer num, Integer size) {
        Page<Role> page = new Page<>(num == null ? 1 : num, size == null ? 10 : size);
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("enabled", true);
        return roleMapper.selectMapsPage(page, roleQueryWrapper);
    }

    /**
     * 根据角色id获取菜单id
     *
     * @param
     * @return java.util.List<java.lang.Integer>
     * @auth LuoJiaHui
     * @Date 2020/9/25 14:30
     **/
    @Override
    public List<Integer> listMenuIdByRoleId(Integer roleId) {
        QueryWrapper<MenuRole> wrapper = new QueryWrapper<>();
        wrapper.eq("rid", roleId);
        List<MenuRole> menuRoles = menuRoleMapper.selectList(wrapper);
        return menuRoles.stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    /**
     * 授予菜单给角色
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 15:11
     **/
    @Override
    @Transactional
    public ResponseBean grantMenuToRole(Map<String, Object> params) {
        Integer rid = Convert.toInt(params.get("rid"));
        List<Integer> mids = (List<Integer>) Convert.toList(params.get("mid"));

        // 删除当前角色的菜单信息,重新授权
        QueryWrapper<MenuRole> wrapper = new QueryWrapper<>();
        wrapper.eq("rid", rid);
        menuRoleService.remove(wrapper);
        List<MenuRole> menuRoles = mids.stream().map(mid -> new MenuRole(mid, rid)).collect(Collectors.toList());
        boolean save = menuRoleService.saveBatch(menuRoles);
        return new ResponseBean(save ? "授予角色菜单成功!" : "系统繁忙,请稍后再试", save);
    }

    /**
     * 新增角色
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 16:11
     **/
    @Override
    public ResponseBean addRole(Map<String, String> params) {
        String nameZh = params.get("nameZh");
        String name = params.get("name");
        if (StrUtil.isBlank(name) || StrUtil.isBlank(nameZh)) {
            throw new ParamsNullException("");
        }
        if (!(name.startsWith("ROLE_") || name.startsWith("role_"))) {
            name = "ROLE_" + name;
        }
        roleMapper.resetAutoIncrement();
        Role role = new Role(name, nameZh);
        boolean b = roleMapper.insert(role) > 0;
        return new ResponseBean("添加角色成功!", b);
    }

    /**
     * 删除角色
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 16:29
     **/
    @Override
    @Transactional
    public ResponseBean delRole(Integer id) {
        // 禁用角色
        Role role = new Role();
        role.setId(id);
        role.setEnabled(false);
        boolean delRole = roleMapper.updateById(role) > 0;

        QueryWrapper<MenuRole> menuRoleQueryWrapper = new QueryWrapper<>();
        menuRoleQueryWrapper.eq("rid", id);
        menuRoleMapper.delete(menuRoleQueryWrapper);
        return new ResponseBean("删除角色成功!", delRole);
    }
}
