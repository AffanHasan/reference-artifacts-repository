package com.rc.wefunit.probes;

import com.google.gson.JsonObject;
import com.rc.wefunit.CommonUtils;
import com.rc.wefunit.Factories;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.Observable;
import java.util.Set;

/**
 * Created by Affan Hasan on 3/23/15.
 */
public class AssertTest {

    private Class getClassObject(){
        try {
            return Class.forName("com.rc.wefunit.probes.Assert");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            return null;
        }
    }

    @Test
    public void class_Assert_existence(){
        Assert.assertNotNull(getClassObject());
    }

    @Test(enabled = false)
    public void class_Assert_is_Observable(){
        Set<Class> set = new LinkedHashSet<Class>();
        Factories.CommonUtilsFactory.getInstance().getSuperClassesHierarchy(getClassObject(), set);
        Assert.assertTrue(set.contains(Observable.class));
    }

    @Test
    public void method_assertTrue_is_public_static_with_only_one_argument_Object(){
        Class classObject = getClassObject();
        try {
            Method m = classObject.getMethod("assertTrue", Boolean.class);
            Assert.assertTrue(Modifier.isStatic(m.getModifiers()));//Method is static
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void method_assertTrue_throw_java_lang_AssertionError_when_argument_is_false(){
        try{
            com.rc.wefunit.probes.Assert.assertTrue(false);
        }catch(AssertionError e){
            Assert.assertEquals(e.getMessage() , "Expected [ true ] but found [ false ]");
            return;
        }
        Assert.fail("No assertion error");
    }

    @Test
    public void method_assertTrue_no_Throwable_when_argument_is_true(){
        try{
            com.rc.wefunit.probes.Assert.assertTrue(true);
        }catch(Throwable e){
            Assert.fail("No Throwable is expected here");
        }
    }

    @Test(enabled = false)
    public void private_final_static_field__testScores(){
        try {
            Field testScores = getClassObject().getDeclaredField("_testScores");
            Assert.assertNotNull(testScores);
            Assert.assertTrue(Modifier.isFinal(testScores.getModifiers()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test(enabled = false)
    public void _private_field__testScores_is_of_type_JsonObject(){
        try {
            Field testScores = getClassObject().getDeclaredField("_testScores");
            Assert.assertEquals(testScores.getType(), JsonObject.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}