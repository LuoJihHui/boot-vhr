package com.ljh.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.vhr.entity.Hr;

import java.util.List;

/**
 * (Hr)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
public interface HrMapper extends BaseMapper<Hr> {

    /**
     * 根据名称加载用户及其角色
     *
     * @param name
     * @return com.ljh.vhr.entity.Hr
     * @auth LuoJiaHui
     * @Date 2020/9/15 10:50
     **/
    Hr loadUserByName(String name);

    /**
     * 获取所有hr信息及其角色信息，除指定id外
     *
     * @param id
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/10/10 17:22
     **/
    List<Hr> getAllHrs(Integer id);
}