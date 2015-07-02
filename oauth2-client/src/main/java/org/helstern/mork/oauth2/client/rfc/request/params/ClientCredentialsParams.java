package org.helstern.mork.oauth2.client.rfc.request.params;

import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.rfc.Enums;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.UriBuilder;

public class ClientCredentialsParams implements RequestParamsInserter {

    String scope;

    Enums.GrantTypes grantType = Enums.GrantTypes.CLIENT_CREDENTIALS;

    public ClientCredentialsParams(String scope) {
        this.scope = scope;
    }

    public ClientCredentialsParams() {
        this.scope = null;
    }

    public String getGrantType()
    {
        return grantType.getName();
    }


    public String getScope() {
        return scope;
    }


    @Override
    public boolean insertAllQueryParams(UriBuilder uriBuilder) {
        return true;
    }


    @Override
    public boolean insertAllFormParams(Form form) {
        String grantType = getGrantType();
        form.param(Enums.Params.GRANT_TYPE.getName(), grantType);

        String scope = getScope();
        if (scope != null) {
            form.param(Enums.Params.SCOPE.getName(), scope);
        }

        return true;
    }
}
