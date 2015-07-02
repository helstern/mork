package org.helstern.mork.oauth2.client.request;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.UriBuilder;

public interface RequestParamsInserter {

    public boolean insertAllQueryParams(UriBuilder uriBuilder);

    public boolean insertAllFormParams(Form form);

}
