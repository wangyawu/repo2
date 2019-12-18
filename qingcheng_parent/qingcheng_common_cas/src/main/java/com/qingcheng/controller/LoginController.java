package com.qingcheng.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 86186
 * @Date 2019/10/22 20:18
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 获取用户名
     * @return
     */
    @GetMapping("/username")
    public Map username(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if ("anonymousUser".equals(username)) { // anonymousUser为默认未登录时的名字
            username = "";
        }
        Map map = new HashMap();
        map.put("username", username);
        return map;
    }

}
