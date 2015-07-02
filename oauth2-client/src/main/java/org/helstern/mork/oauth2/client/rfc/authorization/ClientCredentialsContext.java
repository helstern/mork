package org.helstern.mork.oauth2.client.rfc.authorization;

import org.helstern.mork.oauth2.client.authorization.AuthorizationContext;
import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.rfc.request.params.ClientCredentialsParams;

public class ClientCredentialsContext implements AuthorizationContext {

    String username;

    String password;

    String scope;

    public ClientCredentialsContext() {}

    public ClientCredentialsContext(String scope) {
        this.scope = scope;
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public RequestParamsInserter getRequestParams() {
        return new ClientCredentialsParams();
    }
}
