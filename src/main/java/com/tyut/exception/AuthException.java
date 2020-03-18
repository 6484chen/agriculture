package com.tyut.exception;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 权限异常  authorite
 * @author: wangchen
 * @create: 2020/2/20 10:46
 **/
public class AuthException extends RuntimeException {

    private static final long serialVersionUID = 4851186602710470490L;

    public AuthException() {
        super();
    }

    public AuthException(String status) {
        super(status);
    }

    public AuthException(Throwable cause) {
        super(cause);
    }

}
