package org.helstern.mork.oauth2.client;

import java.net.URI;

public interface ClientInfo {

    public String getClientIdentifier();

    public String getOauthClientSecret();

    public URI getRedirectUri();
}

