package org.helstern.mork.oauth2.client;

import org.helstern.mork.oauth2.client.request.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class HttpMessages {

    protected Client client;

    protected URI authorizationUri;

    protected URI tokenUri;

    public HttpMessages(Client client, ProviderInfo providerInfo) {
        this.client = client;
        this.authorizationUri = providerInfo.getAuthorizationUri();
        this.tokenUri = providerInfo.getTokenUri();
    }

    public HttpMessages(Client client, URI authorizationUri, URI tokenUri) {
        this.client = client;
        this.authorizationUri = authorizationUri;
        this.tokenUri = tokenUri;
    }

    public String getAuthorizationUriString() {
        return authorizationUri.toASCIIString();
    }

    public String getTokenUriString() {
        return tokenUri.toASCIIString();
    }

    protected void insertQueryParameters(UriBuilder builder, List<RequestParamsInserter> configurators) {
        for (RequestParamsInserter cfg: configurators) {
            cfg.insertAllQueryParams(builder);
        }
    }

    protected void insertFormParameters(Form form, List<RequestParamsInserter> configurators) {
        for (RequestParamsInserter cfg: configurators) {
            cfg.insertAllFormParams(form);
        }
    }

    public Response sendAuthorizationRequest(RequestParamsInserter params) {
        UriBuilder uriBuilder = UriBuilder.fromUri(authorizationUri);
        params.insertAllQueryParams(uriBuilder);

        Invocation.Builder invocationBuilder = client.target(uriBuilder).request();
        Invocation invocation = invocationBuilder.buildGet();
        Response authorizationResponse = invocation.invoke();

        return authorizationResponse;
    }

    public Response sendGrantRequest(RequestAuthenticator oauthClientAuthenticator, RequestParamsInserter params) {
        ArrayList<RequestParamsInserter> cfgs = new ArrayList<>();
        cfgs.add(params);
        cfgs.add(oauthClientAuthenticator);

        UriBuilder uriBuilder = UriBuilder.fromUri(tokenUri);
        insertQueryParameters(uriBuilder, cfgs);

        Form form = new Form();
        insertFormParameters(form, cfgs);

        Invocation.Builder invocationBuilder = client.target(uriBuilder).request();
        oauthClientAuthenticator.setAuthenticatingHeaders(invocationBuilder);

        Invocation invocation = invocationBuilder.buildPost(Entity.form(form));
        Response accessResponse = invocation.invoke();

        return accessResponse;
    }
}
