package com.ljh.vhr.service;

import com.ljh.vhr.constant.api.ResponseBean;

import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/10/10 17:17
 * @description
 */
public interface HrService {

    List<Map<String, Object>> listAllHr(String keywords);


    /**
     * 更新hr
     *
     * @param hr
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/10/27 16:17
     **/
    ResponseBean updateHr(Map<String, Object> hr);

    /**
     * 更新hr的角色信息
     *
     * @param param
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/10/28 10:56
     **/
    ResponseBean updateRolesByHrId(Map<String, Object> param);

    /**
     * 删除hr
     *
     * @param hrId
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/10/28 11:20
     **/
    ResponseBean delHr(String hrId);
}
