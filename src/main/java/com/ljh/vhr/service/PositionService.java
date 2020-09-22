package com.ljh.vhr.service;

import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/22 15:23
 * @description
 */
public interface PositionService {

    /**
     * 查询职位列表
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @auth LuoJiaHui
     * @Date 2020/9/22 15:24
     **/
    List<Map<String, Object>> listPositions();

    /**
     * 添加职位
     *
     * @param map
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:22
     **/
    Boolean position(Map<String, Object> map);

    /**
     * 更新职位
     *
     * @param map
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:30
     **/
    Boolean updatePosition(Map<String, Object> map);

    /**
     * 禁用职位
     *
     * @param id
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:32
     **/
    Boolean delPosition(String id);
}
