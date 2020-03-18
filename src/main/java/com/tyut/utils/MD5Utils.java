package com.tyut.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/28 16:22
 **/
public class MD5Utils {
    private MD5Utils() {

    }

    /**
     * md5 32位小写.
     * @param s 需要转换的字符串
     * @return str
     */
    public static String md5(final String s) {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = s.getBytes("utf-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j << 1];
            int k = 0;
            final int offset = 0x0f;
            final int dd = 4;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> dd & offset];
                str[k++] = hexDigits[byte0 & offset];
            }
            return new String(str);
        } catch (final Exception e) {
            return "";
        }
    }

    /**
     * md5 32位大写.
     * @param str 需要转换的字符串
     * @return str
     */
    public static String md5Big(final String str) {
        return md5(str).toUpperCase();
    }

    /**
     * md5后转base64.
     * @param str 需要转换的字符串
     * @return str
     */
    public static String md5Base64(final String str) {
        try {
            byte[] btInput = str.getBytes("utf-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            return new String(Base64.encodeBase64(md));
        } catch (final Exception e) {
            return "";
        }
    }
}
