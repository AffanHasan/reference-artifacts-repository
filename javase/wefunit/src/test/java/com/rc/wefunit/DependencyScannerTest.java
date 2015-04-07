package com.rc.wefunit;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
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
    public void scanDependencies_exists(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Assert.assertNotNull(classObj.getMethod("scanDependencies"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getDependenciesSignatures(){

        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Assert.assertNotNull(classObj.getMethod("getDependenciesSignatures"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getDependenciesSignatures_return_type_is_java_util_sorted_set(){
        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Method m = classObj.getMethod("getDependenciesSignatures");
            Assert.assertEquals(m.getReturnType(), SortedSet.class);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getDependency_exists(){

        try {
            Class classObj = Class.forName("com.rc.wefunit.DependencyScanner");
            Assert.assertNotNull(classObj.getMethod("getDependency"));
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
}