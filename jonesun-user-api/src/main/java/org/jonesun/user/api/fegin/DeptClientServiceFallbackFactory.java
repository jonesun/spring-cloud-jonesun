package org.jonesun.user.api.fegin;

/**
 * 故障统一处理
 *

 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Feign中使用断路器
 * 这里主要是处理异常出错的情况(降级/熔断时服务不可用，fallback就会找到这里来)
 * @author jone.sun
 * 2021/4/6 10:33
 */
@Component // 不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<UserApiFeign> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public UserApiFeign create(Throwable throwable) {
        return () -> {
            logger.error("服务不可用，返回异常");
            return "返回异常";
        };
    }
}