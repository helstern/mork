package org.helstern.mork.oauth2.client.rfc.request.params;

import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.rfc.Enums;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class AuthorizationCodeParams implements RequestParamsInserter {

    protected String authorizationCode;

    protected URI redirectionUri;

    protected String clientIdentifier;

    public AuthorizationCodeParams(String authorizationCode, URI redirectionUri, String clientIdentifier) {
        this.authorizationCode = authorizationCode;
        this.redirectionUri = redirectionUri;
        this.clientIdentifier = clientIdentifier;
    }


    public String getGrantType() {
        return Enums.GrantTypes.AUTHORIZATION_CODE.getName();
    }

    String getAuthorizationCode() {
        return authorizationCode;
    }

    URI getRedirectionUri() {
        return redirectionUri;
    }

    String getClientIdentifier() {
        return clientIdentifier;
    }

    @Override
    public boolean insertAllQueryParams(UriBuilder uriBuilder) {
        return true;
    }

    @Override
    public boolean insertAllFormParams(Form form) {
        String grantType = getGrantType();
        form.param(Enums.Params.GRANT_TYPE.getName(), grantType);

        String code = getAuthorizationCode();
        form.param(Enums.Params.CODE.getName(), code);

        URI redirectUri = getRedirectionUri();
        form.param(Enums.Params.REDIRECT_URI.getName(), redirectUri.toString());

        return true;
    }
}
