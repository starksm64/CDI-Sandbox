package org.cdisandbox.principal.extension;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;

import org.cdisandbox.principal.DefaultWebToken;
import org.cdisandbox.principal.JsonWebToken;


@Priority(1)
@Alternative
public class PrincipalProducer {

    /**
     * The producer method for the current JsonWebToken
     *
     * @return
     */
    @Produces
    @Dependent
    JsonWebToken currentJWTPrincipalOrNull() {
        Logger log = Logger.getLogger("PrincipalProducer");
        JsonWebToken token = DefaultWebToken.getJWTPrincpal();
        if(token == null) {
            token = new DefaultWebToken("anon");
        }
        log.info("token: "+token);
        return token;
    }
}
