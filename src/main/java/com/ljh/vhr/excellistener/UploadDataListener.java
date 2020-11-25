package com.ljh.vhr.excellistener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.ljh.vhr.excelmodel.EmployeeModel;

/**
 * Excel解析
 *
 * @author LuoJiaHui
 * @date 2020/11/6 15:43
 * @description
 */
public class UploadDataListener extends AnalysisEventListener<EmployeeModel> {

    @Override
    public void invoke(EmployeeModel data, AnalysisContext context) {
        System.out.println("解析到一条数据:" + JSON.toJSONString(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
