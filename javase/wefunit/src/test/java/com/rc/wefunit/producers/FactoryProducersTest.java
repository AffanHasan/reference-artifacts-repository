package com.rc.wefunit.producers;

import com.rc.wefunit.annotations.GenericSODependency;
import com.rc.wefunit.annotations.Produces;
import com.rc.wefunit.enums.GenericSOInjectables;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by Affan Hasan on 4/3/15.
 */
public class FactoryProducersTest {

    private final FactoryProducers _fp = new FactoryProducers();

    private Class _fpClass;

    public FactoryProducersTest(){
        try {
            _fpClass = Class.forName("com.rc.wefunit.producers.FactoryProducers");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGSOTServiceOperationName(){
        try {
            Method method = _fpClass.getMethod("getGSOTServiceOperationName");
            Assert.assertTrue(method.getReturnType().equals(String.class));
            Assert.assertTrue(method.isAnnotationPresent(Produces.class));
            Assert.assertTrue(method.isAnnotationPresent(GenericSODependency.class));
            Assert.assertTrue(method.getAnnotation(GenericSODependency.class).value() == GenericSOInjectables.SERVICE_OPERATION_NAME);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}