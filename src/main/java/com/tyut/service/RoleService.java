package com.tyut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyut.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 用户角色信息表(t_role)业务层接口.
 * @author: wangchen
 * @create: 2020/2/21 15:25
 **/


public interface RoleService extends IService<Role> {
    List<Role> selectList();

    Map<Integer, String> selectMap();

}
