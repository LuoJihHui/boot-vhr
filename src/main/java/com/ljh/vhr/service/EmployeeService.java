package com.ljh.vhr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/10/30 16:25
 * @description
 */
public interface EmployeeService {

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
    IPage<Map<String, Object>> listEmployeeInfo(Integer pageSize, Integer pageNum, String keywords,
                                                Integer politicId, Integer nationId, Integer jobLevelId,
                                                Integer posId, String engageForm, String department,
                                                String beginDate, String endDate, Integer isExport,
                                                HttpServletResponse response) throws IOException;


}
