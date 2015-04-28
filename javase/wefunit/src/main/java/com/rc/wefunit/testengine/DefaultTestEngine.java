package com.rc.wefunit.testengine;

import com.google.gson.JsonObject;
import com.rc.wefunit.CommonUtils;
import com.rc.wefunit.Factories;

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
        this._resetTestScoring();
    }

    @Override
    public void executeTests(Queue<Object> objectsQueue) {
        this._resetTestScoring();//Resetting the test scoring
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
//                    Incrementing the executed test count
                    this._incrementTotalExecutedTests();
                    m.invoke(testObj);//Execute the test
                } catch (Throwable e) {//If here it means that the test failed
//                    e.printStackTrace();
                    this._incrementTotalTestFailures();
                }
            }
        }
    }

    private void _resetTestScoring(){
        JsonObject score = new JsonObject();
        score.addProperty("totalExecutedTests", 0);
        score.addProperty("totalTestFailures", 0);
        this._testScores.add("score", score);
    }

    private void _incrementTotalExecutedTests(){
        JsonObject score = this._testScores.get("score").getAsJsonObject();
        int totalExecutedTests = score.get("totalExecutedTests").getAsInt();
        score.addProperty("totalExecutedTests", ++totalExecutedTests);
    }

    private void _incrementTotalTestFailures(){
        JsonObject score = this._testScores.get("score").getAsJsonObject();
        int totalTestFailures = score.get("totalTestFailures").getAsInt();
         score.addProperty("totalTestFailures", ++totalTestFailures);
    }

    @Override
    public JsonObject getTestScores() {
        return _testScores;
    }
}