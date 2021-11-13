package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class s extends WebSecurityConfigurerAdapter {
    @Bean
    public AccessDeniedHandler getAccessDeniedHandler() {
        return new MyAccessDeniedHandler();
    }
    //链式编程,授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //首页所有人可以访问
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/l1/**")
                .hasRole("vip1")
                .antMatchers("/l2/**")
                .hasRole("vip2")
                .antMatchers("/l3/**")
                .hasRole("vip3")
                .and()//无权限用户提示字符串消息设置
                .exceptionHandling()
                // getAccessDeniedHandler()是上文的方法
                .accessDeniedHandler(getAccessDeniedHandler());
                 //and()是连接不同配置的
        //没有权限到登录页
        //http.formLogin().loginPage("/login");//定制登录页
        http.logout().logoutSuccessUrl("/");
        http.formLogin();
        http.rememberMe();
        //http.rememberMe().rememberMeParameter("remember");从前端接受记住我
    }
    //认证

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //正常应该在数据库中读
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zqq")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip1")
                .and()
                .withUser("zqf")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip1","vip2","vip3");
    }
}
