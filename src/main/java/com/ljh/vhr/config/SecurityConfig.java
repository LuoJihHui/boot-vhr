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
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

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
    @Autowired
    private FindByIndexNameSessionRepository sessionRepository;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/login");
    }

    /**
     * 构建Security的Session策略;
     * 这里使用Redis实现;方便做集群通信
     *
     * @param sessionRepository
     * @return org.springframework.session.security.SpringSessionBackedSessionRegistry
     * @auth LuoJiaHui
     * @Date 2021/2/3 17:12
     **/
    @Bean
    SpringSessionBackedSessionRegistry sessionRegistry(FindByIndexNameSessionRepository sessionRepository) {
        return new SpringSessionBackedSessionRegistry(sessionRepository);
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
                .loginProcessingUrl("/doLogin")
                .successHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    Hr principal = (Hr) authentication.getPrincipal();
                    principal.setPassword(null);
                    ResponseBean responseBean = new ResponseBean("登录成功!", principal);
                    out.write(new ObjectMapper().writeValueAsString(responseBean));
                    out.flush();
                    out.close();
                }))
                .failureHandler(((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    ResponseBean responseBean = new ResponseBean(ResponseCode.ERROR);
                    if (exception instanceof LockedException) {
                        responseBean.setMsg("账号被锁定,请联系管理员!");
                    } else if (exception instanceof CredentialsExpiredException) {
                        responseBean.setMsg("密码已过期,请联系管理员!");
                    } else if (exception instanceof AccountExpiredException) {
                        responseBean.setMsg("账号已过期,请联系管理员!");
                    } else if (exception instanceof DisabledException) {
                        responseBean.setMsg("账号被禁用,请联系管理员!");
                    } else if (exception instanceof BadCredentialsException) {
                        responseBean.setMsg("用户名或密码输入错误,请重新输入");
                    } else if (exception instanceof SessionAuthenticationException) {
                        responseBean.setMsg("当前用户已登录;请勿重复登录");
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
                    ResponseBean responseBean = new ResponseBean("注销成功!", true);
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(responseBean));
                    out.flush();
                    out.close();
                })).permitAll()
                .and()
                .csrf().disable().cors().and()
                // 配置请求失败后的操作,不要默认的重定向
                .exceptionHandling()
                .authenticationEntryPoint(((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(401);
                    ResponseBean responseBean = new ResponseBean(ResponseCode.ERROR);
                    if (exception instanceof InsufficientAuthenticationException) {
                        responseBean.setMsg("尚未登录,非法请求,请联系管理员!");
                    }
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(responseBean));
                    out.flush();
                    out.close();
                }))
                // 集群session共享
                .and()
                .sessionManagement()
                // 同时最大Session数
                .maximumSessions(1)
                // 是否验证登录
                .maxSessionsPreventsLogin(true)
                // 使用自定义Session策略
                .sessionRegistry(sessionRegistry(sessionRepository));
    }
}
