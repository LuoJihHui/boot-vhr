package com.ljh.vhr.mapper;

import com.ljh.vhr.entity.Hr;

/**
 * (Hr)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
public interface HrMapper {

    /**
     * 根据名称加载用户及其角色
     *
     * @param name
     * @return com.ljh.vhr.entity.Hr
     * @auth LuoJiaHui
     * @Date 2020/9/15 10:50
     **/
    Hr loadUserByName(String name);
}