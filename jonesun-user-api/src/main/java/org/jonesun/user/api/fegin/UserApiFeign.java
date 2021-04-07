package org.jonesun.user.api.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jone.sun
 * 2021/4/1 17:42
 */
@FeignClient(value = "jonesun-user-server",
//        fallback = UserApiFallback.class,
        fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface UserApiFeign {

    @GetMapping("/api/users")
    String list();
}
