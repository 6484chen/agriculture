package com.tyut.utils;

import org.apache.commons.codec.binary.StringUtils;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/28 16:27
 **/
public class Base64Utils extends org.apache.commons.codec.binary.Base64{

    private Base64Utils() {

    }

    /**
     * bese64转 字符串.
     * @param base64Data base64的字节数组
     * @return str
     */
    public static String decodeBase64String(final byte[] base64Data) {
        return StringUtils.newStringUtf8(decodeBase64(base64Data));
    }

    /**
     * bese64转 字符串.
     * @param base64Data base64的字符串
     * @return str
     */
    public static String decodeBase64String(final String base64Data) {
        return StringUtils.newStringUtf8(decodeBase64(base64Data));
    }

    /**
     * 字节数组转base64.
     * @param binaryData 字节数组
     * @return str
     */
    public static String encodeBase64String(final byte[] binaryData) {
        return StringUtils.newStringUtf8(encodeBase64(binaryData, false));
    }

    /**
     * 字符串转base64.
     * @param binaryData 字节数组
     * @return str
     */
    public static String encodeBase64String(final String binaryData) {
        return StringUtils.newStringUtf8(encodeBase64(StringUtils.getBytesUtf8(binaryData), false));
    }

}
