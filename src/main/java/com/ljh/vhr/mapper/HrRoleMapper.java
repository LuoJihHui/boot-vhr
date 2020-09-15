package com.ljh.vhr.mapper;

import com.ljh.vhr.entity.HrRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (HrRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
public interface HrRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HrRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HrRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param hrRole 实例对象
     * @return 对象列表
     */
    List<HrRole> queryAll(HrRole hrRole);

    /**
     * 新增数据
     *
     * @param hrRole 实例对象
     * @return 影响行数
     */
    int insert(HrRole hrRole);

    /**
     * 修改数据
     *
     * @param hrRole 实例对象
     * @return 影响行数
     */
    int update(HrRole hrRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}