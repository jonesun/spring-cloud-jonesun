package org.jonesun.demoapp;

import java.util.Map;

/**
 * @author jone.sun
 * @date 2020-12-28 17:12
 */
public class LoginResponseResult {

    private long code;
    private String message;
    private Data data;

    public static class Data {
        private String token;
        private String refreshToken;
        private String tokenHead;
        private Long expiresIn;

        public void setToken(String token) {
            this.token = token;
        }

        public void setTokenHead(String tokenHead) {
            this.tokenHead = tokenHead;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public void setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getToken() {
            return token;
        }

        public String getTokenHead() {
            return tokenHead;
        }

        public Long getExpiresIn() {
            return expiresIn;
        }
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
