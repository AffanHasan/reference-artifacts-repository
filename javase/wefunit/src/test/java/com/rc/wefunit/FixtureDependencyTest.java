package com.rc.wefunit;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Affan Hasan on 4/7/15.
 */
public class FixtureDependencyTest {

    private final String _dependencySignatureFieldName = "_dependencySignature";

    private final String _producerMethodFieldName = "_producerMethod";

    private final Class getClassObject(){
        try{
            return Class.forName("com.rc.wefunit.FixtureDependency");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail("Class com.rc.wefunit.FixtureDependency do not exists");
        }
        return null;
    }

    private final Field getFieldObject(String fieldName){
        try{
            return  getClassObject().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail("Field \""+ fieldName +"\" do not exists");
        }
        return null;
    }

    @Test
    public void existence_of_class(){
        Assert.assertNotNull(getClassObject());
    }

    @Test
    public void dependencySignature_field(){
        Assert.assertNotNull(getFieldObject(_dependencySignatureFieldName));
    }

    @Test
    public void dependencySignature_field_is_private(){
        Assert.assertTrue(Modifier.isPrivate(getFieldObject(_dependencySignatureFieldName).getModifiers()));
    }

    @Test
    public void dependencySignature_field_is_private_final(){
        Assert.assertTrue(Modifier.isFinal(getFieldObject(_dependencySignatureFieldName).getModifiers()));
    }

    @Test
    public void dependencySignature_field_is_private_is_of_type_DependencySignature(){
        Assert.assertEquals(getFieldObject(_dependencySignatureFieldName).getType(), DependencySignature.class);
    }

    @Test
    public void producerMethod_field(){
        Assert.assertNotNull(getFieldObject(_producerMethodFieldName));
    }

    @Test
    public void producerMethod_field_is_private(){
        Assert.assertTrue(Modifier.isPrivate(getFieldObject(_producerMethodFieldName).getModifiers()));
    }

    @Test
    public void producerMethod_field_is_private_final(){
        Assert.assertTrue(Modifier.isFinal(getFieldObject(_producerMethodFieldName).getModifiers()));
    }

    @Test
    public void producerMethod_field_is_private_is_of_type_Method(){
        Assert.assertEquals(getFieldObject(_producerMethodFieldName).getType(), Method.class);
    }

    @Test
    public void constructorTest(){
        Assert.fail("Not implemented");
    }
}