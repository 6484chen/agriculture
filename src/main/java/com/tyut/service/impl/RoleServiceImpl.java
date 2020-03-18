package com.tyut.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.common.RedisKey;
import com.tyut.mapper.RoleMapper;
import com.tyut.model.Role;
import com.tyut.service.RoleService;
import com.tyut.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/21 15:26
 **/


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Role> selectList() {
        ValueOperations<String, String> redisVal = stringRedisTemplate.opsForValue();
        String val = redisVal.get(RedisKey.ROLE_KEY);
        if (StringUtils.isEmpty(val)) {
            List<Role> list = this.list();
            redisVal.set(RedisKey.ROLE_KEY, JSON.toJSONString(list));
            return list;
        }
        return JSON.parseArray(val, Role.class);
    }

    @Override
    public Map<Integer, String> selectMap() {
        return selectList().stream().collect(Collectors.toMap(Role::getId,Role::getName));
    }
}
