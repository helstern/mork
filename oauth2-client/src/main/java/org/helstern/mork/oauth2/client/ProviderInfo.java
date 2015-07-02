package org.helstern.mork.oauth2.client;

import java.net.URI;

public interface ProviderInfo {

    public URI getAuthorizationUri();

    public URI getTokenUri();
}
