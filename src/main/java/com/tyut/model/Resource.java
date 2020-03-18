package com.tyut.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 菜单资源表(t_resource)
 * @author: wangchen
 * @create: 2020/2/20 18:16
 **/

@lombok.Data
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键.*/
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**静态资源名称.*/
    private String name;

    /**资源级别.*/
    private Integer level;

    /**静态资源父id.*/
    @TableField(value = "parent_id")
    private Integer parentId;

    /**路由器.*/
    private String router;

    /**后台接口主路由.*/
    @TableField(value = "router_api")
    private String routerApi;

    /**图标.*/
    private String icon;

    /**启用状态(1:启用;2:停用;).*/
    private Integer status;

    /**创建时间.*/
    @TableField(value = "create_time")
    private Date createTime;

    /**更新时间.*/
    @TableField(value = "update_time")
    private Date updateTime;

}
