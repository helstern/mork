package org.helstern.mork.oauth2.client;


import org.helstern.mork.oauth2.client.authorization.AuthorizationContext;
import org.helstern.mork.oauth2.client.request.RequestAuthenticator;
import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.token.OauthToken;

import javax.ws.rs.core.Response;

public class OauthClient<T extends OauthToken> {

    protected HttpMessages messages;

    protected Class<T> oauthTokenType;

    public OauthClient(Class<T> oauthTokenType, HttpMessages messages) {
        this.oauthTokenType = oauthTokenType;
        this.messages = messages;
    }

    public T requestImplicitAccess(
        AuthorizationContext authorization,
        RequestAuthenticator oauthClientAuthenticator
    ) {
        RequestParamsInserter cfg = authorization.getRequestParams();
        Response response = messages.sendAuthorizationRequest(cfg);

        T credentials = response.readEntity(oauthTokenType);
        return credentials;
    }

    public T requestAccess(AuthorizationContext authorization, RequestAuthenticator oauthClientAuthenticator) {
        RequestParamsInserter cfg = authorization.getRequestParams();
        Response response = messages.sendGrantRequest(oauthClientAuthenticator, cfg);

        T credentials = response.readEntity(oauthTokenType);
        return credentials;
    }

}
