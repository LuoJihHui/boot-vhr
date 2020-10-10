package com.ljh.vhr.service;

import com.ljh.vhr.constant.api.ResponseBean;

import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/27 11:14
 * @description
 */
public interface DepartmentService {

    /**
     * 树状组织结构
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/27 11:14
     **/
    List<Map<String, Object>> allDepartmentTree();

    /**
     * 添加组织节点
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/27 14:31
     **/
    ResponseBean addDepartment(Map<String, Object> params);

    /**
     * 删除组织
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/27 14:16
     **/
    ResponseBean delDepartment(Integer id);
}
