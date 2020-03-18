package com.tyut.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/17 14:33
 **/

@lombok.Data
@TableName(value = "t_user")
/**   KeySequence是支持父类定义@KeySequence子类继承使用
@KeySequence(value = "t_user_id_seq", clazz = Integer.class)
*/
public class User implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    /**主键.*/
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**用户姓名.*/
    private String name;

    /**登录名称.*/
    @TableField(value = "login_name")
    private String loginName;

    /**用户密码.*/
    private String password;

    /**盐值.*/
    private String salt;

    /**用户联系方式.*/
    private String phone;

    /**用户状态(1:启用;2:停用).*/
    private Integer status;

    /**角色id.*/
    @TableField(value = "role_id")
    private Integer roleId;


    /**创建时间.*/
    @TableField(value = "create_time")
    private Date createTime;

    /**修改时间.*/
    @TableField(value = "update_time")
    private Date updateTime;


    /**主键.*/
    public static final String ID = "id";

    /**用户姓名.*/
    public static final String NAME = "name";

    /**登录名称.*/
    public static final String LOGIN_NAME = "login_name";

    /**用户密码.*/
    public static final String PASSWORD = "password";

    /**盐值.*/
    public static final String SALT = "salt";

    /**用户联系方式.*/
    public static final String PHONE = "phone";

    /**用户状态(1:启用;2:停用).*/
    public static final String STATUS = "status";

    /**角色id.*/
    public static final String ROLE_ID = "role_id";

    /**备注.*/
    public static final String REMARK = "remark";

    /**创建时间.*/
    public static final String CREATE_TIME = "create_time";

    /**修改时间.*/
    public static final String UPDATE_TIME = "update_time";




}
