package org.helstern.mork.oauth2.client.request;

import javax.ws.rs.client.Invocation;

public interface RequestAuthenticator extends RequestParamsInserter {

    public boolean setAuthenticatingHeaders(Invocation.Builder invocationBuilder);
}
