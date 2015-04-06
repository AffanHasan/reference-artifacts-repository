package com.rc.wefunit;

import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void method_scanDependencies_exists(){
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
    public void method_getDependencies_signatures(){
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
}