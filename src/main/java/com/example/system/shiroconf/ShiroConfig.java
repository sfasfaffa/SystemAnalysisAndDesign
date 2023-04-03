package com.example.system.shiroconf;



import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 引用了多处的开源代码如：https://blog.csdn.net/weixin_38405253/article/details/90375043
 */

@Configuration//配置
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        ThreadContext.bind(defaultWebSecurityManager);
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        bean.setUnauthorizedUrl("/noauth");
        bean.setLoginUrl("/login");//未授权页面

        Map<String, Filter> filterMap1 = bean.getFilters();
        bean.setFilters(filterMap1);
        filterMap1.put("client",new CORSAuthenticationFilter());
        Map<String,String> filterMap=new LinkedHashMap<>();
        //过滤器
        filterMap.put("/user/warning/get","anon");
        filterMap.put("/no/auth","anon");
        filterMap.put("/login/normal/login","anon");
        filterMap.put("/login/normal/register","anon");
        filterMap.put("/login/wx/login","anon");
        filterMap.put("/area/get/**","anon");
        filterMap.put("/area/set/one","perms[admin]");
        filterMap.put("/area/set/coor","perms[admin]");
        filterMap.put("/judge/setacidstate","perms[admin]");
        filterMap.put("/**","client");
        bean.setFilterChainDefinitionMap(filterMap);//设置登录请求

        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //设置自定义的realm
        defaultWebSecurityManager.setRealm(userRealm());
        //自定义的shiro session 缓存管理器
        defaultWebSecurityManager.setSessionManager(sessionManager());

        return defaultWebSecurityManager;
    }
    //ShiroFilterFactoryBean：3
    // 创建realm（领域）对象，需要自定义类，用户认证放在此处
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    /*
    并且model的字段属性可以与entity不一致，model是用于前端页面数据展示的，而entity则是与数据库进行交互做存储用途。
举个例子：
     */


    /**
     * 自定义的 shiro session 缓存管理器，用于跨域等情况下使用 token 进行验证，不依赖于sessionId
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        //将我们继承后重写的shiro session 注册
        ShiroSession shiroSession = new ShiroSession();
        //如果后续考虑多tomcat部署应用，可以使用shiro-redis开源插件来做session 的控制，或者nginx 的负载均衡
        shiroSession.setSessionIdUrlRewritingEnabled(false);
        shiroSession.setSessionDAO(new EnterpriseCacheSessionDAO());
        return shiroSession;
    }

}