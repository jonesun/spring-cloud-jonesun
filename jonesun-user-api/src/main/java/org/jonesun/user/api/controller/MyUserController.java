package org.jonesun.user.api.controller;

import org.jonesun.user.api.domain.UserDTO;
import org.jonesun.user.api.fegin.MyUserApiFeign;
import org.jonesun.user.api.holder.LoginUserHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author jone.sun
 * 2021/3/18 10:24
 */
@RefreshScope
@RestController
@RequestMapping("/api")
public class MyUserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${nacos.config:null}")
    private String config;

    private final MyUserApiFeign myUserApiFeign;

    @Autowired
    public MyUserController(MyUserApiFeign myUserApiFeign) {
        this.myUserApiFeign = myUserApiFeign;
    }

    @GetMapping("users")
    public Object list() {
        logger.info("获取用户列表, {}", config);
        return myUserApiFeign.list();
    }

    @Autowired
    private LoginUserHolder loginUserHolder;

    @GetMapping("/currentUser")
    public UserDTO currentUser() {
        return loginUserHolder.getCurrentUser();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World !";
    }

}
