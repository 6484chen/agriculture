package com.tyut.utils;

import java.util.Collection;
import java.util.UUID;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 字符串处理工具
 * @author: wangchen
 * @create: 2020/2/20 10:40
 **/
public class StringUtils extends org.apache.commons.lang.StringUtils {

    private StringUtils() {
    }

    /**
     * 判断集合是否为null，或者空集合
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 获取UUID
     * @return str
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断集合是否为null，或者空集合
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
