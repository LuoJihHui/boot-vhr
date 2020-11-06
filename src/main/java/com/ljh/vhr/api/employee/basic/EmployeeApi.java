package com.ljh.vhr.api.employee.basic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ljh.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 员工管理API
 *
 * @author LuoJiaHui
 * @date 2020/10/30 16:14
 * @description
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

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
    @GetMapping
    public IPage<Map<String, Object>> listEmployeeInfo(@RequestParam("page_size") Integer pageSize,
                                                       @RequestParam("page_num") Integer pageNum,
                                                       @RequestParam(required = false) String keywords,
                                                       @RequestParam(value = "politic_id", required = false) Integer politicId,
                                                       @RequestParam(value = "nation_id", required = false) Integer nationId,
                                                       @RequestParam(value = "jobLevel_id", required = false) Integer jobLevelId,
                                                       @RequestParam(value = "pos_id", required = false) Integer posId,
                                                       @RequestParam(value = "engage_form", required = false) String engageForm,
                                                       @RequestParam(value = "department", required = false) String department,
                                                       @RequestParam(value = "begin_date", required = false) String beginDate,
                                                       @RequestParam(value = "end_date", required = false) String endDate,
                                                       @RequestParam(value = "is_export") Integer isExport,
                                                       HttpServletResponse response) throws IOException {
        return employeeService.listEmployeeInfo(pageSize, pageNum, keywords, politicId, nationId, jobLevelId, posId,
                engageForm, department, beginDate, endDate, isExport, response);
    }

//    public ResponseEntity<byte[]> exportData(){
//
//
//    }
}
