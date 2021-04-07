package org.jonesun.user.server.controller;

import org.jonesun.user.server.entity.User;
import org.jonesun.user.server.entity.UserForm;
import org.jonesun.user.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users")
    public boolean register(@Valid @RequestBody UserForm userForm) {
        return userService.insert(userForm);
    }

    @GetMapping("users")
    public List<User> list() {
        logger.info("获取用户列表");
        return userService.selectList();
    }

}
