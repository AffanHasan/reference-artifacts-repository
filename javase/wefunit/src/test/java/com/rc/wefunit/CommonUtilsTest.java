package com.rc.wefunit;

import com.rc.wefunit.annotations.GenericSODependency;
import com.rc.wefunit.annotations.Qualifier;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Affan Hasan on 4/16/15.
 */
public class CommonUtilsTest {

    @Test
    public void filterQualifierAnnotations(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.CommonUtils");
            Method m = classObj.getMethod("filterQualifierAnnotations", Annotation[].class);
            Assert.assertNotNull(m);
            Assert.assertTrue(m.getReturnType().equals(Annotation[].class));
            Assert.assertTrue(m.getParameterCount() == 1);
            Assert.assertTrue(m.getParameters()[0].getType().equals(Annotation[].class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void filterQualifierAnnotations_functional_test(){
        class AbcSOTest extends GenericServiceOperationTest{

        }
        AbcSOTest abcSOTest = new AbcSOTest();
        try {
            Field soNameField = abcSOTest.getClass().getSuperclass().getDeclaredField("serviceOperationName");
            CommonUtils cu = new CommonUtils();
            Annotation[] arr = cu.filterQualifierAnnotations(soNameField.getAnnotations());
            Assert.assertTrue(arr.length == 1);
            Assert.assertTrue(arr[0].annotationType().equals(GenericSODependency.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}