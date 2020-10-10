package com.ljh.vhr.api.system.basic;

import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 部门管理API
 *
 * @author LuoJiaHui
 * @date 2020/9/27 11:12
 * @description
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentApi {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 树状组织结构
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/27 11:14
     **/
    @GetMapping
    public List<Map<String, Object>> allDepartmentTree() {
        return departmentService.allDepartmentTree();
    }

    /**
     * 添加组织节点
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/27 14:31
     **/
    @PostMapping
    public ResponseBean addDepartment(@RequestBody Map<String, Object> params) {
        return departmentService.addDepartment(params);
    }

    /**
     * 删除组织
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/27 14:16
     **/
    @DeleteMapping("/{id}")
    public ResponseBean delDepartment(@PathVariable Integer id) {
        return departmentService.delDepartment(id);
    }
}
