package com.rc.wefunit.testengine;

import com.google.gson.JsonObject;
import com.rc.wefunit.CommonUtils;
import com.rc.wefunit.Factories;

import javax.json.Json;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Queue;

/**
 * Created by Affan Hasan on 4/24/15.
 */
public class DefaultTestEngine implements TestEngine {

    private final JsonObject _testScores = new JsonObject();
    private final CommonUtils _commonUtils = Factories.CommonUtilsFactory.getInstance();

    public DefaultTestEngine(){
        JsonObject score = new JsonObject();
        score.addProperty("totalExecutedTests", 0);
        this._testScores.add("score", score);
    }

    @Override
    public void executeTests(Queue<Object> objectsQueue) {
        Object testObj;
        while (objectsQueue.peek() != null){
            testObj = objectsQueue.poll();//Fetching test class from the Queue
//            Getting test methods list
            Method[] testMethods = this._commonUtils.getTestMethodsArrayFromTestClass(testObj.getClass());
//            Executing test methods
            for( Method m : testMethods ){
                try {
                    if(Modifier.isPrivate(m.getModifiers()))//If it is a private test method
                        m.setAccessible(true);//Make it accessible
                    m.invoke(testObj);//Execute the test
//                    If here it means that test executed successfully hence incrementing the test count
                    JsonObject score = this._testScores.get("score").getAsJsonObject();
                    int totalExecutedTests = score.get("totalExecutedTests").getAsInt();
                     score.addProperty("totalExecutedTests", ++totalExecutedTests);
                } catch (Throwable e) {//If here it means that the test failed
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public JsonObject getTestScores() {
        return _testScores;
    }
}