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

    List<Map<String, Object>> listAllHr();


    /**
     * 更新hr
     *
     * @param hr
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/10/27 16:17
     **/
    ResponseBean updateHr(Map<String, Object> hr);
}
