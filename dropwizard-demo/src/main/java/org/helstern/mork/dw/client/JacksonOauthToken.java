package org.helstern.mork.dw.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.helstern.mork.oauth2.client.token.OauthToken;


public class JacksonOauthToken implements OauthToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("token_type")
    private String tokenType;

    public JacksonOauthToken() {}

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
