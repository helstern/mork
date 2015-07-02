package org.helstern.mork.dw;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.helstern.mork.dw.client.MendeleyApiConfiguration;

import javax.validation.constraints.*;

public class morkdwConfiguration extends Configuration {

    @NotNull
    protected MendeleyApiConfiguration mendeleyApiConfiguration;

    @JsonProperty(value = "mendeleyApi")
    public void setMendeleyApiConfiguration(MendeleyApiConfiguration configuration)
    {
        mendeleyApiConfiguration = configuration;
    }

    @JsonProperty(value = "mendeleyApi")
    public MendeleyApiConfiguration getMendeleyApiConfiguration()
    {
        return mendeleyApiConfiguration;
    }
}
