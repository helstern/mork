package org.helstern.mork.oauth2.client.rfc;

public class Enums {

    public enum ResponseTypes {
        CODE("code"),
        TOKEN("token")
        ;

        private final String name;

        ResponseTypes(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum GrantTypes {
        AUTHORIZATION_CODE("authorization_code"),
        CLIENT_CREDENTIALS("client_credentials"),
        PASSWORD_CREDENTIALS("password")
        ;

        private final String name;

        GrantTypes(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum Params {
        CLIENT_ID("response_type"),
        CODE("code"),
        GRANT_TYPE("grant_type"),
        PASSWORD("password"),
        REDIRECT_URI("redirect_uri"),
        RESPONSE_TYPE("response_type"),
        SCOPE("scope"),
        STATE("state"),
        USERNAME("username")
        ;

        private final String name;

        Params(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
