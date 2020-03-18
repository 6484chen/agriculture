package com.tyut.exception;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 登出异常
 * @author: wangchen
 * @create: 2020/2/20 17:46
 **/

public class LoginOutTimeException extends RuntimeException {

    private static final long serialVersionUID = 4851186602710470490L;

    public LoginOutTimeException() {
        super();
    }

    public LoginOutTimeException(String status) {
        super(status);
    }

    public LoginOutTimeException(Throwable cause) {
        super(cause);
    }
}
