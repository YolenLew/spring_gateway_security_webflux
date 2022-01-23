package com.daybreak.xian.gateway.service.impl;

import com.daybreak.xian.gateway.bean.UserInfoWithSecurity;
import com.daybreak.xian.gateway.dao.UserDao;
import com.daybreak.xian.gateway.service.UserService;
import com.daybreak.xian.commons_code.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 从数据库获取用户信息，将数据库中的原始UserInfo转换成SpringSecurity所需的UserDetails对象
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo getUserByName(String userName) {
        UserInfo userInfo = userDao.getUserByName(userName);

        return userInfo;
    }

    /**
     * SpringSecurity所需的：获取、组装用户信息（含授权信息）的UserDetails对象
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.getUserByName(username);

        if(userInfo == null){
            throw new UsernameNotFoundException("用户不存在！");
        }

        UserInfoWithSecurity userSec = new UserInfoWithSecurity();
        userSec.setUserInfo(userInfo);

        //模拟从数据库读取此用户的权限（能访问的url）
        List<GrantedAuthority> authorities = (List<GrantedAuthority>)userSec.getAuthorities();
        authorities.clear();//清空已有授权信息（重新读取）
        if(username.startsWith("user")){
            SimpleGrantedAuthority ga = new SimpleGrantedAuthority("BASE-CORE/" + username + "Call");
            authorities.add(ga);
        }else if(username.startsWith("admin")){
            authorities.add(new SimpleGrantedAuthority("**"));
//            authorities.add(new SimpleGrantedAuthority("adminCall"));
//            authorities.add(new SimpleGrantedAuthority("user1Call"));
//            authorities.add(new SimpleGrantedAuthority("user2Call"));
//            authorities.add(new SimpleGrantedAuthority("user3Call"));
//            authorities.add(new SimpleGrantedAuthority("whoAmI"));
        }

        return userSec;
    }
}
