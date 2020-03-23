/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CustomSecurityConfig
 * Author:   morning
 * Date:     2020-03-04 15:31
 * Description: Security配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.morningyet.myvhr2020.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.morningyet.myvhr2020.dto.RespBean;
import org.morningyet.myvhr2020.model.Hr;
import org.morningyet.myvhr2020.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author morning
 * @version 1.0.0
 * @desc Security配置类
 * @FileName CustomSecurityConfig
 * @create 2020-03-04 15:31
 */

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;
    @Autowired
    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.anyRequest().authenticated() ///要求所有进入应用的 HTTP请求都要进行认证
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(customUrlDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin") //登录请求地址
                .loginPage("/login") //认证失败跳转
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        Hr principal = (Hr) authentication.getPrincipal();//这里強转为hr类  不转似乎也没有影响
                        principal.setPassword("不予显示");
                        //将用户信息回写到前端
                        RespBean respBean = RespBean.ok("登录成功", principal);
                        String s = new ObjectMapper().writeValueAsString(respBean);
                        writer.write(s);
                        writer.flush();
                        writer.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        RespBean respBean = RespBean.error("登录失败!");
                        if (exception instanceof LockedException) {
                            respBean.setMsg("账户被锁定，请联系管理员!");
                        } else if (exception instanceof CredentialsExpiredException) {
                            respBean.setMsg("密码过期，请联系管理员!");
                        } else if (exception instanceof AccountExpiredException) {
                            respBean.setMsg("账户过期，请联系管理员!");
                        } else if (exception instanceof DisabledException) {
                            respBean.setMsg("账户被禁用，请联系管理员!");
                        } else if (exception instanceof BadCredentialsException) {
                            respBean.setMsg("用户名或者密码输入错误，请重新输入!");
                        }
                        writer.write(new ObjectMapper().writeValueAsString(respBean));
                        writer.flush();
                        writer.close();
                    }
                })
                .permitAll()//无条件允许访问 (已经在Handler处理完毕)
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        RespBean respBean = RespBean.ok("注销成功!~");
                        String s = new ObjectMapper().writeValueAsString(respBean);
                        writer.write(s);
                        writer.flush();
                        writer.close();
                    }
                })
                .permitAll()//无条件允许访问
                .and()
                .csrf()
                .disable()//取消屏蔽postman一类构造请求
                .exceptionHandling()
                //没有认证时，在这里处理结果，不要重定向
                //重定向会导致前端跳转时出现跨域的问题
                //只发送错误信息,由前端的路由守卫处理即可
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        resp.setStatus(401);
                        PrintWriter out = resp.getWriter();
                        RespBean respBean = RespBean.error("访问失败!");
                        //Insufficient  不充分的
                        if (authException instanceof InsufficientAuthenticationException) {
                            respBean.setMsg("权限不足，请联系管理员!!");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        out.flush();
                        out.close();
                    }
                });
    }


}
