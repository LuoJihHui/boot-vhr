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
    public List<Map<String, Object>> listAllHr() {
        return hrService.listAllHr();
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
}
