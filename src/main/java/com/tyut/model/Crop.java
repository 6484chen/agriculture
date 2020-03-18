package com.tyut.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
@TableName(value = "t_crop")
@lombok.Data
public class Crop implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    /** 作物ID.*/
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    /** 作物名称.*/
    private String cropName ;
    /** 作物类型.*/
    private Integer cropType;
    /** 作物产地.*/
    private String cropAddress;
    /** 作物单价.*/
    private Float cropPrice;
    /** 作物数量.*/
    private Integer cropNumber;
    /** 作物衡量单位.*/
    private String unit;
    /** 操作者.*/
    private String farmerName;
    /** 操作记录.*/
    private String operationLog;
    /** 当前状态（1：种植户，2：经销商，3：消费者）.*/
    private Integer status;
    /** 作物的相关描述.*/
    private String description;
    /** 创建时间.*/
    private Date createTime;
    /** 更新时间.*/
    private Date updateTime;


    /**主键.*/
    public static final String Id = "id";
    /**作物类型.*/
    public static final String TYPE = "cropType";
    /**操作者.*/
    public static final String FARMER_NAME = "farmerName";

}
