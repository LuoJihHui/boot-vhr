package com.ljh.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ljh.vhr.entity.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-15 10:35:32
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

}