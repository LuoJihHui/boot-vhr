package com.ljh.vhr.service.impl;

import com.ljh.vhr.entity.Hr;
import com.ljh.vhr.mapper.HrMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LuoJiaHui
 * @date 2020/9/15 10:43
 * @description
 */
@Service
public class HrServiceImpl implements UserDetailsService {

    @Resource
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByName(username);
        if (hr == null) {
            throw new UsernameNotFoundException("当前用户不存在");
        }
        return hr;
    }
}
