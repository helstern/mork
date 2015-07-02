package org.helstern.mork.oauth2.client.rfc.authorization;

import org.helstern.mork.oauth2.client.ClientInfo;
import org.helstern.mork.oauth2.client.authorization.AuthorizationContext;
import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.rfc.request.params.AuthorizationCodeParams;

public class AuthorizationCodeContext implements AuthorizationContext {

    String authorizationCode;

    ClientInfo oauthClientInfo;

    public AuthorizationCodeContext(String authorizationCode, ClientInfo oauthClientInfo) {
        this.authorizationCode = authorizationCode;
        this.oauthClientInfo = oauthClientInfo;
    }


    public String getAuthorizationCode() {
        return authorizationCode;
    }

    @Override
    public String getScope() {
        return null;
    }

    @Override
    public RequestParamsInserter getRequestParams() {
        return new AuthorizationCodeParams(
            authorizationCode,
            oauthClientInfo.getRedirectUri(),
            oauthClientInfo.getClientIdentifier()
        );
    }
}
