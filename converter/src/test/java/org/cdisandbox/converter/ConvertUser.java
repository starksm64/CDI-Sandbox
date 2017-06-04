package org.cdisandbox.converter;

import javax.inject.Inject;

/**
 * Created by starksm on 6/4/17.
 */
public class ConvertUser {
    @Inject
    @Convert("defaultID")
    private String id;

    public String getId() {
        return id;
    }
}
