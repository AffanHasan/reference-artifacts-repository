package com.rc.wefunit;

import com.bowstreet.webapp.WebAppAccess;
import com.rc.wefunit.producers.FactoryProducers;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Affan Hasan on 3/31/15.
 */
public class TestClassInstantiationUtilityTest {

    private final TestClassInstantiationUtility _tciu = Factories.TestClassInstantiationUtilityFactory.getInstance();

    @Test
    public void instantiate_subclass_of_GenericServiceOperationTest_serviceOperationName_field_1(){
        try {
            final Class soOneTestClass = Class.forName("test.models.test.services.Service1Test.GetUserInfoSOTest");
            GenericServiceOperationTest soOneTestInstance = (GenericServiceOperationTest)
                    _tciu.instantiateTestClass(soOneTestClass);
            Assert.assertEquals(soOneTestInstance.getServiceOperationName(), "getUserInfoSO");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            Assert.fail("Class not found : test.models.test.services.Service1Test.GetUserInfoSOTest");
        } catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void instantiate_subclass_of_GenericServiceOperationTest_serviceOperationName_field_2(){
        try {
            final Class soOneTestClass = Class.forName("test.models.test.services.Service1Test.GetAccountsDetailSOTest");
            GenericServiceOperationTest soOneTestInstance = (GenericServiceOperationTest)
                    _tciu.instantiateTestClass(soOneTestClass);
            Assert.assertEquals(soOneTestInstance.getServiceOperationName(), "getAccountsDetailSO");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class not found : test.models.test.services.Service1Test.GetAccountsDetailSOTest");
       } catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void instantiate_subclass_of_GenericServiceOperationTest_serviceOperationName(){
        try {
            final Class soOneTestClass = Class.forName("test.models.test.services.Service1Test.GetAccountsDetailSOTest");
            GenericServiceOperationTest soOneTestInstance = (GenericServiceOperationTest)
                    _tciu.instantiateTestClass(soOneTestClass);
            Assert.assertEquals(soOneTestInstance.getServiceOperationName(), "getAccountsDetailSO");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class not found : test.models.test.services.Service1Test.GetAccountsDetailSOTest");
        } catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void instantiate_subclass_of_GenericServiceOperationTest_dataServiceName_field_injection_Test_1(){
        try {
            final Class GetAccountsDetailSOTest = Class.forName("test.models.test.services.Service1Test.GetAccountsDetailSOTest");
            GenericServiceOperationTest soOneTestInstance = (GenericServiceOperationTest)
                    _tciu.instantiateTestClass(GetAccountsDetailSOTest);
            Assert.assertEquals(soOneTestInstance.getDataServiceName(), "Service1SC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class not found : test.models.test.services.Service1Test.GetAccountsDetailSOTest");
        } catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void instantiate_subclass_of_GenericServiceOperationTest_dataServiceName_field_injection_Test_2(){
        try {
            final Class GetAccountsDetailSOTest = Class.forName("test.models.test.services.Service2Test.Service2FirstSOTest");
            GenericServiceOperationTest soOneTestInstance = (GenericServiceOperationTest)
                    _tciu.instantiateTestClass(GetAccountsDetailSOTest);
            Assert.assertEquals(soOneTestInstance.getDataServiceName(), "Service2SC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class not found : test.models.test.services.Service2Test.Service2FirstSOTest");
        } catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(enabled = true)
    public void instantiate_subclass_of_GenericServiceOperationTest_webAppAccess_field_injection(@Mocked WebAppAccess webAppAccess, @Mocked final FactoryProducers factoryProducers){
        new Expectations(){{
            factoryProducers.getSCBuildersFixturesModel(); result = new Object();
        }};
        try {
            final Class GetAccountsDetailSOTest = Class.forName("test.models.test.services.Service2Test.Service2FirstSOTest");
            GenericServiceOperationTest soOneTestInstance = (GenericServiceOperationTest)
                    _tciu.instantiateTestClass(GetAccountsDetailSOTest);
            WebAppAccess obj = soOneTestInstance.getWebAppAccessSCBuildersFixtureModel();
            Assert.assertNotNull(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class not found : test.models.test.services.Service2Test.Service2FirstSOTest");
        } catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}