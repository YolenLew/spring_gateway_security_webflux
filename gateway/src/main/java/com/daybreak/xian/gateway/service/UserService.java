package com.daybreak.xian.gateway.service;

import com.daybreak.xian.commons_code.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户信息业务类，作用1是获取数据库中的用户信息；2是实现SpringSecurity中所需的UserDetails对象（其内部需管理起来）
 */
public interface UserService extends UserDetailsService {

    /**
     * 通过用户名从数据库中获取原始用户对象
     * @param userName
     * @return
     */
    UserInfo getUserByName(String userName);
}
