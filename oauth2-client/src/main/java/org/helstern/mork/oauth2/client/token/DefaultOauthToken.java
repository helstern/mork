package org.helstern.mork.oauth2.client.token;


public class DefaultOauthToken implements OauthToken {

    String accessToken;

    Long expiresIn;

    String refreshToken;

    String scope;

    public DefaultOauthToken(Builder builder) {
        this.accessToken = builder.accessToken;
        this.expiresIn = builder.expiresIn;
        this.refreshToken = builder.refreshToken;
        this.scope = builder.scope;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String accessToken;

        private Long expiresIn;

        private String refreshToken;

        private String scope;

        public Builder setAccesToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder setExpiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
            return this;

        }

        public Builder setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Builder setScope(String scope) {
            this.scope = scope;
            return this;
        }

        public DefaultOauthToken build()
        {
            DefaultOauthToken result = new DefaultOauthToken(this);
            return result;
        }

    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public Long getExpiresIn() {
        return expiresIn;
    }

    @Override
    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public String getScope() {
        return scope;
    }
}
