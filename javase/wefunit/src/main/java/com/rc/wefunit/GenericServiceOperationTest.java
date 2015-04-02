package com.rc.wefunit;

import com.bowstreet.webapp.WebAppAccess;
import com.rc.wefunit.annotations.*;
import com.rc.wefunit.enums.GenericSOInjectables;

/**
 * Created by Affan Hasan on 3/23/15.
 */
public abstract class GenericServiceOperationTest {

    @Inject
    @GenericSODependency(GenericSOInjectables.SERVICE_CONSUMER_BUILDERS_FIXTURE_MODEL)
    protected WebAppAccess webAppAccess;

    @Inject
    @GenericSODependency(GenericSOInjectables.SERVICE_OPERATION_NAME)
    protected String serviceOperationName;

    @Inject
    @GenericSODependency(GenericSOInjectables.DATA_SERVICE_NAME)
    protected String dataServiceName;

    public String getServiceOperationName(){
        return this.serviceOperationName;
    }

    public String getDataServiceName(){
        return this.dataServiceName;
    }

    public WebAppAccess getWebAppAccessSC(){
        return this.webAppAccess;
    }

    @BeforeClass
    public void is_service_operation_name_is_in_correct_format(){

    }

    @Test
    public void is_service_operation_exists(){
//        webAppAccess.getWebApp().getDataService("Service1Test").getOperation("SOOneTest");
    }
}