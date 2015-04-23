package com.rc.wefunit;

import com.bowstreet.util.SystemProperties;
import com.bowstreet.webapp.WebAppAccess;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Affan Hasan on 3/23/15.
 */
public class RunnerTest {

    private Runner _runner;

    private final String _webInfDirPath = "samplewefproject/WebContent/WEB-INF";

    private final String _package1 = "test.models.test.services.Service1Test.";
    private final String _package2 = "test.models.test.services.Service2Test.";
    private final String _package3 = "test.package1.";

    private final Set<String> _fileNames;

    RunnerTest(){
        _fileNames = new LinkedHashSet<String>();
        _fileNames.add(_package1 + "GetUserInfoSOTest");
        _fileNames.add(_package1 + "GetTransactionReportsSO_Test");
        _fileNames.add(_package1 + "GetAccountsDetailSOTest");

        _fileNames.add(_package2 + "Service2FirstSOTest");

        _fileNames.add(_package3 + "MyLogicTest");
        _fileNames.add(_package3 + "MyLogic1Test");
        _fileNames.add(_package3 + "MyLogic2Test");
    }

    @BeforeTest
    public void beforeTest(){
        _runner = Factories.RunnerFactory.getInstance();
    }

    @Test
    public void method_run_with_parameter_WebAppAccess_existence(){
        try {
            Class runner = Class.forName("com.rc.wefunit.Runner");
            Method m = runner.getMethod("run", WebAppAccess.class);
            Assert.assertNotNull(m);//Not Null
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void method_run(){
        try {
            Class runner = Class.forName("com.rc.wefunit.Runner");
            Method m = runner.getMethod("run", WebAppAccess.class);
            Assert.assertNotNull(m);//Not Null
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void Runner_instance_must_be_singleton(){
        Runner r1 = Factories.RunnerFactory.getInstance();
        Runner r2 = Factories.RunnerFactory.getInstance();
        Assert.assertTrue(r1.equals(r2));
    }

    @Test
    public void method_getWebInfDirPath_web_INF_directory_path_web_inf_as_last_directory(@Mocked SystemProperties systemProperties){
        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = _webInfDirPath;
            }
        };
        String path = _runner.getWebInfDirPath();
        Assert.assertTrue(path.endsWith("WEB-INF"));
    }

    @Test
    public void method_scanTestClasses_scan_for_test_classes(@Mocked SystemProperties systemProperties){

        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = _webInfDirPath;
            }
        };

        Set<String> qualifiedFileNames = _runner.scanTestClasses();
        for( String name : _fileNames) {
            Assert.assertTrue(qualifiedFileNames.contains(name));
        }
    }

    @Test
    public void method_scanTestClasses_scan_for_test_classes_must_throw_IllegalStateException_when_WEB_INF_dir_is_not_a_wef_project
            (@Mocked SystemProperties sysProps){

        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = "target/";
            }
        };

        try{
            _runner.scanTestClasses();
            Assert.fail("IllegalStateException not thrown");
        }catch(IllegalStateException e){
            Assert.assertEquals(e.getMessage(),
                    "Scan for test classes failed; no valid Web Experience Factory WEB-INF path found");
        }
    }

    @Test
    public void method_getTestClassesSet(@Mocked SystemProperties systemProperties){
        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = _webInfDirPath;
            }
        };

        Set<Class> set= null;
        try {
            set = _runner.getTestClassesSet(ClassLoader.getSystemClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

        for( Class item : set){
            Assert.assertTrue(_fileNames.contains(item.getName()));
        }
    }

    @Test
    public void method_getWebAppAccess_existence(){
        try {
            Class runner = Class.forName("com.rc.wefunit.Runner");
            Method m = runner.getMethod("getWebAppAccess");
            Assert.assertNotNull(m);//Not Null
            Assert.assertNotNull(m.getReturnType().equals(WebAppAccess.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void method_getWebAppAccess_throw_IllegalStateException_when_called_before_calling_run_method(){
        try {
            _runner.getWebAppAccess();
        } catch (IllegalStateException e) {
            Assert.assertEquals(e.getMessage(), "Method \"getWebAppAccess\" is called before calling the \"run\" method");
            return;
        }
        Assert.fail();
    }

    @Test
    public void method_getTestClassesExecutionPriorityQueue(@Mocked SystemProperties systemProperties){

        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = _webInfDirPath;
            }
        };
        PriorityQueue<Class> pq = _runner.getTestClassesExecutionPriorityQueue();

        final class TestClassStats{

            private final Set<Class> _testClassesSet;

            TestClassStats(Set<Class> testClassesSet){
                this._testClassesSet = testClassesSet;
            }

            public int getSOTestClassesCount(){
                int count = 0;
                for(Class classItem : this._testClassesSet){
                    if(classItem.getSuperclass().equals(GenericServiceOperationTest.class))
                        count++;
                }
                return count;
            }

            public int getNonSOTestClassesCount(){
                int count = 0;
                for(Class classItem : this._testClassesSet){
                    if(!classItem.getSuperclass().equals(GenericServiceOperationTest.class))
                        count++;
                }
                return count;
            }
        }

        try {
            Set<Class> testClassesSet = _runner.getTestClassesSet(ClassLoader.getSystemClassLoader());
            TestClassStats testClassStats = new TestClassStats(testClassesSet);

            for(int c = 0; c < testClassStats.getSOTestClassesCount() ; c++){
                Assert.assertEquals(pq.poll().getSuperclass(), GenericServiceOperationTest.class);//Polling "GenericServiceOperationTest" classes first
            }
            for(int c = 0; c < testClassStats.getNonSOTestClassesCount() ; c++){
                Assert.assertNotEquals(pq.poll().getSuperclass(), GenericServiceOperationTest.class);//Polling "GenericServiceOperationTest" classes afterwards
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}