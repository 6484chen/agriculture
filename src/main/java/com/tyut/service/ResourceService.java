package com.tyut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyut.model.Resource;
import com.tyut.model.vo.TreeMenuVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 菜单资源表(t_resource)业务层接口.
 * @author: wangchen
 * @create: 2020/2/21 15:41
 **/

public interface ResourceService extends IService<Resource> {
    List<Resource> selectList();

    List<TreeMenuVo> selectTreeMenu(List<Integer> resourceIds, Integer type);
}
