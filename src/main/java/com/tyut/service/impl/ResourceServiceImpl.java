package com.tyut.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.mapper.ResourceMapper;
import com.tyut.model.Resource;
import com.tyut.model.vo.TreeMenuVo;
import com.tyut.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/21 15:44
 **/

@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    @Override
    public List<Resource> selectList() {
        return null;
    }

    @Override
    public List<TreeMenuVo> selectTreeMenu(List<Integer> resourceIds, Integer type) {
        return null;
    }
}
