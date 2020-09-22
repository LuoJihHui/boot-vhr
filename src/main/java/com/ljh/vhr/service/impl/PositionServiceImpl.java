package com.ljh.vhr.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ljh.vhr.entity.Employee;
import com.ljh.vhr.entity.Position;
import com.ljh.vhr.exception.BasicException;
import com.ljh.vhr.mapper.EmployeeMapper;
import com.ljh.vhr.mapper.PositionMapper;
import com.ljh.vhr.service.PositionService;
import com.ljh.vhr.util.CommonUtils;
import com.ljh.vhr.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LuoJiaHui
 * @date 2020/9/22 15:23
 * @description
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 查询职位列表
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @auth LuoJiaHui
     * @Date 2020/9/22 15:24
     **/
    @Override
    public List<Map<String, Object>> listPositions() {
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.select("id,name,createDate")
                .eq("enabled", true)
                .orderByAsc("update_date");
        List<Map<String, Object>> maps = positionMapper.selectMaps(wrapper);
        maps.forEach(map -> {
            Date createDate = Convert.toDate(map.get("createDate"));
            map.replace("createDate", DateUtils.formatTimestampToString(createDate));
        });
        return maps;
    }

    /**
     * 添加职位
     *
     * @param map
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:22
     **/
    @Override
    public Boolean position(Map<String, Object> map) {
        String jobLevelName = Convert.toStr(map.get("name"));
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.eq("name", jobLevelName).eq("enabled", true);
        List<Position> positions = positionMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(positions)) {
            throw new BasicException("当前职位名【" + jobLevelName + "】已存在,不能重复添加");
        }
        // 当输入的职位和已存在的职位名相同并且状态为禁用则开启即可
        QueryWrapper<Position> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("name", jobLevelName);
        List<Position> positionList = positionMapper.selectList(wrapper1);
        if (CollUtil.isNotEmpty(positionList)) {
            Position position = positionList.get(0);
            return updatePosition(Convert.toStr(position.getId()), "1", "enabled");
        }
        Position position = BeanUtil.mapToBean(map, Position.class, CommonUtils.getCopyOptions());
        return positionMapper.insert(position) > 0;
    }

    /**
     * 更新职位
     *
     * @param map
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:30
     **/
    @Override
    public Boolean updatePosition(Map<String, Object> map) {
        return updatePosition(Convert.toStr(map.get("id")), Convert.toStr(map.get("name")), "name");
    }

    /**
     * 禁用职位
     *
     * @param id
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:32
     **/
    @Override
    public Boolean delPosition(String id) {
        // 查询该职位是否有引用
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("posId", id).eq("enabled", true);
        List<Employee> employees = employeeMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(employees)) {
            throw new BasicException("当前职位存在正式员工,不能删除~");
        }
        return updatePosition(id, "0", "enabled");
    }

    /**
     * 根据id修改值
     *
     * @param id     id
     * @param name   修改的值
     * @param column 指定修改的列
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/9/22 16:35
     **/
    private Boolean updatePosition(String id, String name, String column) {
        UpdateWrapper<Position> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id).set(column, name);
        return positionMapper.update(null, wrapper) > 0;
    }
}
