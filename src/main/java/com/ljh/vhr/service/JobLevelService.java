package com.ljh.vhr.service;

import com.ljh.vhr.constant.api.ResponseBean;

import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/24 9:05
 * @description
 */
public interface JobLevelService {

    /**
     * 获取职称等级列表
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:05
     **/
    List<Map<String, Object>> listTitleLevels();

    /**
     * 获取职称列表
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/24 10:03
     **/
    Map<String, Object> listJobLevels(Integer num, Integer size);

    /**
     * 添加职称
     *
     * @param map
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:43
     **/
    ResponseBean addJobLevel(Map<String, Object> map);

    /**
     * 修改职称
     *
     * @param map
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:43
     **/
    ResponseBean updateJobLevel(Map<String, Object> map);

    /**
     * 删除职称
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:44
     **/
    ResponseBean delJobLevel(Integer id, Boolean isTrue);

    /**
     * 重新启用职称
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 13:45
     **/
    ResponseBean restartJobLevel(Integer id);
}
