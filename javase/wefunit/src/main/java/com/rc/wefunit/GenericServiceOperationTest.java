package com.rc.wefunit;

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
//        webAppAccess.getWebApp().getDataService("Service1").getOperation("SOOneTest");
    }
}