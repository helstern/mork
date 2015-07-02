package org.helstern.mork.oauth2.client.token;


import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;


public class JsonOauthTokenResponseReader implements MessageBodyReader<DefaultOauthToken> {

    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return DefaultOauthToken.class.isAssignableFrom(type) && mediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE);
    }

    @Override
    public DefaultOauthToken readFrom(Class<DefaultOauthToken> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {

        DefaultOauthToken.Builder tokenBuilder = DefaultOauthToken.builder();

        JsonParser parser = Json.createParser(entityStream);
        String jsonStringValue;
        String key;
        while (parser.hasNext()) {
            if (! JsonParser.Event.KEY_NAME.equals(parser.next())) {
                continue;
            }

            key = parser.getString();
            parser.next();
            switch (key) {
                case "access_token":
                    jsonStringValue = parser.getString();
                    tokenBuilder.setAccesToken(jsonStringValue);
                    break;
                case "refresh_token":
                    jsonStringValue = parser.getString();
                    tokenBuilder.setRefreshToken(jsonStringValue);
                    break;
                case "expires_in":
                    tokenBuilder.setExpiresIn(parser.getLong());
                    break;
                case "scope":
                    jsonStringValue = parser.getString();
                    tokenBuilder.setScope(jsonStringValue);
                    break;
            }
        }

        DefaultOauthToken token = tokenBuilder.build();
        return token;
    }
}
