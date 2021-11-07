package com.example.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/*@Configuration
public class sconfig {
    //设置安全管理器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("DefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        *//*
        anon:无需认证就可以访问
        authc:必颈认证了才能让问
        user:必须拥有记住我功能才能用
        perms :拥有对某个资源的权限才能访问;
        role:拥有某个角色权限才能访问
        *//*
        Map<String,String> f = new LinkedHashMap<>();
        f.put("/l1/{id}}","authc");
        f.put("/l2/1","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(f);
        return shiroFilterFactoryBean;

    }
    //关联shiro
    @Bean(name = "DefaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("shiro") shiro shiro){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiro);
        return defaultWebSecurityManager;

    }
    //realm对象，需要自定义类
    @Bean(name = "shiro")
    public shiro userrealm(){
        return new shiro();
    }
}*/
