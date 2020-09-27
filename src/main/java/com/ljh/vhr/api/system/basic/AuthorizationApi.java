package com.ljh.vhr.api.system.basic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/25 11:17
 * @description
 */
@RestController
@RequestMapping("/employee/basic/auth")
public class AuthorizationApi {

    @Autowired
    private AuthorizationService authorizationService;

    /**
     * 获取所有角色信息
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @auth LuoJiaHui
     * @Date 2020/9/25 11:18
     **/
    @GetMapping("/all/role")
    public IPage<Map<String, Object>> allRoles(@RequestParam(required = false) Integer num,
                                               @RequestParam(required = false) Integer size) {
        return authorizationService.allRoles(num, size);
    }

    /**
     * 根据角色id获取菜单id
     *
     * @param
     * @return java.util.List<java.lang.Integer>
     * @auth LuoJiaHui
     * @Date 2020/9/25 14:30
     **/
    @GetMapping("/menuIdsByRoleId/{role_id}")
    public List<Integer> listMenuIdByRoleId(@PathVariable("role_id") Integer roleId) {
        return authorizationService.listMenuIdByRoleId(roleId);
    }

    /**
     * 授予菜单给角色
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 15:11
     **/
    @PutMapping("/grant/menu")
    public ResponseBean grantMenuToRole(@RequestBody Map<String, Object> params) {
        return authorizationService.grantMenuToRole(params);
    }

    /**
     * 新增角色
     *
     * @param
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 16:11
     **/
    @PostMapping("/role")
    public ResponseBean addRole(@RequestBody Map<String, String> params) {
        return authorizationService.addRole(params);
    }

    /**
     * 删除角色及其所属菜单
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/25 16:29
     **/
    @DeleteMapping("/role/{id}")
    public ResponseBean delRole(@PathVariable Integer id) {
        return authorizationService.delRole(id);
    }
}
