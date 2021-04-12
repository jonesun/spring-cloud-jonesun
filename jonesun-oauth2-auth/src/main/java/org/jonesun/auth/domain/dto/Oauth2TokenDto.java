package org.jonesun.auth.domain.dto;

/**
 * Oauth2获取Token返回信息封装
 * @author jone.sun
 * 2021/4/12 13:03
 */
public class Oauth2TokenDto {
    /**
     * 访问令牌
     */
    private String token;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 访问令牌头前缀
     */
    private String tokenHead;
    /**
     * 有效时间（秒）
     */
    private int expiresIn;

    Oauth2TokenDto(String token, String refreshToken, String tokenHead, int expiresIn) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.tokenHead = tokenHead;
        this.expiresIn = expiresIn;
    }

    public static Oauth2TokenDto.Oauth2TokenDtoBuilder builder() {
        return new Oauth2TokenDto.Oauth2TokenDtoBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getTokenHead() {
        return this.tokenHead;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "Oauth2TokenDto(token=" + this.getToken() + ", refreshToken=" + this.getRefreshToken() + ", tokenHead=" + this.getTokenHead() + ", expiresIn=" + this.getExpiresIn() + ")";
    }

    public static class Oauth2TokenDtoBuilder {
        private String token;
        private String refreshToken;
        private String tokenHead;
        private int expiresIn;

        Oauth2TokenDtoBuilder() {
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder token(String token) {
            this.token = token;
            return this;
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder tokenHead(String tokenHead) {
            this.tokenHead = tokenHead;
            return this;
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder expiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        public Oauth2TokenDto build() {
            return new Oauth2TokenDto(this.token, this.refreshToken, this.tokenHead, this.expiresIn);
        }

        @Override
        public String toString() {
            return "Oauth2TokenDto.Oauth2TokenDtoBuilder(token=" + this.token + ", refreshToken=" + this.refreshToken + ", tokenHead=" + this.tokenHead + ", expiresIn=" + this.expiresIn + ")";
        }
    }
}
