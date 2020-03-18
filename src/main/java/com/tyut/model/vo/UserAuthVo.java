package com.tyut.model.vo;

import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 用户权限的model类
 * @author: wangchen
 * @create: 2020/2/20 10:31
 **/

@lombok.Data
public class UserAuthVo {

    private static final long serialVersionUID = 1502772594937481705L;
    /**用户id.*/
    private Integer userId;
    /**用户名.*/
    private String name;
    /**登录名.*/
    private String loginName;
    /**菜单角色名称.*/
    private String roleName;
    /**菜单角色id.*/
    private Integer roleId;
    /**登录的token.*/
    private String token;
    /**用户的树状结构.*/
//    private List<TreeMenuVo> treeList;
}
