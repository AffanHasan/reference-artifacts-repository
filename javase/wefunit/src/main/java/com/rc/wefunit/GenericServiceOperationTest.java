package com.rc.wefunit;

import com.bowstreet.builders.webapp.ServiceConsumerBuilder;
import com.bowstreet.builders.webapp.api.ServiceConsumer2;
import com.bowstreet.webapp.WebAppAccess;
import com.rc.wefunit.annotations.Inject;
import com.rc.wefunit.annotations.Test;

/**
 * Created by Affan Hasan on 3/23/15.
 *
 *
 */
public abstract class GenericServiceOperationTest {

    @Inject
    protected WebAppAccess webAppAccess;

    @Inject
    protected String serviceOperationName;

    @Test
    public void is_service_operation_exists(){
//        webAppAccess.getmo
    }
}