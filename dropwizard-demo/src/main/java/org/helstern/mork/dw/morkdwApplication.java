package org.helstern.mork.dw;

import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.client.ClientConfig;
import org.helstern.mork.dw.client.MendeleyApiConfiguration;
import org.helstern.mork.dw.resources.MendeleyOauthResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class morkdwApplication extends Application<morkdwConfiguration> {

    public static void main(final String[] args) throws Exception {
        new morkdwApplication().run(args);
    }

    @Override
    public String getName() {
        return "morkdw";
    }

    @Override
    public void initialize(final Bootstrap<morkdwConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final morkdwConfiguration configuration, final Environment environment) {
        JerseyEnvironment jerseyEnv = environment.jersey();
        registerJerseyResources(configuration, jerseyEnv);
    }

    protected void registerJerseyResources(final morkdwConfiguration configuration, JerseyEnvironment environment) {

        MendeleyApiConfiguration mendeleyApiConfig = configuration.getMendeleyApiConfiguration();

        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);

        final MendeleyOauthResource resource = new MendeleyOauthResource(client, mendeleyApiConfig);
        environment.register(resource);
    }

}
