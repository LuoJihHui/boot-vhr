package com.ljh.vhr.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.entity.Hr;
import com.ljh.vhr.entity.HrRole;
import com.ljh.vhr.mapper.HrMapper;
import com.ljh.vhr.mapper.HrRoleMapper;
import com.ljh.vhr.service.HrRoleService;
import com.ljh.vhr.service.HrService;
import com.ljh.vhr.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author LuoJiaHui
 * @date 2020/9/15 10:43
 * @description
 */
@Service
public class HrServiceImpl implements UserDetailsService, HrService {

    @Resource
    private HrMapper hrMapper;
    @Resource
    private HrRoleMapper hrRoleMapper;
    @Autowired
    private HrRoleService hrRoleService;

    /**
     * 当前用户登录后将用户信息托管给SpringSecurity
     *
     * @param username
     * @return org.springframework.security.core.userdetails.UserDetails
     * @auth LuoJiaHui
     * @Date 2020/10/10 17:17
     **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByName(username);
        if (hr == null) {
            throw new UsernameNotFoundException("当前用户不存在");
        }
        return hr;
    }

    /**
     * 获取所有Hr信息包括角色信息除自己
     *
     * @param
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @auth LuoJiaHui
     * @Date 2020/10/10 17:19
     **/
    @Override
    public List<Map<String, Object>> listAllHr(String keywords) {
        List<Hr> allHrs = hrMapper.getAllHrs(CommonUtils.getCurrentHr().getId(),keywords);
        allHrs.forEach(hr -> {
            hr.setPassword(null);
        });
        return allHrs.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
    }

    /**
     * 更新hr
     *
     * @param param
     * @return java.lang.Boolean
     * @auth LuoJiaHui
     * @Date 2020/10/27 16:17
     **/
    @Override
    public ResponseBean updateHr(Map<String, Object> param) {
        Hr hr = BeanUtil.mapToBean(param, Hr.class, CommonUtils.getCopyOptions());
        if (CollUtil.isNotEmpty(hr.getRoles())) {
            hr.setRoles(null);
        }
        boolean b = hrMapper.updateById(hr) > 0;
        return new ResponseBean(b ? "更新信息成功!" : "更新失败,请稍后再试!", b);
    }

    /**
     * 更新hr的角色信息
     *
     * @param param
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/10/28 10:56
     **/
    @Override
    public ResponseBean updateRolesByHrId(Map<String, Object> param) {
        // 先清除当前hr所有角色
        Integer hrId = Convert.toInt(param.get("hrId"));
        List<?> rid = Convert.toList(param.get("rid"));
        QueryWrapper<HrRole> wrapper = new QueryWrapper<>();
        wrapper.eq("hrid", hrId);
        hrRoleMapper.delete(wrapper);
        // 从新关联角色
        List<HrRole> list = new ArrayList<>();
        for (Object r : rid) {
            HrRole hrRole = new HrRole();
            hrRole.setHrId(hrId);
            hrRole.setRid(Convert.toInt(r));
            list.add(hrRole);
        }
        boolean saveBatch = hrRoleService.saveBatch(list);
        return new ResponseBean(saveBatch ? "更新角色信息成功!" : "更新失败,请稍后重试", saveBatch);
    }

    /**
     * 删除hr
     *
     * @param hrId
     * @return com.ljh.vhr.constant.api.ResponseBean
     * @auth LuoJiaHui
     * @Date 2020/10/28 11:20
     **/
    @Override
    public ResponseBean delHr(String hrId) {
        UpdateWrapper<Hr> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", hrId).set("enabled", -1);
        int update = hrMapper.update(null, wrapper);
        return new ResponseBean(update > 0 ? "删除人员成功!" : "删除失败,请稍后重新", update > 0);
    }
}
