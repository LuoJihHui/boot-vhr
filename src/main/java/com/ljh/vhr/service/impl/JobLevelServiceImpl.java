package com.ljh.vhr.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.entity.Employee;
import com.ljh.vhr.entity.JobLevel;
import com.ljh.vhr.entity.TitleLevel;
import com.ljh.vhr.exception.BasicException;
import com.ljh.vhr.mapper.EmployeeMapper;
import com.ljh.vhr.mapper.JobLevelMapper;
import com.ljh.vhr.mapper.TitleLevelMapper;
import com.ljh.vhr.service.JobLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/24 9:06
 * @description
 */
@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Resource
    private JobLevelMapper jobLevelMapper;
    @Resource
    private TitleLevelMapper titleLevelMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 获取职称等级列表
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:05
     **/
    @Override
    public List<Map<String, Object>> listTitleLevels() {
        QueryWrapper<TitleLevel> wrapper = new QueryWrapper<>();
        wrapper.select("id,name").eq("enabled", true);
        return titleLevelMapper.selectMaps(wrapper);
    }

    /**
     * 获取职称列表
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/9/24 10:03
     **/
    @Override
    public Map<String, Object> listJobLevels(Integer num, Integer size) {
        Page<Object> page = new Page<>(num, size);
        List<Map<String, Object>> maps = jobLevelMapper.loadJobLevelWithTitleLevel(page);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", maps);
        map.put("total", page.getTotal());
        return map;
    }

    /**
     * 添加职称
     *
     * @param map
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:43
     **/
    @Override
    public ResponseBean addJobLevel(Map<String, Object> map) {
        String name = Convert.toStr(map.get("name"));
        QueryWrapper<JobLevel> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name).eq("enabled", true);
        List<JobLevel> jobLevels = jobLevelMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(jobLevels)) {
            throw new BasicException("当前职称【" + name + "】已存在,请勿重复添加!");
        }
        String name1 = Convert.toStr(map.get("name"));
        String titleLevel = Convert.toStr(map.get("titleLevel"));
        JobLevel jobLevel = new JobLevel();
        jobLevel.setName(name1);
        jobLevel.setTitleLevel(queryTitleLevel(titleLevel));
        int insert = jobLevelMapper.insert(jobLevel);
        return new ResponseBean("添加职称成功!", insert > 0);
    }

    /**
     * 修改职称
     *
     * @param map
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:45
     **/
    @Override
    public ResponseBean updateJobLevel(Map<String, Object> map) {
        String id = Convert.toStr(map.get("id"));
        isAnyoneUsing(Convert.toInt(id), "jobLevelId");
        Integer titleLevel = queryTitleLevel(Convert.toStr(map.get("titleLevel")));
        UpdateWrapper<JobLevel> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id).set("name", map.get("name")).set("titleLevel", titleLevel)
                .set("enabled", map.get("enabled"));
        int update = jobLevelMapper.update(null, wrapper);
        return new ResponseBean("修改职称成功", update > 0);
    }

    /**
     * 删除职称
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 9:45
     **/
    @Override
    public ResponseBean delJobLevel(Integer id, Boolean isTrue) {
        isAnyoneUsing(id, "jobLevelId");
        boolean b = isTrue != null && isTrue;
        Boolean updateJobLevel = updateJobLevel(Convert.toStr(id), b ? -1 : false, "enabled");
        return new ResponseBean(b ? "删除职称成功!" : "禁用职称成功!", updateJobLevel);
    }

    /**
     * 重新启用职称
     *
     * @param id
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/9/24 13:45
     **/
    @Override
    public ResponseBean restartJobLevel(Integer id) {
        Boolean updateJobLevel = updateJobLevel(Convert.toStr(id), true, "enabled");
        return new ResponseBean("启用职称成功!", updateJobLevel);
    }

    /**
     * 根据id更新职称指定字段
     *
     * @param id
     * @param name
     * @param column
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/25 10:24
     **/
    private Boolean updateJobLevel(String id, Object name, String column) {
        UpdateWrapper<JobLevel> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id).set(column, name);
        return jobLevelMapper.update(null, wrapper) > 0;
    }

    /**
     * 通过职称名查职称等级id
     *
     * @param name
     * @return java.lang.Integer
     * @auth LuoJiaHui
     * @Date 2020/9/25 10:24
     **/
    private Integer queryTitleLevel(String name) {
        QueryWrapper<TitleLevel> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        List<TitleLevel> titleLevels = titleLevelMapper.selectList(wrapper);
        return titleLevels.get(0).getId();
    }

    /**
     * 判断指定类型是否有人使用
     *
     * @param id
     * @return void
     * @auth LuoJiaHui
     * @Date 2020/9/25 10:22
     **/
    private void isAnyoneUsing(Integer id, String column) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq(column, id).eq("enabled", true);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(employees)) {
            throw new BasicException("当前职称已有员工使用,不能禁用或删除!");
        }
    }
}
