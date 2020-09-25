package com.ljh.vhr.service;

import com.ljh.vhr.constant.api.ResponseBean;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    ResponseBean position(Map<String, Object> map);

    /**
     * 更新职位
     *
     * @param map
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:30
     **/
    ResponseBean updatePosition(Map<String, Object> map);

    /**
     * 禁用职位
     *
     * @param id
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:32
     **/
    ResponseBean delPosition(String id);

    /**
     * 匹配删除
     *
     * @param ids
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/23 16:58
     **/
    ResponseBean delPositionByIds(Set<String> ids);
}
