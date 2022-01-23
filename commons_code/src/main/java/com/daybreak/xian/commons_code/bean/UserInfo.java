package com.daybreak.xian.commons_code.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 纯粹的用户信息，对应数据库
 */
@Data
public class UserInfo implements Serializable {
    private String userName;
    private String password;
    private String role;
}
