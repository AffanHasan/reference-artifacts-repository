package com.rc.wefunit;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Affan Hasan on 3/31/15.
 */
public class TestClassInstantiationUtilityTest {

    private final TestClassInstantiationUtility _tciu = Factories.TestClassInstantiationUtilityFactory.getInstance();

    @Test
    public void instantiate_subclass_of_GenericServiceOperationTest_serviceOperationName_1(){
        try {
            final Class soOneTestClass = Class.forName("test.models.test.services.Service1.SOOneTest");
            GenericServiceOperationTest soOneTestInstance = (GenericServiceOperationTest)
                    _tciu.instantiateTestClass(soOneTestClass);

            Assert.assertEquals(soOneTestInstance.getServiceOperationName(), "sOOne");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class not found : test.models.test.services.Service1.SOOneTest");
        } catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}