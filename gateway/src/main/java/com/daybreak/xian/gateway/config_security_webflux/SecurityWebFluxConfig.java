package com.daybreak.xian.gateway.config_security_webflux;

import com.daybreak.xian.gateway.component_security_webflux.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityWebFluxConfig {
    //自定义的鉴权服务，通过鉴权的才能继续访问某个请求
    @Autowired
    private MyRBACServiceWebFlux myRBACServiceWebFlux;

    //无权限访问被拒绝时的自定义处理器。如不自己处理，默认返回403错误
    @Autowired
    private MyAccessDeniedHandlerWebFlux myAccessDeniedHandlerWebFlux;

    //登录成功时调用的自定义处理类
    @Autowired
    private LoginSuccessHandlerWebFlux loginSuccessHandlerWebFlux;

    //登录失败时调用的自定义处理类
    @Autowired
    private LoginFailedHandlerWebFlux loginFailedHandlerWebFlux;

    //成功登出时调用的自定义处理类
    @Autowired
    private LogoutSuccessHandlerWebFlux logoutSuccessHandlerWebFlux;

    //未登录访问资源时的处理类，若无此处理类，前端页面会弹出登录窗口
    @Autowired
    private CustomHttpBasicServerAuthenticationEntryPointWebFlux customHttpBasicServerAuthenticationEntryPoint;

    //security的鉴权排除列表
    private static final String[] excludedAuthPages = {
            "/auth/login",
            "/auth/logout",
            "/health",
            "/api/socket/**"
    };

    @Bean
    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http
//                .authenticationManager(myReactiveAuthenticationManager)//自定义登录验证。自动扫描注入，无需手动注入
                .authorizeExchange()
                .pathMatchers(excludedAuthPages).permitAll()  //无需进行权限过滤的请求路径
                .pathMatchers(HttpMethod.OPTIONS).permitAll() //option 请求默认放行
                .and()
                .authorizeExchange().pathMatchers("/**").access(myRBACServiceWebFlux)//自定义的鉴权服务，通过鉴权的才能继续访问某个请求
                .anyExchange().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .authenticationSuccessHandler(loginSuccessHandlerWebFlux) //认证成功
                .authenticationFailureHandler(loginFailedHandlerWebFlux) //登陆验证失败
                .and().exceptionHandling().authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint)  //未登录访问资源时的处理类，若无此处理类，前端页面会弹出登录窗口
                .and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandlerWebFlux)//访问被拒绝时自定义处理器
                .and() .csrf().disable()//必须支持跨域
                .logout().logoutUrl("/auth/logout")
//                .logoutHandler()
                .logoutSuccessHandler(logoutSuccessHandlerWebFlux);//成功登出时调用的自定义处理类

        //自定义的session操作过滤器
//        http.addFilterAt(new MySessionManageFilter(), SecurityWebFiltersOrder.FIRST);

        return http.build();
    }
}