package com.rc.wefunit;

import mockit.Expectations;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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
}