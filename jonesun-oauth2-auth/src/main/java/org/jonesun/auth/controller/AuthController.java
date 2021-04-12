package org.jonesun.auth.controller;

import cn.hutool.json.JSONUtil;
import org.jonesun.auth.api.CommonResult;
import org.jonesun.auth.domain.dto.Oauth2TokenDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;
import java.util.Objects;

/**
 * 自定义Oauth2获取令牌接口
 * @author jone.sun
 * 2021/4/12 13:03
 */
@RestController
@RequestMapping("/oauth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TokenEndpoint tokenEndpoint;

    public AuthController(TokenEndpoint tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }

//    @ApiImplicitParam(name = "grant_type", defaultValue = "password", value = "授权模式", required = true),
//    @ApiImplicitParam(name = "client_id", defaultValue = "client", value = "Oauth2客户端ID", required = true),
//    @ApiImplicitParam(name = "client_secret", defaultValue = "123456", value = "Oauth2客户端秘钥", required = true),
//    @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
//    @ApiImplicitParam(name = "username", defaultValue = "admin", value = "登录用户名"),
//    @ApiImplicitParam(name = "password", defaultValue = "123456", value = "登录密码"),
    /**
     * Oauth2登录认证
     */
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public CommonResult<Oauth2TokenDto> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        logger.info("postAccessToken->principal{}, parameters{}", JSONUtil.toJsonStr(principal), JSONUtil.toJsonStr(parameters));
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(Objects.requireNonNull(oAuth2AccessToken).getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead("Bearer ").build();
        return CommonResult.success(oauth2TokenDto);
    }
}
