package org.jonesun.auth.service.impl;

import cn.hutool.core.collection.CollUtil;
import org.jonesun.auth.constant.RedisConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * @author jone.sun
 * 2021/4/12 13:39
 */
@Service
public class ResourceServiceImpl {

    private final RedisTemplate<String, Object> redisTemplate;

    public ResourceServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void initData() {
        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/resource/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/resource/user/currentUser", CollUtil.toList("ADMIN", "USER"));
        resourceRolesMap.put("/jonesun-user-api/api/users", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/jonesun-user-api/api/currentUser", CollUtil.toList("ADMIN", "USER"));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }

}
