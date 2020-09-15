package com.ljh.vhr.mapper;

import com.ljh.vhr.entity.Politicsstatus;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Politicsstatus)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
public interface PoliticsStatusMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Politicsstatus queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Politicsstatus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param politicsstatus 实例对象
     * @return 对象列表
     */
    List<Politicsstatus> queryAll(Politicsstatus politicsstatus);

    /**
     * 新增数据
     *
     * @param politicsstatus 实例对象
     * @return 影响行数
     */
    int insert(Politicsstatus politicsstatus);

    /**
     * 修改数据
     *
     * @param politicsstatus 实例对象
     * @return 影响行数
     */
    int update(Politicsstatus politicsstatus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}