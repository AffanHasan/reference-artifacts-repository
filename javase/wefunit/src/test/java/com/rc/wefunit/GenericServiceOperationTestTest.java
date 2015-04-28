package com.rc.wefunit;

import com.bowstreet.webapp.DataService;
import com.bowstreet.webapp.ServiceOperation;
import com.bowstreet.webapp.WebApp;
import com.bowstreet.webapp.WebAppAccess;
import com.rc.wefunit.annotations.GenericSODependency;
import com.rc.wefunit.annotations.Inject;
import com.rc.wefunit.annotations.ServiceConsumerFixtures;
import com.rc.wefunit.enums.GenericSOInjectables;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.models.test.services.Service1Test.GetUserInfoSOTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by Affan Hasan on 3/23/15.
 */
public class GenericServiceOperationTestTest {

    @Test
    public void is_service_operation_exists_Method_exists(){
        try {
            Method method = GenericServiceOperationTest.class.getMethod("is_service_operation_exists", null);
            Assert.assertNotNull(method);
        } catch (NoSuchMethodException e) {
            Assert.fail("Method \"is_service_operation_exists\" not found");
        }
    }

    @Test
    public void is_service_operation_exists_method_should_have_Test_annotation(){
        try {
            Method method = GenericServiceOperationTest.class.getMethod("is_service_operation_exists");
            Assert.assertTrue(method.isAnnotationPresent(com.rc.wefunit.annotations.Test.class));
        } catch (NoSuchMethodException e) {
            Assert.fail("Method \"is_service_operation_exists\" not found");
        }
    }

