package org.jonesun.user.api.controller;

import org.jonesun.user.api.fegin.UserApiFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author jone.sun
 * 2021/3/18 10:24
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserApiFeign userApiFeign;

    @Autowired
    public UserController(UserApiFeign userApiFeign) {
        this.userApiFeign = userApiFeign;
    }


    @GetMapping("users")
    public Object list() {
        logger.info("获取用户列表");
        return userApiFeign.list();
    }

}
