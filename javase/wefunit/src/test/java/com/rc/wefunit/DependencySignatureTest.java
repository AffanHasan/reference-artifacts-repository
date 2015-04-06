package com.rc.wefunit;

import com.rc.wefunit.annotations.GenericSODependency;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Enumeration;

/**
 * Created by Affan Hasan on 4/6/15.
 */
public class DependencySignatureTest {

    @Test
    public void class_existence(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Assert.assertNotNull(classObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_returnedObjectType(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_returnedObjectType");
            Assert.assertNotNull(field);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_returnedObjectType_field_type_is_java_lang_Class(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_returnedObjectType");
            Assert.assertEquals(field.getType(), Class.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_returnedObjectType_is_private(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_returnedObjectType");
            Assert.assertTrue(Modifier.isPrivate(field.getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_returnedObjectType_is_final(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_returnedObjectType");
            Assert.assertTrue(Modifier.isFinal(field.getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_qualifiers(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_qualifiers");
            Assert.assertNotNull(field);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_qualifiers_is_an_Array_of_Type_Annotation(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_qualifiers");
            Assert.assertTrue(field.getType().isArray());
            Assert.assertEquals(field.getType().getComponentType(), Annotation.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field__qualifiers_is_private(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_qualifiers");
            Assert.assertTrue(Modifier.isPrivate(field.getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field__qualifiers_is_final(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_qualifiers");
            Assert.assertTrue(Modifier.isFinal(field.getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void field_method_existence(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_method");
            Assert.assertNotNull(field);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_method_is_private(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_method");
            Assert.assertTrue(Modifier.isPrivate(field.getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void field_method_is_final(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Field field = classObj.getDeclaredField("_method");
            Assert.assertTrue(Modifier.isFinal(field.getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void there_is_only_one_constructor(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Assert.assertTrue(classObj.getConstructors().length == 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void the_only_constructor_is_public(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Assert.assertTrue(Modifier.isPublic(classObj.getConstructors()[0].getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void constructor_must_have_Method_as_the_first_parameter_data_type(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Constructor constructor = classObj.getConstructors()[0];
            Assert.assertEquals(constructor.getParameterTypes()[0], Method.class);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void constructor_must_have_Class_as_the_second_parameter_data_type(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Constructor constructor = classObj.getConstructors()[0];
            Assert.assertEquals(constructor.getParameterTypes()[1], Class.class);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void constructor_must_have_an_Annotation_array_as_the_third_parameter_data_type(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Constructor constructor = classObj.getConstructors()[0];
            Assert.assertTrue(constructor.getParameterTypes()[2].isArray());
            Assert.assertEquals(constructor.getParameterTypes()[2].getComponentType(), Annotation.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    private @interface NonQualifierAnnotation {
    }

    @Test
    public void throw_IllegalStateException_when_provided_annotation_is_not_a_Qualifier(){

        class ABC extends GenericServiceOperationTest{

            @NonQualifierAnnotation
            public String aField;
        }
        ABC abc = new ABC();
        Class abcClass = abc.getClass();
        try {
            Field field = abcClass.getField("aField");
            DependencySignature ds = new DependencySignature(null, String.class,
                    field.getAnnotation(NonQualifierAnnotation.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch(IllegalStateException e){
            Assert.assertEquals(e.getMessage(), "Provided annotation at index \"0\" is not a \"com.rc.wefunit.annotations.Qualifier\" annotation");
            return;
        }
        Assert.fail();
    }

    @Test
    public void presence_of_equals_and_hashcode_methods(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencySignature");
            Method hashCodeM = classObj.getMethod("hashCode");
            Assert.assertNotNull(hashCodeM);
            Method equalsM = classObj.getMethod("equals", Object.class);
            Assert.assertNotNull(equalsM);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}