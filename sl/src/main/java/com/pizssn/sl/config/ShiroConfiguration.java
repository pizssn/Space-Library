package com.pizssn.sl.config;

import com.pizssn.sl.realm.SJRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    @Bean
    //管理shiro bean生命周期
    public static LifecycleBeanPostProcessor getLifecycleBeanProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    //配置散列算法
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数
        return hashedCredentialsMatcher;
    }

    @Bean
    //将散列算法配置到自定义的Realm
    public SJRealm getWJRealm() {
        SJRealm sjRealm = new SJRealm();
        sjRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return sjRealm;
    }

    @Bean
    //把Realm注册到SecurityManage
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getWJRealm());
        return securityManager;
    }

    @Bean
    //把SecurityManage注入到ShiroFilterFactoryBean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // Shiro的核心安全接口,这个属性是必须的
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置shiro拦截器
        Map<String, String> fiterMap = new LinkedHashMap<>();
        fiterMap.put("/a/**", "authc");
        fiterMap.put("/api/register", "anon");
        fiterMap.put("/api/login", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fiterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    //开启shiro aop注解支持,使用代理方式;所以需要开启代码支持;Controller才能使用@RequiresPermissions
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j3Y+R1aSn5BOlAA=="));

        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }
}
