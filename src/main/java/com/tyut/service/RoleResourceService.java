package com.tyut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyut.model.RoleResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 角色资源中间表(t_role_resource)业务层接口.
 * @author: wangchen
 * @create: 2020/2/21 15:34
 **/

public interface RoleResourceService extends IService<RoleResource> {
    List<Integer> selectByRoleId(Integer roleId);
}
