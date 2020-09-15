package com.ljh.vhr.service.impl;

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
        return null;
    }
}
