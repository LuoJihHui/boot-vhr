package com.ljh.vhr.api.system.basic;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 职称管理API
 *
 * @author LuoJiaHui
 * @date 2020/9/24 9:03
 * @description
 */
@RestController()
@RequestMapping("/system/basic/job/level")
public class JobLevelApi {

    @Autowired
    private JobLevelService jobLevelService;

    /**
     * 获取职称等级列表
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:05
     **/
    @GetMapping("/title/level")
    public List<Map<String, Object>> listTitleLevels() {
        return jobLevelService.listTitleLevels();
    }

    /**
     * 获取职称列表
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/24 10:03
     **/
    @GetMapping("/")
    public Map<String, Object> listJobLevels(@RequestParam Integer num, @RequestParam Integer size) {
        return jobLevelService.listJobLevels(num, size);
    }

    /**
     * 添加职称
     *
     * @param map
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:43
     **/
    @PostMapping("/")
    public ResponseBean addJobLevel(@RequestBody Map<String, Object> map) {
        return jobLevelService.addJobLevel(map);
    }

    /**
     * 修改职称
     *
     * @param map
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:43
     **/
    @PutMapping("/")
    public ResponseBean updateJobLevel(@RequestBody Map<String, Object> map) {
        return jobLevelService.updateJobLevel(map);
    }

    /**
     * 删除职称
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:44
     **/
    @DeleteMapping("/{id}")
    public ResponseBean delJobLevel(@PathVariable Integer id,
                                    @RequestBody(required = false) Map<String, Object> map) {
        return jobLevelService.delJobLevel(id, MapUtil.isNotEmpty(map) ? Convert.toBool(map.get("isTrue")) : false);
    }

    /**
     * 重新启用职称
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 13:45
     **/
    @PostMapping("/{id}")
    public ResponseBean restartJobLevel(@PathVariable Integer id) {
        return jobLevelService.restartJobLevel(id);
    }
}
