package org.helstern.mork.dw.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.helstern.mork.oauth2.client.ClientInfo;
import org.helstern.mork.oauth2.client.ProviderInfo;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class MendeleyApiConfiguration implements ClientInfo, ProviderInfo
{
    @NotNull
    String oauthProviderHostname;

    @NotNull
    String oauthClientId;

    @NotNull
    String oauthClientSecret;

    @JsonProperty
    public void setOauthProviderHostname(String endPoint)
    {
        this.oauthProviderHostname = endPoint;
    }

    @JsonProperty
    public String getOauthProviderHostname()
    {
        return oauthProviderHostname;
    }

    @JsonProperty
    public String getOauthClientId() {
        return oauthClientId;
    }

    @JsonProperty
    public void setOauthClientId(String oauthClientId) {
        this.oauthClientId = oauthClientId;
    }

    @Override
    public String getClientIdentifier() {
        return oauthClientId;
    }

    @JsonProperty
    public String getOauthClientSecret() {
        return oauthClientSecret;
    }

    @Override
    public URI getRedirectUri() {
        return null;
    }

    public void setOauthClientSecret(String oauthClientSecret) {
        this.oauthClientSecret = oauthClientSecret;
    }

    @Override
    public URI getAuthorizationUri() {
        String apiEndPoint = this.getOauthProviderHostname();

        URI uri = UriBuilder.fromUri("")
            .scheme("https")
            .host(apiEndPoint)
            .path("oauth/authorize")
            .build()
        ;

        return uri;
    }

    @Override
    public URI getTokenUri() {
        String apiEndPoint = this.getOauthProviderHostname();

        URI uri = UriBuilder.fromUri("")
                .scheme("https")
                .host(apiEndPoint)
                .path("oauth/token")
                .build()
                ;

        return uri;
    }
}
