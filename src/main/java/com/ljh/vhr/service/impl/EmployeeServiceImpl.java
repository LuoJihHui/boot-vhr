package com.ljh.vhr.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.vhr.entity.*;
import com.ljh.vhr.excelmodel.EmployeeModel;
import com.ljh.vhr.exception.NonDataException;
import com.ljh.vhr.mapper.*;
import com.ljh.vhr.service.EmployeeService;
import com.ljh.vhr.util.CommonUtils;
import com.ljh.vhr.util.EasyExcelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/10/30 16:27
 * @description
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private NationMapper nationMapper;
    @Resource
    private PoliticsStatusMapper politicsStatusMapper;
    @Resource
    private JobLevelMapper jobLevelMapper;
    @Resource
    private PositionMapper positionMapper;


    /**
     * 获取员工详情列表
     *
     * @param pageSize   分页
     * @param pageNum    分页
     * @param keywords   关键字查询
     * @param politicId  政治面貌
     * @param nationId   民族
     * @param jobLevelId 职称
     * @param posId      职位
     * @param engageForm 聘用形式
     * @param department 部门
     * @param beginDate  入职开始时间
     * @param endDate    入职结束时间
     * @param isExport   是否导出 1导出当前页数据/2导出所有数据
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/10/30 16:23
     **/
    @Override
    public IPage<Map<String, Object>> listEmployeeInfo(Integer pageSize, Integer pageNum, String keywords,
                                                       Integer politicId, Integer nationId, Integer jobLevelId,
                                                       Integer posId, String engageForm, String department,
                                                       String beginDate, String endDate, Integer isExport,
                                                       HttpServletResponse response) throws IOException {
        // 检查导出参数
        pageSize = isExport != null && isExport == 2 ? -1 : pageSize;
        IPage<Map<String, Object>> iPage = listEmployeeData(pageSize, pageNum, keywords, politicId,
                nationId, jobLevelId, posId, engageForm, department, beginDate, endDate);
        if (CollUtil.isEmpty(iPage.getRecords())) {
            throw new NonDataException("未查询到员工数据,请检查搜索参数");
        }
        List<Map<String, Object>> records = iPage.getRecords();
        // 查询实体与各关联表的数据
        matchEmployeeInfo(records);
        // 导出excel
        if (isExport == 1 || isExport == 2) {
            ArrayList<EmployeeModel> listEmployeeModel = new ArrayList<>();
            for (int i = 0; i < records.size(); i++) {
                EmployeeModel employeeModel = BeanUtil.mapToBean(records.get(i), EmployeeModel.class, CommonUtils
                        .getCopyOptions());
                employeeModel.setIndex(i + 1);
                listEmployeeModel.add(employeeModel);
            }
            EasyExcelUtils.exportResourceExcel(listEmployeeModel, response, "员工详情", EmployeeModel.class);
            return null;
        }
        // 普通查询
        return iPage;
    }

    /**
     * 获取员工列表数据
     *
     * @param pageNum
     * @param pageSize
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/10/30 16:34
     **/
    private IPage<Map<String, Object>> listEmployeeData(Integer pageSize, Integer pageNum, String keywords,
                                                        Integer politicId, Integer nationId, Integer jobLevelId,
                                                        Integer posId, String engageForm, String department,
                                                        String beginDate, String endDate) {
        Page<Employee> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        // 参数匹配
        buildWrapper("name", keywords, wrapper, true);
        buildWrapper("workID", keywords, wrapper, true);
        buildWrapper("politicId", politicId, wrapper, true);
        buildWrapper("nationId", nationId, wrapper, true);
        buildWrapper("jobLevelId", jobLevelId, wrapper, true);
        buildWrapper("posId", posId, wrapper, true);
        buildWrapper("engageForm", engageForm, wrapper, true);
        buildWrapper("departmentId", department, wrapper, true);
        buildWrapper("beginDate", beginDate, endDate, wrapper);

        return employeeMapper.selectMapsPage(page, wrapper);
    }

    /**
     * 将关联的id字段调整为名称字段
     *
     * @param employees
     * @return void
     * @auth LuoJiaHui
     * @Date 2020/11/4 15:46
     **/
    private void matchEmployeeInfo(List<Map<String, Object>> employees) {
        for (Map<String, Object> employee : employees) {
            String departmentId = Convert.toStr(employee.get("departmentId"));
            Department department = departmentMapper.selectById(departmentId);
            employee.put("departmentName", department.getName());

            String nationId = Convert.toStr(employee.get("nationId"));
            Nation nation = nationMapper.selectById(nationId);
            employee.put("nationName", nation.getName());

            String politicId = Convert.toStr(employee.get("politicId"));
            PoliticsStatus politicsStatus = politicsStatusMapper.selectById(politicId);
            employee.put("politicName", politicsStatus.getName());

            String jobLevelId = Convert.toStr(employee.get("jobLevelId"));
            JobLevel jobLevel = jobLevelMapper.selectById(jobLevelId);
            employee.put("jobLevelName", jobLevel.getName());

            String posId = Convert.toStr(employee.get("posId"));
            Position position = positionMapper.selectById(posId);
            employee.put("posName", position.getName());
        }
    }

    /**
     * 通用wrapper构造
     *
     * @param column  列名
     * @param data    列值
     * @param wrapper 构造对象
     * @param isLike  是否模糊匹配
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<?>
     * @auth LuoJiaHui
     * @Date 2020/10/30 16:42
     **/
    private QueryWrapper<?> buildWrapper(String column, Object data, QueryWrapper<?> wrapper,
                                         boolean isLike) {
        if (ObjectUtil.isNotEmpty(data) || ObjectUtil.isNotNull(data)) {
            if (isLike) {
                wrapper.like(column, data);
            } else {
                wrapper.eq(column, data);
            }
        }
        return wrapper;
    }

    private QueryWrapper<?> buildWrapper(String column, String startTime, String endTime, QueryWrapper<?> wrapper) {
        if (StrUtil.isNotBlank(startTime)) {
            wrapper.ge(column, startTime);
        }
        if (StrUtil.isNotBlank(endTime)) {
            wrapper.le(column, endTime);
        }
        return wrapper;
    }
}
