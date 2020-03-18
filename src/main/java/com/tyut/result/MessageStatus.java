package com.tyut.result;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 返回消息的信息状态
 * @author: wangchen
 * @create: 2020/2/20 9:27
 **/


public enum MessageStatus {
    /**正常访问.*/
    SUCCESS("200", "正常访问"),
    /**系统异常.*/
    ERROR_1000("1000", "系统异常,请联系管理员"),
    /***/
    ERROR_2000("2000", "没有访问权限"),
    /**用户或者密码错误.*/
    ERROR_2001("2001", "用户或者密码错误！"),
    /**登录超时.*/
    ERROR_2002("2002", "登录超时,或者未登录！"),
    /**用户或者密码错误.*/
    ERROR_2003("2003", "密码错误！"),
    /**请求参数异常.*/
    ERROR_3001("3001", "请求参数异常");

    public static Map<String, String> MESSSAGE_SATUS_MAP = new HashMap<>();

    static {
        MessageStatus[] values = MessageStatus.values();
        for (MessageStatus messageStatus : values) {
            MESSSAGE_SATUS_MAP.put(messageStatus.getStatus(), messageStatus.getMessage());
        }
    }
    @Getter
    private String status;
    @Getter
    private String message;

    private MessageStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
