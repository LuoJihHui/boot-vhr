package com.ljh.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.vhr.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 获取最新角色id
     *
     * @param
     * @return java.lang.Integer
     * @auth LuoJiaHui
     * @Date 2020/9/27 9:27
     **/
    Integer queryLastRoleId();

    /**
     * 重新设置自增列
     *
     * @param
     * @return void
     * @auth LuoJiaHui
     * @Date 2020/9/27 9:41
     **/
    void resetAutoIncrement();
}