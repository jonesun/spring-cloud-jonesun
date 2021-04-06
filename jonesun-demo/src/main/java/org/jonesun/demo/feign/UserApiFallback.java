package org.jonesun.demo.feign;

import org.springframework.stereotype.Component;

/**
 * 故障处理
 *
 * @author jone.sun
 * 2021/4/1 17:58
 */
@Component
public class UserApiFallback implements UserApiFeign {
    @Override
    public String list() {
        return "返回异常";
    }
}
