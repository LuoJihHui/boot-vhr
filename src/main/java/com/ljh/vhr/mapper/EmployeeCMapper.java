package com.ljh.vhr.mapper;

import com.ljh.vhr.entity.Employeeec;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Employeeec)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
public interface EmployeeCMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employeeec queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employeeec> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employeeec 实例对象
     * @return 对象列表
     */
    List<Employeeec> queryAll(Employeeec employeeec);

    /**
     * 新增数据
     *
     * @param employeeec 实例对象
     * @return 影响行数
     */
    int insert(Employeeec employeeec);

    /**
     * 修改数据
     *
     * @param employeeec 实例对象
     * @return 影响行数
     */
    int update(Employeeec employeeec);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}