package org.helstern;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    public void run(final morkdwConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
