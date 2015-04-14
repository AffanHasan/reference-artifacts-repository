package com.rc.wefunit.producers;

import com.bowstreet.webapp.WebAppAccess;
import com.rc.wefunit.annotations.GenericSODependency;
import com.rc.wefunit.annotations.Produces;
import com.rc.wefunit.enums.GenericSOInjectables;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Affan Hasan on 4/3/15.
 */
public class FactoryProducers {

    @Produces
    @GenericSODependency(GenericSOInjectables.SERVICE_CONSUMER_BUILDERS_FIXTURE_MODEL)
    public WebAppAccess getSCBuildersFixturesModel(WebAppAccess webAppAccess){
        return webAppAccess.getModelInstance("test/SCBuildersFixture", null, true);
    }
}