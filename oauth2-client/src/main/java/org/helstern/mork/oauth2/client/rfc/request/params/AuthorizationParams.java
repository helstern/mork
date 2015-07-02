package org.helstern.mork.oauth2.client.rfc.request.params;

import org.helstern.mork.oauth2.client.request.RequestParamsInserter;
import org.helstern.mork.oauth2.client.rfc.Enums;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.UriBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthorizationParams implements RequestParamsInserter {

    protected URI redirectionUri;

    protected String clientIdentifier;

    protected String scope;

    Enums.ResponseTypes responseType = Enums.ResponseTypes.CODE;

    public AuthorizationParams(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    public AuthorizationParams(String clientIdentifier, URI redirectionUri) {
        this.clientIdentifier = clientIdentifier;
        this.redirectionUri = redirectionUri;
    }

    public AuthorizationParams(String clientIdentifier, URI redirectionUri, String scope) {
        this.clientIdentifier = clientIdentifier;
        this.redirectionUri = redirectionUri;
        this.scope = scope;
    }

    URI getRedirectionUri() {
        return redirectionUri;
    }


    public String getResponseType() {
        return responseType.getName();
    }

    public String getScope() {
        return scope;
    }

    String getClientIdentifier() {
        return clientIdentifier;
    }

    @Override
    public boolean insertAllQueryParams(UriBuilder uriBuilder) {
        Map<String, String> queryParams = collectAllQueryParameters();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            uriBuilder.replaceQueryParam(entry.getKey(), entry.getValue());
        }

        return true;
    }

    protected Map<String, String> collectAllQueryParameters() {
        LinkedHashMap<String, String> params = new LinkedHashMap<>();

        String responseType = getResponseType();
        params.put(Enums.Params.RESPONSE_TYPE.getName(), responseType);

        String clientIdentifier = getClientIdentifier();
        params.put(Enums.Params.CLIENT_ID.getName(), clientIdentifier);

        String scope = getScope();
        if (scope != null) {
            params.put(Enums.Params.SCOPE.getName(), scope);
        }

        String redirectionUri = getRedirectionUri().toString();
        if (redirectionUri != null) {
            try {
                params.put(Enums.Params.REDIRECT_URI.getName(), URLEncoder.encode(redirectionUri, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return params;
    }

    @Override
    public boolean insertAllFormParams(Form form) {
        return true;
    }
}
