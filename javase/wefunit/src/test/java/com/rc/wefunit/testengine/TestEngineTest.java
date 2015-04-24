package com.rc.wefunit.testengine;

import com.rc.wefunit.Factories;
import com.rc.wefunit.Runner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Queue;

/**
 * Created by Affan Hasan on 4/24/15.
 */
public class TestEngineTest {

    private final TestEngine _testEngine = Factories.TestEngineFactory.getInstance();
    private final Runner _runner = Factories.RunnerFactory.getInstance();

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
}