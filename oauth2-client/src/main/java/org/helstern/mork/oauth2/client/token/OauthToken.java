package org.helstern.mork.oauth2.client.token;

public interface OauthToken {

    public String getAccessToken();

    public Long getExpiresIn();

    public String getRefreshToken();

    public String getScope();
}
