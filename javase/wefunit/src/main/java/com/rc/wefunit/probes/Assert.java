package com.rc.wefunit.probes;


/**
 * Created by Affan Hasan on 4/24/15.
 */
public class Assert{

//    private final static JsonObject _testScores = new JsonObject();

    public static void assertTrue(Boolean b){
        if(b == false)
            throw new AssertionError("Expected [ true ] but found [ false ]");
    }
}