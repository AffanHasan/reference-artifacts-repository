package com.rc.wefunit;

import com.bowstreet.webapp.WebAppAccess;
import com.rc.wefunit.annotations.GenericSODependency;
import com.rc.wefunit.annotations.Inject;
import com.rc.wefunit.annotations.Qualifier;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    public void method_getDependency_exists(){

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
    public void method_getDependency_DependencySignature_Object_as_return_type(){

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
    public void method_getDependency_DependencySignature_as_first_parameter(){

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

    @Test(enabled = false)
    public void method_getDependency_sc_builders_fixtures_model_webAppAccess(@Mocked final WebAppAccess webAppAccess){
        class ABCSOTest extends GenericServiceOperationTest {}
        ABCSOTest abcsoTest = new ABCSOTest();
        try {
            Field webAppAccess0 = abcsoTest.getClass().getSuperclass().getDeclaredField("webAppAccess");
            Annotation[] ann = new Annotation[]{webAppAccess0.getAnnotation(GenericSODependency.class), };
            DependencySignature ds = new DependencySignature(WebAppAccess.class, webAppAccess0.getDeclaredAnnotationsByType(GenericSODependency.class));
            Factories.RunnerFactory.getInstance().run(webAppAccess);
            new Expectations(){{
//                webAppAccess.getModelName(); result = "Name";
                Factories.RunnerFactory.getInstance().getWebAppAccess().getModelInstance("test/SCBuildersFixture", null, true);
                result = new Object();
            }};
            WebAppAccess webAppAccess1 = (WebAppAccess) _dependencyScanner.getDependency(ds);
            Assert.assertNotNull(webAppAccess1);//Assert Not Null
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }catch (ClassCastException e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}