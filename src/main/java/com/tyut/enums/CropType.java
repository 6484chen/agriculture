package com.tyut.enums;

import lombok.Getter;

/**
 * @PACKAGE_NAME: agricuture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/17 14:18
 **/
public enum CropType {
    /** 蔬菜类.*/
    VEGETABLES(1),
    /** 水果类.*/
    FRUIT(2),
    /** 粮油类.*/
    GRAIN_AND_OIL(3),
    /** 林产品类.*/
    FOREST_PRODUCT(4),
    /** 禽畜类.*/
    LIVESTOCK(5),
    /** 水产品类.*/
    AQUATIC_PRODUCTS(6),
    /** 花卉类.*/
    FLOWERS(7),
    /** 其他农副产品类.*/
    AGRICULTURE_AND_SIDELINE_PRODUCTS(8);
    @Getter
    private Integer type;

    private CropType(Integer type){
        this.type =type;
    }
}
