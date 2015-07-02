package org.helstern.mork.dw.resources;

import org.glassfish.jersey.filter.LoggingFilter;
import org.helstern.mork.dw.client.JacksonOauthToken;
import org.helstern.mork.dw.client.MendeleyApiConfiguration;
import org.helstern.mork.oauth2.client.HttpMessages;
import org.helstern.mork.oauth2.client.OauthClient;
import org.helstern.mork.oauth2.client.request.BasicAccessAuthenticator;
import org.helstern.mork.oauth2.client.rfc.authorization.ClientCredentialsContext;
import org.helstern.mork.oauth2.client.token.OauthToken;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.*;

@Path("/mendeley-oauth")
public class MendeleyOauthResource {

    private Client client;

    private MendeleyApiConfiguration apiConfiguration;

    public MendeleyOauthResource(Client client, MendeleyApiConfiguration apiConfiguration) {
        this.client = client;
        this.apiConfiguration = apiConfiguration;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String clientId() {

        client.register(LoggingFilter.class);
        HttpMessages messages = new HttpMessages(client, apiConfiguration);
        OauthClient oauthClient = new OauthClient<>(JacksonOauthToken.class, messages);

        ClientCredentialsContext authzCtx = new ClientCredentialsContext("all");
        BasicAccessAuthenticator clientAuthenticator = new BasicAccessAuthenticator(apiConfiguration);

        OauthToken token = oauthClient.requestAccess(authzCtx, clientAuthenticator);
        return token.getAccessToken();
    }

}
