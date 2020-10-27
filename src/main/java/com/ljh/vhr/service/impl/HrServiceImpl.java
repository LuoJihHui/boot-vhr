package com.ljh.vhr.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.entity.Hr;
import com.ljh.vhr.mapper.HrMapper;
import com.ljh.vhr.service.HrService;
import com.ljh.vhr.util.CommonUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<Map<String, Object>> listAllHr() {
        List<Hr> allHrs = hrMapper.getAllHrs(CommonUtils.getCurrentHr().getId());
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
}
