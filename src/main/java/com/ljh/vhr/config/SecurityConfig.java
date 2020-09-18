package com.ljh.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljh.vhr.constant.api.ResponseBean;
import com.ljh.vhr.constant.api.ResponseCode;
import com.ljh.vhr.entity.Hr;
import com.ljh.vhr.service.impl.HrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.io.PrintWriter;

/**
 * Security配置
 *
 * @author LuoJiaHui
 * @date 2020/9/15 12:20
 * @description
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HrServiceImpl hrService;
    @Autowired
    private CustomDecisionManager decisionManager;
    @Autowired
    private RoleResourcePermissionsFilter roleResourcePermissionsFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(decisionManager);
                        object.setSecurityMetadataSource(roleResourcePermissionsFilter);
                        return object;
                    }
                })
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    Hr principal = (Hr) authentication.getPrincipal();
                    principal.setPassword(null);
                    ResponseBean responseBean = new ResponseBean(principal);
                    out.write(new ObjectMapper().writeValueAsString(responseBean));
                    out.flush();
                    out.close();
                }))
                .failureHandler(((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    ResponseBean responseBean = new ResponseBean(ResponseCode.ERROR);
                    if (exception instanceof LockedException) {
                        responseBean.setData("账号被锁定,请联系管理员!");
                    } else if (exception instanceof CredentialsExpiredException) {
                        responseBean.setData("密码已过期,请联系管理员!");
                    } else if (exception instanceof AccountExpiredException) {
                        responseBean.setData("账号已过期,请联系管理员!");
                    } else if (exception instanceof DisabledException) {
                        responseBean.setData("账号被禁用,请联系管理员!");
                    } else if (exception instanceof BadCredentialsException) {
                        responseBean.setData("用户名或密码输入错误,请重新输入");
                    }
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(responseBean));
                    out.flush();
                    out.close();
                })).permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    ResponseBean responseBean = new ResponseBean("注销成功!");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(responseBean));
                    out.flush();
                    out.close();
                })).permitAll()
                .and()
                .csrf().disable();
    }
}
