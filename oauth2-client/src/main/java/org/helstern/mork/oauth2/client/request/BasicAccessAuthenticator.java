package org.helstern.mork.oauth2.client.request;

import org.helstern.mork.oauth2.client.ClientInfo;
import sun.misc.BASE64Encoder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriBuilder;

public class BasicAccessAuthenticator implements RequestAuthenticator {

    protected String clientId;

    protected String clientSecret;

    public BasicAccessAuthenticator(ClientInfo clientInfo) {
        this.clientId = clientInfo.getClientIdentifier();
        this.clientSecret = clientInfo.getOauthClientSecret();
    }

    public BasicAccessAuthenticator(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    protected String buildHeaderValue() {
        byte[] unencoded = (new StringBuilder()).append(clientId).append(':').append(clientSecret).toString().getBytes();
        String headerValue = (new StringBuilder()).append("Basic").append(' ').append(new BASE64Encoder().encode(unencoded)).toString();

        return headerValue;
    }

    public boolean setAuthenticatingHeaders(Invocation.Builder invocationBuilder) {
        invocationBuilder.header(HttpHeaders.AUTHORIZATION, buildHeaderValue());
        return true;
    }

    public boolean insertAllQueryParams(UriBuilder uriBuilder) {
        return false;
    }

    public boolean insertAllFormParams(Form form) {
        return false;
    }
}
