package com.rc.wefunit.testengine;

import com.bowstreet.util.SystemProperties;
import com.bowstreet.webapp.WebAppAccess;
import com.google.gson.JsonObject;
import com.rc.wefunit.Factories;
import com.rc.wefunit.Runner;
import com.rc.wefunit.TestClassStats;
import com.rc.wefunit.annotations.BeforeClass;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Queue;

/**
 * Created by Affan Hasan on 4/24/15.
 */
public class TestEngineTest {

    private final String _webInfDirPath = "samplewefproject/WebContent/WEB-INF";

    private final TestEngine _testEngine = Factories.TestEngineFactory.getInstance();
    private final Runner _runner = Factories.RunnerFactory.getInstance();
    private TestClassStats _testClassStats;

    private Class getClassObject(){
        try {
            return Class.forName("com.rc.wefunit.testengine.TestEngine");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            return null;
        }
    }

    @Test
    public void is_exist_Interface_TestEngine(){
        Assert.assertNotNull(getClassObject());//Test Not Null
    }

    @Test
    public void method_executeTests_parameters_Queue(){
        try {
            Class testEngine = getClassObject();
            Method m = testEngine.getMethod("executeTests", Queue.class);
            Assert.assertNotNull(m);//Test Not Null
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void method_executeTests_total_executed_tests_should_equal_to_total_no_of_tests_present(@Mocked SystemProperties systemProperties, @Mocked final Factories.RunnerFactory runnerFactory, @Injectable final WebAppAccess webAppAccess, @Injectable final Runner runner){
        new Expectations(){
            {
                runnerFactory.getInstance();result = runner;
                runner.getWebAppAccess();result = webAppAccess;
                runner.getWebAppAccess().getModelInstance("test/SCBuildersFixture", null, true); result = webAppAccess;
                SystemProperties.getWebInfDir(); result = _webInfDirPath;
            }
        };
        Queue<Object> queue = this._runner.getExecutableTestObjectsQueue();
        try {
            this._testClassStats = Factories.TestClassStatsFactory.getInstance(this._runner.getTestClassesSet());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        this._testEngine.executeTests(queue);
        JsonObject testScores = this._testEngine.getTestScores();
        Assert.assertEquals(testScores.getAsJsonObject("score").get("totalExecutedTests").getAsInt(),
                this._testClassStats.getTotalExecutableTestsCount());
    }
}