package org.helstern.mork.oauth2.client.authorization;

import org.helstern.mork.oauth2.client.request.RequestParamsInserter;

public interface AuthorizationContext {

    String getScope();

    RequestParamsInserter getRequestParams();
}
