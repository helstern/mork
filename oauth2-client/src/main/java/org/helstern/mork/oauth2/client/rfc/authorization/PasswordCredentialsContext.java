package org.helstern.mork.oauth2.client.rfc.authorization;

import org.helstern.mork.oauth2.client.authorization.AuthorizationContext;
import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.rfc.request.params.PasswordCredentialsParams;

public class PasswordCredentialsContext implements AuthorizationContext {

    String username;

    String password;

    String scope;

    public PasswordCredentialsContext(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PasswordCredentialsContext(String username, String password, String scope) {
        this.username = username;
        this.password = password;
        this.scope = scope;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public RequestParamsInserter getRequestParams() {
        return new PasswordCredentialsParams(username, password);
    }
}
