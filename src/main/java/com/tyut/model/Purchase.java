package com.tyut.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 收购表（代理商）
 * @author: wangchen
 * @create: 2020/3/17 16:39
 **/

@TableName(value = "t_purchase")
public class Purchase implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    /** 作物ID.*/
    @TableId(value = "crop_id", type = IdType.INPUT)
    private Integer cropId;
    /** 作物类型.*/
    private Integer cropType;
    /** 经销商登录名.*/
    private String agentName ;
    /** 种植户登录名.*/
    private String farmerName;
    /** 收购地点.*/
    private String purchaseAddress;
    /** 收购数量.*/
    private Integer purchaseNumber;
    /** 收购单价.*/
    private String purchasePrice;
    /** 衡量单位（斤）.*/
    private String unit;
    /** 当前状态（1：种植户，2：经销商，3：消费者）.*/
    private Integer status;

    /** 创建时间.*/
    private Date createTime;
    /** 更新时间.*/
    private Date updateTime;

    /**主键.*/
    public static final String CROP_ID = "cropId";
    /**类型.*/
    public static final String CROP_TYPE = "crop_type";

}
