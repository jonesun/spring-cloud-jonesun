package org.jonesun.auth.domain.entity;

/**
 * @author jone.sun
 * 2021/4/12 13:03
 */

public class Client {
    private String clientId;
    private String resourceIds;
    private Boolean secretRequire;
    private String clientSecret;
    private Boolean scopeRequire;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;

    public static Client.ClientBuilder builder() {
        return new Client.ClientBuilder();
    }

    public Client.ClientBuilder toBuilder() {
        return (new Client.ClientBuilder()).clientId(this.clientId).resourceIds(this.resourceIds).secretRequire(this.secretRequire).clientSecret(this.clientSecret).scopeRequire(this.scopeRequire).scope(this.scope).authorizedGrantTypes(this.authorizedGrantTypes).webServerRedirectUri(this.webServerRedirectUri).authorities(this.authorities).accessTokenValidity(this.accessTokenValidity).refreshTokenValidity(this.refreshTokenValidity);
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getResourceIds() {
        return this.resourceIds;
    }

    public Boolean getSecretRequire() {
        return this.secretRequire;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public Boolean getScopeRequire() {
        return this.scopeRequire;
    }

    public String getScope() {
        return this.scope;
    }

    public String getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return this.webServerRedirectUri;
    }

    public String getAuthorities() {
        return this.authorities;
    }

    public Integer getAccessTokenValidity() {
        return this.accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return this.refreshTokenValidity;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public void setSecretRequire(Boolean secretRequire) {
        this.secretRequire = secretRequire;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScopeRequire(Boolean scopeRequire) {
        this.scopeRequire = scopeRequire;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    @Override
    public String toString() {
        return "Client(clientId=" + this.getClientId() + ", resourceIds=" + this.getResourceIds() + ", secretRequire=" + this.getSecretRequire() + ", clientSecret=" + this.getClientSecret() + ", scopeRequire=" + this.getScopeRequire() + ", scope=" + this.getScope() + ", authorizedGrantTypes=" + this.getAuthorizedGrantTypes() + ", webServerRedirectUri=" + this.getWebServerRedirectUri() + ", authorities=" + this.getAuthorities() + ", accessTokenValidity=" + this.getAccessTokenValidity() + ", refreshTokenValidity=" + this.getRefreshTokenValidity() + ")";
    }

    public Client(String clientId, String resourceIds, Boolean secretRequire, String clientSecret, Boolean scopeRequire, String scope, String authorizedGrantTypes, String webServerRedirectUri, String authorities, Integer accessTokenValidity, Integer refreshTokenValidity) {
        this.clientId = clientId;
        this.resourceIds = resourceIds;
        this.secretRequire = secretRequire;
        this.clientSecret = clientSecret;
        this.scopeRequire = scopeRequire;
        this.scope = scope;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.webServerRedirectUri = webServerRedirectUri;
        this.authorities = authorities;
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public static class ClientBuilder {
        private String clientId;
        private String resourceIds;
        private Boolean secretRequire;
        private String clientSecret;
        private Boolean scopeRequire;
        private String scope;
        private String authorizedGrantTypes;
        private String webServerRedirectUri;
        private String authorities;
        private Integer accessTokenValidity;
        private Integer refreshTokenValidity;

        ClientBuilder() {
        }

        public Client.ClientBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Client.ClientBuilder resourceIds(String resourceIds) {
            this.resourceIds = resourceIds;
            return this;
        }

        public Client.ClientBuilder secretRequire(Boolean secretRequire) {
            this.secretRequire = secretRequire;
            return this;
        }

        public Client.ClientBuilder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public Client.ClientBuilder scopeRequire(Boolean scopeRequire) {
            this.scopeRequire = scopeRequire;
            return this;
        }

        public Client.ClientBuilder scope(String scope) {
            this.scope = scope;
            return this;
        }

        public Client.ClientBuilder authorizedGrantTypes(String authorizedGrantTypes) {
            this.authorizedGrantTypes = authorizedGrantTypes;
            return this;
        }

        public Client.ClientBuilder webServerRedirectUri(String webServerRedirectUri) {
            this.webServerRedirectUri = webServerRedirectUri;
            return this;
        }

        public Client.ClientBuilder authorities(String authorities) {
            this.authorities = authorities;
            return this;
        }

        public Client.ClientBuilder accessTokenValidity(Integer accessTokenValidity) {
            this.accessTokenValidity = accessTokenValidity;
            return this;
        }

        public Client.ClientBuilder refreshTokenValidity(Integer refreshTokenValidity) {
            this.refreshTokenValidity = refreshTokenValidity;
            return this;
        }

        public Client build() {
            return new Client(this.clientId, this.resourceIds, this.secretRequire, this.clientSecret, this.scopeRequire, this.scope, this.authorizedGrantTypes, this.webServerRedirectUri, this.authorities, this.accessTokenValidity, this.refreshTokenValidity);
        }

        @Override
        public String toString() {
            return "Client.ClientBuilder(clientId=" + this.clientId + ", resourceIds=" + this.resourceIds + ", secretRequire=" + this.secretRequire + ", clientSecret=" + this.clientSecret + ", scopeRequire=" + this.scopeRequire + ", scope=" + this.scope + ", authorizedGrantTypes=" + this.authorizedGrantTypes + ", webServerRedirectUri=" + this.webServerRedirectUri + ", authorities=" + this.authorities + ", accessTokenValidity=" + this.accessTokenValidity + ", refreshTokenValidity=" + this.refreshTokenValidity + ")";
        }
    }

}
