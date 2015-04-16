package com.rc.wefunit;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Affan Hasan on 4/3/15.
 */
public class FixtureDependencyInjectorUtilityTest {

    private final FixtureDependencyInjectorUtility _fdiu = Factories.FixtureDependencyInjectorUtilityFactory.getInstance();

    @Test
    public void must_throw_IllegalStateException_when_a_non_injectable_field_is_provided_to_inject_method(){
        class ATest extends GenericServiceOperationTest{

            public String name = "Hello";//Non Injectable Field

        }

        ATest aTest = new ATest();
        try {
            Field field = aTest.getClass().getDeclaredField("name");
            _fdiu.inject(field, aTest);
            Assert.fail();
        } catch (NoSuchFieldException e) {
            Assert.fail();
        } catch (IllegalStateException e){
            Assert.assertEquals(e.getMessage(), "Provided field is not Injectable");
            return;
        }
        Assert.fail();
    }

    @Test
    public void inject_method_with_2_parameters_Field_and_Object1_GenericServiceOperationTest_serviceOperationName_field_1(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.FixtureDependencyInjectorUtility");
            Method injectMethod = classObj.getMethod("inject", Field.class, Object.class);
            Assert.assertTrue(injectMethod.getParameterCount() == 2);
            Assert.assertTrue(injectMethod.getReturnType().toString().equals("void"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class \"com.rc.wefunit.FixtureDependencyInjectorUtility\" do not exists");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void inject_method_with_2_parameters_Field_and_Object2_GenericServiceOperationTest_serviceOperationName_field_2(){
        try {
            final Class getAccountsDetailSOTest =
                    Class.forName("test.models.test.services.Service1Test.GetAccountsDetailSOTest");//SubCLass Of GenericServiceOperationTest
            GenericServiceOperationTest instance = (GenericServiceOperationTest) getAccountsDetailSOTest.newInstance();
            Field soName = getAccountsDetailSOTest.getSuperclass().getDeclaredField("serviceOperationName");
            _fdiu.inject(soName, instance);
            Assert.assertEquals(instance.getServiceOperationName(), "getAccountsDetailSO");//Verifying the value
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class \"com.rc.wefunit.FixtureDependencyInjectorUtility\" do not exists");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (InstantiationException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void inject_method_with_2_parameters_Field_and_Object__GenericServiceOperationTest_dataServiceName_field_injection_Test_1(){
        try {
            final Class getAccountsDetailSOTest =
                    Class.forName("test.models.test.services.Service1Test.GetAccountsDetailSOTest");//SubCLass Of GenericServiceOperationTest
            GenericServiceOperationTest instance = (GenericServiceOperationTest) getAccountsDetailSOTest.newInstance();
            Field dataServiceName = getAccountsDetailSOTest.getSuperclass().getDeclaredField("dataServiceName");
            _fdiu.inject(dataServiceName, instance);
            Assert.assertEquals(instance.getDataServiceName(), "Service1SC");//Verifying the value
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class \"com.rc.wefunit.FixtureDependencyInjectorUtility\" do not exists");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (InstantiationException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void inject_method_with_2_parameters_Field_and_Object__GenericServiceOperationTest_dataServiceName_field_injection_Test_2(){
        try {
            final Class service2FirstSOTest =
                    Class.forName("test.models.test.services.Service2Test.Service2FirstSOTest");//SubCLass Of GenericServiceOperationTest
            GenericServiceOperationTest instance = (GenericServiceOperationTest) service2FirstSOTest.newInstance();
            Field dataServiceName = service2FirstSOTest.getSuperclass().getDeclaredField("dataServiceName");
            _fdiu.inject(dataServiceName, instance);
            Assert.assertEquals(instance.getDataServiceName(), "Service2SC");//Verifying the value
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class \"com.rc.wefunit.FixtureDependencyInjectorUtility\" do not exists");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (InstantiationException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(enabled = false)
    public void inject_method_with_2_parameters_Field_and_Object__GenericServiceOperationTest_webAppAccessSC_field_injection_Test_1(){
        try {
            final Class service2FirstSOTest =
                    Class.forName("test.models.test.services.Service2Test.Service2FirstSOTest");//SubCLass Of GenericServiceOperationTest
            GenericServiceOperationTest instance = (GenericServiceOperationTest) service2FirstSOTest.newInstance();
            Field webAppAccess = service2FirstSOTest.getSuperclass().getDeclaredField("webAppAccess");
            _fdiu.inject(webAppAccess, instance);
            Assert.assertNotNull(instance.getWebAppAccessSCBuildersFixtureModel());//Verifying the value
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class \"com.rc.wefunit.FixtureDependencyInjectorUtility\" do not exists");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (InstantiationException e) {
            e.printStackTrace();
            Assert.fail();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}