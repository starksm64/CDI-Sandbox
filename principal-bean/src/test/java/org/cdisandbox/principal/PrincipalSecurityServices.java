package org.cdisandbox.principal;

import java.security.Principal;

import org.jboss.weld.security.spi.SecurityServices;

public class PrincipalSecurityServices implements SecurityServices {
    @Override
    public Principal getPrincipal() {
        return DefaultWebToken.getJWTPrincpal();
    }

    @Override
    public void cleanup() {

    }
}
