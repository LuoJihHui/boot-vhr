package com.ljh.vhr.config;

import com.ljh.vhr.constant.SystemConstant;
import com.ljh.vhr.entity.Menu;
import com.ljh.vhr.entity.Role;
import com.ljh.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 配置色角资源权限访问
 *
 * @author LuoJiaHui
 * @date 2020/9/16 15:54
 * @description
 */
@Component
public class RoleResourcePermissionsFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> listMenus = menuService.getAllMenuWithRole();
        for (Menu menu : listMenus) {
            // 匹配资源访问路径
            List<Role> roles = menu.getRoles();
            if (antPathMatcher.match(menu.getUrl(), requestUrl) && roles.size() > 0) {
                // 配置资源所需角色
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        // 标记未匹配上的资源
        return SecurityConfig.createList(SystemConstant.ANONYMOUS_LOGO);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
