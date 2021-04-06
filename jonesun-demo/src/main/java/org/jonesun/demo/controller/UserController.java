package org.jonesun.demo.controller;

import org.jonesun.demo.feign.UserApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jone.sun
 * 2021/4/1 17:35
 */
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserApiFeign userApiFeign;

    @GetMapping("users")
    public Object list() {
        return userApiFeign.list();
    }


}
