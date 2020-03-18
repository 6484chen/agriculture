package com.tyut.component;

import com.alibaba.fastjson.JSON;

import com.tyut.common.CodeConstants;
import com.tyut.common.RedisKey;
import com.tyut.exception.AuthException;
import com.tyut.exception.LoginOutTimeException;
import com.tyut.model.User;
import com.tyut.model.vo.TreeMenuVo;
import com.tyut.model.vo.UserAuthVo;
import com.tyut.result.MessageStatus;
import com.tyut.service.ResourceService;
import com.tyut.service.RoleResourceService;
import com.tyut.service.RoleService;
import com.tyut.service.UserService;
import com.tyut.utils.MD5Utils;
import com.tyut.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class LoginComponent {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    RoleResourceService roleResourceService;

    private static final String TOKEN = "token";

    /**
     * 登录组件
     * @param response
     * @param loginName
     * @param password
     * @param type
     * @return
     */
    public UserAuthVo login(HttpServletResponse response, String loginName, String password, Integer type) {
        User user = userService.selectUser(loginName, password);
        Integer roleId = user.getRoleId();
        Integer userId = user.getId();
        //暂时取消目录验证
       /* // 菜单信息,校验菜单权限
        List<Integer> resourceIds = roleResourceService.selectByRoleId(roleId);
        List<TreeMenuVo> treeMenu = resourceService.selectTreeMenu(resourceIds, type);
        if (StringUtils.isEmpty(treeMenu)) {
            throw new AuthException(MessageStatus.ERROR_2000.getMessage());
        }*/
//        String token = MD5Utils.md5(user.getId() + user.getLoginName());
        String token = StringUtils.getUUID();
        String key = RedisKey.LOGIN_TOKEN_KEY + ":" + token;
        // 加入head
        response.addHeader(TOKEN, token);
        // cookie 储存token
        Cookie cookie = new Cookie(TOKEN, token);
        // 默认是第一层路径下的，设置为跟路径
        cookie.setPath("/");
        cookie.setMaxAge(CodeConstants.DAY_TIMEMILLS.intValue());
        response.addCookie(cookie);

        Map<Integer, String> roleMap = roleService.selectMap();
        UserAuthVo vo = new UserAuthVo();
        vo.setRoleId(roleId);
        vo.setRoleName(roleMap.get(roleId));
        vo.setToken(token);
//        vo.setTreeList(treeMenu);
        vo.setUserId(userId);
        vo.setLoginName(loginName);
        vo.setName(user.getName());
        // 超时时间一天
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(vo), 1, TimeUnit.DAYS);
        return vo;
    }

    /**
     * 登出组件
     * @param request
     */
    public void logout(HttpServletRequest request) {
        String header = request.getHeader(TOKEN);
        boolean flag = false;
        if (StringUtils.isNotEmpty(header)) {
            stringRedisTemplate.delete(String.format(RedisKey.LOGIN_TOKEN_KEY + ":" + header));
            flag = true;
        }
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            Optional<Cookie> cook = Arrays.stream(cookies).filter(cookie -> TOKEN.equals(cookie.getName())).findAny();
            if (cook.isPresent() && !flag) {
                stringRedisTemplate.delete(RedisKey.LOGIN_TOKEN_KEY + ":" + cook.get().getValue());
            }
        }
    }

    /**
     * 获取登录的用户信息
     * @param request
     * @return
     */
    public UserAuthVo getUserAuth(HttpServletRequest request) {
        String header = request.getHeader(TOKEN);
        if (StringUtils.isNotEmpty(header)) {
            String token = stringRedisTemplate.opsForValue().get(RedisKey.LOGIN_TOKEN_KEY + ":" + header);
            if (StringUtils.isEmpty(token)) {
                throw new LoginOutTimeException("not login or login is time out");
            }
            return JSON.parseObject(token, UserAuthVo.class);
        }
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            Optional<Cookie> cook = Arrays.stream(cookies).filter(cookie -> TOKEN.equals(cookie.getName())).findAny();
            System.out.println(cook.isPresent());
            if (cook.isPresent()) {
                // TODO Redis为空
                String token = stringRedisTemplate.opsForValue()
                        .get(RedisKey.LOGIN_TOKEN_KEY + ":" + cook.get().getValue());
                System.out.println(token);          // null
                if (StringUtils.isEmpty(token)) {
                    throw new LoginOutTimeException("not login or login is time out");
                }

                return JSON.parseObject(token, UserAuthVo.class);
            }
        }
        throw new LoginOutTimeException("not login or login is time out");
    }
}
