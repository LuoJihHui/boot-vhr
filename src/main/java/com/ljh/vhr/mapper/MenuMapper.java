package com.ljh.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.vhr.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {


    /**
     * 根据用户id查询菜单
     *
     * @param userId
     * @return java.util.List<com.ljh.vhr.entity.Menu>
     * @auth LuoJiaHui
     * @Date 2020/9/16 9:13
     **/
    List<Menu> loadMenuByUserId(Integer userId);

    /**
     * 获取所有菜单及其角色信息
     *
     * @param
     * @return java.util.List<com.ljh.vhr.entity.Menu>
     * @auth LuoJiaHui
     * @Date 2020/9/16 16:44
     **/
    List<Menu> allMenu();
}
