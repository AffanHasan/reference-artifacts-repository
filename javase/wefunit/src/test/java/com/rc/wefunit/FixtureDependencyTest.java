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
    private final String _getSignatureMethodName = "getSignature";
    private final String _getDependencyMethodName = "getDependency";
    private final String _containingObjFieldName = "containingObj";

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

    private final Method getMethodObject(String methodName){
        try{
            return  getClassObject().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail("Field \""+ methodName +"\" do not exists");
        }
        return null;
    }

    @Test
    public void constructorTest(){
        Assert.assertTrue(getClassObject().getConstructors().length == 1);
        Assert.assertTrue(getClassObject().getConstructors()[0].getParameterCount() == 2);
        Assert.assertTrue(getClassObject().getConstructors()[0].getParameters()[0].getType().equals(DependencySignature.class));
        Assert.assertTrue(getClassObject().getConstructors()[0].getParameters()[1].getType().equals(Method.class));
        Assert.assertTrue(getClassObject().getConstructors()[0].getParameters()[2].getType().equals(Object.class));
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
    public void containingObj_field(){
        Assert.assertNotNull(getFieldObject(_containingObjFieldName));
    }

    @Test
    public void containingObj_field_is_private(){
        Assert.assertTrue(Modifier.isPrivate(getFieldObject(_containingObjFieldName).getModifiers()));
    }

    @Test
    public void containingObj_field_is_private_final(){
        Assert.assertTrue(Modifier.isFinal(getFieldObject(_containingObjFieldName).getModifiers()));
    }

    @Test
    public void containingObj_field_is_private_is_of_type_Object(){
        Assert.assertEquals(getFieldObject(_producerMethodFieldName).getType(), Method.class);
    }

    @Test
    public void getSignature(){
        Assert.assertNotNull(getMethodObject(_getSignatureMethodName));
    }

    @Test
    public void getSignature_method_is_public(){
        Assert.assertTrue(Modifier.isPublic(getMethodObject(_getSignatureMethodName).getModifiers()));
    }

    @Test
    public void getSignature_method_return_type_is_DependencySignature(){
        Assert.assertTrue(getMethodObject(_getSignatureMethodName).getReturnType().equals(DependencySignature.class));
    }

    @Test
    public void getDependency(){
        Assert.assertNotNull(getMethodObject(_getDependencyMethodName));
    }

    @Test
    public void getDependency_method_is_public(){
        Assert.assertTrue(Modifier.isPublic(getMethodObject(_getDependencyMethodName).getModifiers()));
    }

    @Test
    public void getDependencyMethodName_method_return_type_is_Object(){
        Assert.assertTrue(getMethodObject(_getDependencyMethodName).getReturnType().equals(Object.class));
    }
}