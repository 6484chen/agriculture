package com.tyut.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 角色资源中间表(t_role_resource)的实体.
 * @author: wangchen
 * @create: 2020/2/21 15:23
 **/

@lombok.Data
@TableName(value = "t_role_resource")
public class RoleResource implements Serializable {
    private static final long serialVersionUID = 1L;

    /**角色id.*/
    @TableId(value = "role_id", type = IdType.INPUT)
    private Integer roleId;

    /**菜单资源id.*/
    @TableField(value = "resource_id")
    private Integer resourceId;

//    /**角色id.*/
//    public static final String ROLE_ID = "role_id";
//
//    /**菜单资源id.*/
//    public static final String RESOURCE_ID = "resource_id";
}
