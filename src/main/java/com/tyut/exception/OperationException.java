package com.tyut.exception;

/**
 * @PACKAGE_NAME: agriculture
 * @description: 操作异常
 * @author: wangchen
 * @create: 2020/2/20 15:16
 **/
public class OperationException extends RuntimeException {

    private static final long serialVersionUID = -5576347375007886512L;

    public OperationException() {
        super();
    }

    public OperationException(String message) {
        super(message);
    }

    public OperationException(Throwable cause) {
        super(cause);
    }
}
