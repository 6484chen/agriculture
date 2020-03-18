package com.tyut.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 统一返回类型，前后端分离
 * @author: wangchen
 * @create: 2020/2/20 9:24
 **/

@Getter
@Setter
@ApiModel(value = "返回的信息")
public class Result implements Serializable {

    private static final long serialVersionUID = -773630722718841243L;

    /**失败的消息代码.*/
    @ApiModelProperty(value = "失败的消息代码")
    private String status;

    /**返回的对象*/
    @ApiModelProperty(value = "返回的对象")
    private Object value;

    private Result(String status, Object value) {
        this.value = value;
        this.status = status;
    }

    public static Result getInstance(String status, Object value) {
        return new Result(status, value);
    }

    public static Result getInstance() {
        return new Result(MessageStatus.SUCCESS.getStatus(), null);
    }

    public static Result getInstance(Object value) {
        return new Result(MessageStatus.SUCCESS.getStatus(), value);
    }
}
