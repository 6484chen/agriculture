package com.tyut.controller;


import com.tyut.common.CodeConstants;
import com.tyut.component.LoginComponent;
import com.tyut.model.vo.UserAuthVo;
import com.tyut.result.Result;
import com.tyut.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(tags = { "登录-数据安全校验" })
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginComponent loginComponent;
    @Autowired
    UserService userService;

    @PostMapping(value = "/check")
    @ApiOperation(value = "数据安全校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "登录名", dataType = "String", paramType = "query", required = true, defaultValue = "admin"),
            @ApiImplicitParam(name = "password", value = "登录密码", dataType = "String", paramType = "query", required = true, defaultValue = "123456") })
    public Result check(HttpServletResponse response, @RequestParam("loginName") String loginName,
                        @RequestParam("password") String password) {
        userService.selectUser(loginName, password);
        return Result.getInstance();
    }

    /**
     * 前台登录 TODO 修改登录路径（参数  CodeConstants.DISPATCHING）
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "登录名", dataType = "String", paramType = "query", required = true, defaultValue = "admin"),
            @ApiImplicitParam(name = "password", value = "登录密码", dataType = "String", paramType = "query", required = true, defaultValue = "123456") })
    public Result loginFront(HttpServletResponse response,@RequestParam("loginName") String loginName,@RequestParam("password") String password) {
        UserAuthVo userVo = loginComponent.login(response,loginName,password,CodeConstants.FORE);
        return Result.getInstance(userVo);
    }

    /**
     * 后台登录
     * @return
     */
    @PostMapping(value = "/operators")
    @ApiOperation(value = "电厂侧登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "登录名", dataType = "String", paramType = "query", required = true, defaultValue = "admin_ibp"),
            @ApiImplicitParam(name = "password", value = "登录密码", dataType = "String", paramType = "query", required = true, defaultValue = "123456") })
    public Result loginBackstage(HttpServletResponse response, @RequestParam("loginName") String loginName,
                                 @RequestParam("password") String password) {
        System.out.println(loginName +":"+ password);
        UserAuthVo userVo = loginComponent.login(response, loginName, password, CodeConstants.ADMIN);
        return Result.getInstance(userVo);
    }

    @PostMapping(value = "/logout")
    @ApiOperation(value = "登出接口")
    public Result logout(HttpServletRequest request) {
        loginComponent.logout(request);
        return Result.getInstance();
    }
}
