package org.helstern.mork.oauth2.client.rfc.request.params;

import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.rfc.Enums;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.UriBuilder;

public class PasswordCredentialsParams implements RequestParamsInserter {

    String username;

    String password;

    String scope;

    Enums.GrantTypes grantType = Enums.GrantTypes.PASSWORD_CREDENTIALS;

    public PasswordCredentialsParams(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PasswordCredentialsParams(String username, String password, String scope) {
        this.username = username;
        this.password = password;
        this.scope = scope;
    }

    public String getGrantType() {
        return grantType.getName();
    }

    public String getScope() {
        return scope;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    @Override
    public boolean insertAllFormParams(Form form) {
        String grantType = getGrantType();
        form.param(Enums.Params.GRANT_TYPE.getName(), grantType);

        String username = getUsername();
        form.param(Enums.Params.USERNAME.getName(), username);

        String password = getPassword();
        form.param(Enums.Params.PASSWORD.getName(), password);

        String scope = getScope();
        if (scope != null) {
            form.param(Enums.Params.SCOPE.getName(), scope);
        }

        return true;
    }

    @Override
    public boolean insertAllQueryParams(UriBuilder uriBuilder) {
        return true;
    }

//    @Override
//    public Map<String, String> getHeaders() {
//        Map<String, String> m = Collections.emptyMap();
//        return m;
//    }
//
//    @Override
//    public boolean setAuthenticatingHeaders(Invocation.Builder invocationBuilder) {
//        return true;
//    }

}
