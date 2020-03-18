package com.tyut.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 用户角色信息表(t_role)的实体.
 * @author: wangchen
 * @create: 2020/2/21 15:19
 **/

@lombok.Data
@TableName(value = "t_role" )
/*@KeySequence(value = "t_role_id_seq", clazz = Integer.class)*/
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**主键.*/
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**角色名称.*/
    private String name;

    /**角色状态(1:启用;2:停用).*/
    private Integer status;

    /**备注.*/
    private String remark;

    /**创建时间.*/
    @TableField(value = "create_time")
    private Date createTime;

    /**修改时间.*/
    @TableField(value = "update_time")
    private Date updateTime;
}
