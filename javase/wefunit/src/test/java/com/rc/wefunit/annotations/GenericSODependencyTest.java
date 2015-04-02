package com.rc.wefunit.annotations;

import com.rc.wefunit.enums.GenericSOInjectables;
import org.testng.Assert;
import java.lang.reflect.Method;

/**
 * Created by Affan Hasan on 4/2/15.
 */
public class GenericSODependencyTest {

    @org.testng.annotations.Test
    public void is_annotation_GenericSODependency(){
        try {
            Class genericSODependency = Class.forName("com.rc.wefunit.annotations.GenericSODependency");
            Assert.assertTrue(genericSODependency.isAnnotation());
        } catch (ClassNotFoundException e) {

        }
    }

    @org.testng.annotations.Test
    public void is_a_Qualifier(){
        try {
            Class genericSODependency = Class.forName("com.rc.wefunit.annotations.GenericSODependency");
            Assert.assertTrue(genericSODependency.isAnnotationPresent(Qualifier.class));
        } catch (ClassNotFoundException e) {
        }
    }

    @org.testng.annotations.Test
    public void is_value_method_present(){
        try {
            Class genericSODependency = Class.forName("com.rc.wefunit.annotations.GenericSODependency");
            Method methodValue = genericSODependency.getMethod("value");
            Assert.assertTrue(methodValue.getReturnType().equals(GenericSOInjectables.class));
        } catch (ClassNotFoundException e) {

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}