package com.tyut.exception;

import com.tyut.result.MessageStatus;
import com.tyut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/3/9 17:58
 **/

@Slf4j
@ControllerAdvice
public class WholeExceptionHandler {


    /**
     * 会话超时异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = LoginOutTimeException.class)
    @ResponseBody
    public Result loginOutTimeException(HttpServletRequest req, LoginOutTimeException e) {
        log.error(e.getMessage());
        return Result.getInstance(MessageStatus.ERROR_2002.getStatus(), MessageStatus.ERROR_2002.getMessage());
    }

}
