package com.ljh.vhr.api.system.basic;

import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 职位管理接口
 *
 * @author LuoJiaHui
 * @date 2020/9/22 15:22
 * @description
 */
@RestController
@RequestMapping("/system/basic/position")
public class PositionApi {

    @Autowired
    private PositionService positionService;

    /**
     * 查询职位列表
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @auth LuoJiaHui
     * @Date 2020/9/22 15:24
     **/
    @GetMapping("/list")
    public List<Map<String, Object>> listPositions() {
        return positionService.listPositions();
    }

    /**
     * 添加职位
     *
     * @param map
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:22
     **/
    @PostMapping("/")
    public ResponseBean addPosition(@RequestBody Map<String, Object> map) {
        return positionService.position(map);
    }

    /**
     * 更新职位
     *
     * @param map
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:30
     **/
    @PutMapping("/")
    public ResponseBean updatePosition(@RequestBody Map<String, Object> map) {
        return positionService.updatePosition(map);
    }

    /**
     * 禁用职位
     *
     * @param id
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:32
     **/
    @DeleteMapping("/{id}")
    public ResponseBean delPosition(@PathVariable String id) {
        return positionService.delPosition(id);
    }
}
