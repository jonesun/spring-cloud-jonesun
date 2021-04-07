package org.jonesun.user.api.fegin;

import org.jonesun.user.api.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jone.sun
 * 2021/4/1 17:42
 */
@FeignClient(contextId = "myUserApiFeign", value = "jonesun-user-server",
//        fallback = MyUserApiFallback.class,
        fallbackFactory = DeptClientServiceFallbackFactory.class,
        configuration = FeignConfig.class
)
public interface MyUserApiFeign {

    @GetMapping("/api/users")
    String list();
}
