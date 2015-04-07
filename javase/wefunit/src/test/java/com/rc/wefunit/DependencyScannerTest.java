package com.rc.wefunit;

import com.rc.wefunit.annotations.Qualifier;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;

/**
 * Created by Affan Hasan on 4/6/15.
 */
public class DependencyScannerTest {

    private final DependencyScanner _dependencyScanner = Factories.DependencyScannerFactory.getInstance();

    @Test
    public void interface_DependencyScanner_existence(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Assert.assertNotNull(classObj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getDependency_exists(){

        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Assert.assertNotNull(classObj.getMethod("getDependency", DependencySignature.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getDependency_DependencySignature_Object_as_return_type(){

        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Method m = classObj.getMethod("getDependency", DependencySignature.class);
            Assert.assertEquals(m.getReturnType(), Object.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getDependency_DependencySignature_as_first_parameter(){

        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Method m = classObj.getMethod("getDependency", DependencySignature.class);
            Assert.assertNotNull(m);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getDependency_functional_test_1(){
        String result = "myOwnSO";
        class MyOwnSO extends GenericServiceOperationTest{

        }
        MyOwnSO myOwnSO = new MyOwnSO();

        Class sc = myOwnSO.getClass().getSuperclass();
        try {
            Field field = sc.getDeclaredField("serviceOperationName");
            Class dataType = field.getType();
            List<Annotation> list = new LinkedList<Annotation>();
            for(Annotation ann : field.getDeclaredAnnotations()){
                if(ann.getClass().isAnnotationPresent(Qualifier.class))
                    list.add(ann);
            }
            Annotation[] arr = new Annotation[list.size()];
            for( int i = 0 ; i < list.size() ; i++ ){
                arr[i] = list.get(i);
            }
            DependencySignature ds = new DependencySignature(dataType, arr);
            String str = (String) _dependencyScanner.getDependency(ds);
            Assert.assertEquals(str , result);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}