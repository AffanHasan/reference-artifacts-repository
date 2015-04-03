package com.rc.wefunit.producers;

import com.rc.wefunit.annotations.GenericSODependency;
import com.rc.wefunit.annotations.Produces;
import com.rc.wefunit.enums.GenericSOInjectables;

import java.lang.reflect.Method;

/**
 * Created by Affan Hasan on 4/3/15.
 */
public class FactoryProducers {

    @Produces
    @GenericSODependency(GenericSOInjectables.SERVICE_OPERATION_NAME)
    public String getGSOTServiceOperationName(){
        return "";
    }
}