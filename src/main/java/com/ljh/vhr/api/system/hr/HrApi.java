package com.ljh.vhr.api.system.hr;

import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * hr相关接口
 *
 * @author LuoJiaHui
 * @date 2020/10/10 17:16
 * @description
 */
@RestController
@RequestMapping("/system/hr")
public class HrApi {

    @Autowired
    private HrService hrService;

    /**
     * 获取hr及其角色信息，除自己
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/10/10 17:20
     **/
    @GetMapping
    public List<Map<String, Object>> listAllHr(@RequestParam(required = false) String keywords) {
        return hrService.listAllHr(keywords);
    }

    /**
     * 更新hr
     *
     * @param hr
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/10/27 16:17
     **/
    @PutMapping
    public ResponseBean updateHr(@RequestBody Map<String, Object> hr) {
        return hrService.updateHr(hr);
    }

    /**
     * 更新hr的角色信息
     *
     * @param param
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/10/28 10:56
     **/
    @PutMapping("/roles")
    public ResponseBean updateRolesByHrId(@RequestBody Map<String, Object> param) {
        return hrService.updateRolesByHrId(param);
    }

    /**
     * 删除hr
     *
     * @param hrId
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/10/28 11:20
     **/
    @DeleteMapping("/{hr_id}")
    public ResponseBean delHr(@PathVariable("hr_id") String hrId) {
        return hrService.delHr(hrId);
    }
}
