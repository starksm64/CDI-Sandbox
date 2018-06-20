package org.cdisandbox.principal.extension;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

/**
 */
public class PrincipalExtension implements Extension {

    public void observeBeforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd, BeanManager beanManager) {
        Logger log = Logger.getLogger("PrincipalExtension");
        bbd.addAnnotatedType(beanManager.createAnnotatedType(PrincipalProducer.class));
        log.info("Added PrincipalProducer");
    }

}