    @Test
    public void is_webAppAccess_field_with_GenericSODependency_annotation_present(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("webAppAccess");
            Assert.assertTrue(field.isAnnotationPresent(GenericSODependency.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void is_webAppAccess_field_with_GenericSODependency_annotation_with_value_SERVICE_CONSUMER_BUILDER_FIXTURE_MODEL_present(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("webAppAccess");
            System.out.println("---GenericSODependency Value : " + field.getAnnotation(GenericSODependency.class).value());
            Assert.assertTrue(field.getAnnotation(GenericSODependency.class).value() == GenericSOInjectables.SERVICE_CONSUMER_BUILDERS_FIXTURE_MODEL);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void is_webAppAccess_field_with_Inject_annotation_present(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("webAppAccess");
            Assert.assertTrue(field.isAnnotationPresent(Inject.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void is_webAppAccess_field_with_service_consumer_fixtures_annotation_is_protected(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("webAppAccess");
            Assert.assertTrue(Modifier.isProtected(field.getModifiers()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void is_serviceOperationName_string_field_present(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("serviceOperationName");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void is_serviceOperationName_string_field_is_protected(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("serviceOperationName");
            Assert.assertTrue(Modifier.isProtected(field.getModifiers()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void is_serviceOperationName_string_field_contains_Inject_annotation(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("serviceOperationName");
            Assert.assertTrue(field.isAnnotationPresent(Inject.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void is_dataServiceName_string_field_is_present(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("dataServiceName");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void is_dataServiceName_string_field_contains_Inject_annotation() {
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("dataServiceName");
            Assert.assertTrue(field.isAnnotationPresent(Inject.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getter_for_serviceOperationName(){
        try {
            Method method = GenericServiceOperationTest.class.getMethod("getServiceOperationName");
            Assert.assertTrue(method.getReturnType().equals(String.class));//Return string
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail("Method getServiceOperationName() not found");
        }
    }

    @Test
    public void serviceOperationName_field_is_GenericSODependency_annotation_present(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("serviceOperationName");
            Assert.assertTrue(field.isAnnotationPresent(GenericSODependency.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail("Field serviceOperationName not found");
        }
    }

    @Test
    public void serviceOperationName_field_is_GenericSODependency_annotation_with_value_SERVICE_OPERATION_NAME_present(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("serviceOperationName");
            Assert.assertTrue(field.getAnnotation(GenericSODependency.class).value() == GenericSOInjectables.SERVICE_OPERATION_NAME);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail("Field serviceOperationName not found");
        }
    }

    @Test
    public void getter_for_dataServiceName(){
        try {
            Method method = GenericServiceOperationTest.class.getMethod("getDataServiceName");
            Assert.assertTrue(method.getReturnType().equals(String.class));//Return string
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail("Method getDataServiceName() not found");
        }
    }

    @Test
    public void is_dataServiceName_field_with_DATA_SERVICE_NAME_annotation(){

        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("dataServiceName");
            Assert.assertTrue(field.isAnnotationPresent(GenericSODependency.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail("Field dataServiceName not found");
        }
    }

    @Test
    public void is_dataServiceName_field_with_DATA_SERVICE_NAME_annotation_with_value_DATA_SERVICE_NAME_present(){

        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("dataServiceName");
            Assert.assertTrue(field.getAnnotation(GenericSODependency.class).value() == GenericSOInjectables.DATA_SERVICE_NAME);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail("Field dataServiceName not found");
        }
    }

    @Test
    public void getter_for_webAppAccess(){
        try {
            Method method = GenericServiceOperationTest.class.getMethod("getWebAppAccessSCBuildersFixtureModel");
            Assert.assertTrue(method.getReturnType().equals(WebAppAccess.class));//Return WebAppAccess
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail("Method getWebAppAccessSCBuildersFixtureModel() not found");
        }
    }

    @Test
    public void is_service_operation_name_is_in_correct_format_Method_exists(){
        try {
            Method method = GenericServiceOperationTest.class.getMethod("is_service_operation_name_is_in_correct_format", null);
            Assert.assertNotNull(method);
        } catch (NoSuchMethodException e) {
            Assert.fail("Method \"is_service_operation_name_is_in_correct_format\" not found");
        }
    }

    @Test
    public void method_is_service_operation_name_is_in_correct_format_contains_Test_annotation(){
        try {
            Method method = GenericServiceOperationTest.class.getMethod("is_service_operation_name_is_in_correct_format", null);
            Assert.assertTrue(method.isAnnotationPresent(com.rc.wefunit.annotations.Test.class));
        } catch (NoSuchMethodException e) {
            Assert.fail("Method \"is_service_operation_name_is_in_correct_format\" not found");
        }
    }

    @Test(enabled = false)
    public void method_is_service_operation_name_is_in_correct_format_functional_test_1(@Mocked final Factories.RunnerFactory runnerFactory, @Injectable final Runner runner, @Mocked final GenericServiceOperationTest genericServiceOperationTest, @Injectable final WebAppAccess webAppAccess, @Injectable final WebApp webApp, @Injectable final DataService dataService, @Injectable final ServiceOperation serviceOperation){
        new Expectations(){{

            runnerFactory.getInstance();result = runner;
            runner.getWebAppAccess();result = webAppAccess;
            runner.getWebAppAccess().getModelInstance("test/SCBuildersFixture", null, true); result = webAppAccess;

            String serviceName = "SomeServiceSC";
            String serviceOperationName = "abcSO";
            genericServiceOperationTest.getWebAppAccessSCBuildersFixtureModel();result = webAppAccess;
            genericServiceOperationTest.getDataServiceName();result = serviceName;
            webAppAccess.getWebApp();result = webApp;
            webApp.getDataService(serviceName); result = dataService;
            dataService.getOperation("abcSO");result = serviceOperationName;
            serviceOperation.getName();result = serviceOperationName;
        }};
        TestClassInstantiationUtility testClassInstantiationUtility = Factories.TestClassInstantiationUtilityFactory.getInstance();
        GenericServiceOperationTest testObj = (GenericServiceOperationTest) testClassInstantiationUtility.instantiateTestClass(GetUserInfoSOTest.class);
        Assert.assertNotNull(testObj);
        try {
            testObj.is_service_operation_name_is_in_correct_format();//Test
            return;
        }catch (Throwable e){
            Assert.fail(e.getMessage());
        }
    }
}