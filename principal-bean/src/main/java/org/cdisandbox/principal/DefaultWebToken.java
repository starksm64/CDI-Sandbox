package org.cdisandbox.principal;

import javax.enterprise.inject.Vetoed;

public class DefaultWebToken implements JsonWebToken {
    private static ThreadLocal<JsonWebToken> currentPrincipal = new ThreadLocal<>();

    public static JsonWebToken getJWTPrincpal() {
        return currentPrincipal.get();
    }

    private String name;

    public DefaultWebToken() {
        this.name = "custom-principal#" + super.toString();
        currentPrincipal.set(this);
    }

    @Override
    public String getToken() {
        return "x.y.z";
    }

    @Override
    public String getName() {
        return name;
    }
}
