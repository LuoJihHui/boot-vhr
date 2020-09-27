package com.ljh.vhr.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljh.vhr.entity.Hr;
import com.ljh.vhr.entity.Menu;
import com.ljh.vhr.mapper.MenuMapper;
import com.ljh.vhr.service.MenuService;
import com.ljh.vhr.util.CommonUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author LuoJiaHui
 * @date 2020/9/16 9:11
 * @description
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 获取列表菜单树
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/15 17:37
     **/
    @Override
    public List<Map<String, Object>> listMenuTree() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Menu> menus = menuMapper.loadMenuByUserId(hr.getId());
        return menus.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
    }

    /**
     * 获取所有菜单及其角色信息
     *
     * @param
     * @return java.util.List<com.ljh.vhr.entity.Menu>
     * @auth LuoJiaHui
     * @Date 2020/9/16 15:57
     **/
    @Override
    @Cacheable("menus:")
    public List<Menu> getAllMenuWithRole() {
        return menuMapper.allMenu();
    }

    /**
     * 获取所有菜单-树状结构
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/25 13:45
     **/
    @Override
    public List<Map<String, Object>> listAllMenuTree() {
        // 加载所有可用菜单
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.select("id,path,name,requireAuth,iconCls,keepAlive,parentId").eq("enabled", true);
        List<Map<String, Object>> maps = menuMapper.selectMaps(wrapper);
        return CommonUtils.outTreeMenu(maps);
    }
}
