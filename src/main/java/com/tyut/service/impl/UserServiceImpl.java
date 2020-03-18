package com.tyut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.exception.AuthException;
import com.tyut.mapper.UserMapper;
import com.tyut.model.User;
import com.tyut.result.MessageStatus;
import com.tyut.service.UserService;
import com.tyut.utils.MD5Utils;
import com.tyut.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME: agricuture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/17 15:03
 **/

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService{
    @Override
    public User selectUser(String loginName, String password) {
        // 校验帐号密码规则
        List<User> list = this.query().eq(User.LOGIN_NAME, loginName).list();
        if (StringUtils.isEmpty(list)) {
            throw new AuthException(MessageStatus.ERROR_2001.getMessage());
        }
        User user = list.get(0);
        String originalPwd = user.getPassword();
        String salt = user.getSalt();
        if (!MD5Utils.md5(password + salt).equals(originalPwd)) {
            throw new AuthException(MessageStatus.ERROR_2003.getMessage());
        }
        return user;
    }
}
