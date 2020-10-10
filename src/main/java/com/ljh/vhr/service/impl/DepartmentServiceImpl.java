package com.ljh.vhr.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.entity.Department;
import com.ljh.vhr.entity.Employee;
import com.ljh.vhr.exception.BasicException;
import com.ljh.vhr.mapper.DepartmentMapper;
import com.ljh.vhr.mapper.EmployeeMapper;
import com.ljh.vhr.service.DepartmentService;
import com.ljh.vhr.util.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/27 11:14
 * @description
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 树状组织结构
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/27 11:14
     **/
    @Override
    public List<Map<String, Object>> allDepartmentTree() {
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("enabled", true);
        List<Map<String, Object>> maps = departmentMapper.selectMaps(wrapper);
        return CommonUtils.outTreeMenu(maps);
    }

    /**
     * 添加组织节点
     *
     * @param params
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/27 14:31
     **/
    @Override
    public ResponseBean addDepartment(Map<String, Object> params) {
        String name = Convert.toStr(params.get("name"));
        Integer parentId = Convert.toInt(params.get("parentId"));
        if (StrUtil.isBlank(name) || parentId == null) {
            throw new BasicException("参数异常");
        }
        // 不允许同级组织重名
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name)
                .eq("parentId", parentId)
                .eq("enabled", true);
        List<Department> departments = departmentMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(departments)) {
            throw new BasicException("当前同级组织【" + name + "】已存在,请勿重复添加");
        }
        Department department = new Department();
        department.setName(name);
        department.setParentId(parentId);
        boolean b = departmentMapper.insert(department) > 0;
        // 添加depPath字段
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("id", parentId).eq("enabled", true);
        Department parentDepartment = departmentMapper.selectOne(wrapper);
        String depPath = parentDepartment.getDepPath();
        String childrenDepPath = depPath + "." + department.getId();
        department.setDepPath(childrenDepPath);
        boolean updateDepPath = departmentMapper.updateById(department) > 0;
        // 更新父节点标记
        UpdateWrapper<Department> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", parentId).set("isParent", true);
        boolean updateIsParent = departmentMapper.update(null, updateWrapper) > 0;
        if (!(b && updateDepPath && updateIsParent)) {
            throw new BasicException("操作失败!");
        }
        return new ResponseBean("添加组织【" + name + "】成功!", department.getId());
    }

    /**
     * 删除组织
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/27 14:16
     **/
    @Override
    public ResponseBean delDepartment(Integer id) {
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("parentId", id).eq("enabled", true);
        List<Department> departments = departmentMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(departments)) {
            throw new BasicException("当前组织下存在其他子组织,不能直接删除!");
        }
        // 判断当前组织是否有员工
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("departmentId", id).eq("enabled", true);
        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(employees)) {
            throw new BasicException("当前组织下存在其他用户,不能删除！");
        }
        Department department = new Department();
        department.setId(id);
        department.setEnabled(false);
        boolean b = departmentMapper.updateById(department) > 0;
        return new ResponseBean("删除组织成功!", b);
    }
}
