package com.daybreak.xian.gateway.dao;

import com.daybreak.xian.commons_code.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    UserInfo getUserByName(@Param("userName") String userName);
}
