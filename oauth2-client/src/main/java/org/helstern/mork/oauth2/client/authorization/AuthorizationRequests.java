package org.helstern.mork.oauth2.client.authorization;

import org.helstern.mork.oauth2.client.request.RequestParamsInserter;

public interface AuthorizationRequests {

    public String getScope();

    public RequestParamsInserter authorizationParams();

    public RequestParamsInserter implicitAuthorizationParams();
}
