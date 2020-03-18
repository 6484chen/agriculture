package com.tyut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.mapper.RoleResourceMapper;
import com.tyut.model.RoleResource;
import com.tyut.service.RoleResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/21 15:35
 **/

@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements RoleResourceService {
    @Override
    public List<Integer> selectByRoleId(Integer roleId) {
        return null;
    }
}
