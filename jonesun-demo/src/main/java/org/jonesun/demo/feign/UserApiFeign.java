package org.jonesun.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jone.sun
 * 2021/4/1 17:42
 */
@FeignClient(name = "jonesun-gateway", path = "jonesun-user-api",
//        fallback = UserApiFallback.class,
        fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface UserApiFeign {

    @GetMapping("/api/users")
    String list();
}
