package org.cdisandbox.principal;

import org.cdisandbox.principal.extension.PrincipalExtension;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.spi.Extension;
import javax.inject.Inject;
import java.security.Principal;

/**
 */
@RunWith(WeldJUnit4Runner.class)
public class PrincipalTest {

    @Inject
    Principal principal;
    @Inject
    JsonWebToken principalJWT;

    @Test
    public void shouldHave2Beans() {
        System.out.printf("principal: %s/%s\n", principal.getName(), principal.getClass());
        Assert.assertNotNull("principalJWT", principal);
        System.out.printf("principalJWT: %s/%s\n", principalJWT.getName(), principalJWT.getClass());
        Assert.assertNotNull("principalJWT", principalJWT);
    }

}
