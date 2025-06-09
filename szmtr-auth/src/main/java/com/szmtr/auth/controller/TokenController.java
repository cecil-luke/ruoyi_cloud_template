package com.szmtr.auth.controller;

import javax.servlet.http.HttpServletRequest;

import com.szmtr.auth.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.szmtr.auth.form.LoginBody;
import com.szmtr.auth.form.RegisterBody;
import com.szmtr.common.core.domain.R;
import com.szmtr.common.core.utils.JwtUtils;
import com.szmtr.common.core.utils.StringUtils;
import com.szmtr.common.security.auth.AuthUtil;
import com.szmtr.common.security.service.TokenService;
import com.szmtr.common.security.utils.SecurityUtils;
import com.szmtr.system.api.model.LoginUser;

import java.util.Map;

/**
 * token 控制
 *
 * @author szmtr
 */
@RestController
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping("/login")
    public R<?> login(@RequestBody LoginBody form) {
        // 用户登录
        LoginUser userInfo = sysLoginService.login(form.getUsername(), form.getPassword());
        Map tokenMap = tokenService.createToken(userInfo);
        // 获取登录token
        return R.ok(tokenMap);
    }

    @DeleteMapping("/logout")
    public R<?> logout(HttpServletRequest request) {
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            String username = JwtUtils.getUserName(token);
            // 删除用户缓存记录
            AuthUtil.logoutByToken(token);
            // 记录用户退出日志
//            sysLoginService.logout(username);
        }
        return R.ok();
    }

    @PostMapping("/refresh")
    public R<?> refresh(HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            // 刷新令牌有效期
            tokenService.refreshToken(loginUser);
            return R.ok();
        }
        return R.ok();
    }

    @PostMapping("/register")
    public R<?> register(@RequestBody RegisterBody registerBody) {
        // 用户注册
        sysLoginService.register(registerBody.getUsername(), registerBody.getPassword());
        return R.ok();
    }
}
