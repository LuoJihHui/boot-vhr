package com.ljh.vhr.mapper;

import com.ljh.vhr.entity.Sysmsg;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Sysmsg)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
public interface SysMsgMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sysmsg queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sysmsg> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysmsg 实例对象
     * @return 对象列表
     */
    List<Sysmsg> queryAll(Sysmsg sysmsg);

    /**
     * 新增数据
     *
     * @param sysmsg 实例对象
     * @return 影响行数
     */
    int insert(Sysmsg sysmsg);

    /**
     * 修改数据
     *
     * @param sysmsg 实例对象
     * @return 影响行数
     */
    int update(Sysmsg sysmsg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}