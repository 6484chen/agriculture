package com.tyut.model.vo;

import java.util.Date;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/3/17 21:48
 **/

@lombok.Data
public class PurchaseVo {


    /** 作物名称.*/
    private String cropName ;
    /** 作物产地.*/
    private String cropAddress;
    /** 作物单价.*/
    private Float cropPrice;
    /** 作物数量.*/
    private Integer cropNumber;
    /** 作物衡量单位.*/
    private String unit;
    /** 作物的相关描述.*/
    private String description;
    /** 创建时间.*/
    private Date createTime;

}
