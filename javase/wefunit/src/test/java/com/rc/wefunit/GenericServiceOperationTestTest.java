package com.rc.wefunit;

import com.rc.wefunit.annotations.Inject;
import com.rc.wefunit.annotations.ServiceConsumerFixtures;
import mockit.Expectations;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void is_service_operation_exists(){
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
    public void is_webAppAccess_field_with_service_consumer_fixtures_annotation_available(){
        try {
            Field field = GenericServiceOperationTest.class.getDeclaredField("webAppAccess");
            Assert.assertTrue(field.isAnnotationPresent(Inject.class));
            Assert.assertTrue(field.isAnnotationPresent(ServiceConsumerFixtures.class));
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

    @Test(enabled = false)
    public void is_so_name_is_according_to_convention(){
    }
}