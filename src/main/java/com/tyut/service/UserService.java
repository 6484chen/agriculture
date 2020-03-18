package com.tyut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyut.model.User;
import org.springframework.stereotype.Service;

/**
 * @PACKAGE_NAME: agricuture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/17 15:02
 **/

public interface UserService extends IService<User> {
    User selectUser(String loginName, String password);
}
