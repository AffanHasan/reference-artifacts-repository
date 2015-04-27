package com.rc.wefunit.probes;


/**
 * Created by Affan Hasan on 4/24/15.
 */
public class Assert{

    public static void assertTrue(Boolean b){
        if(b == false)
            throw new AssertionError("Expected [ true ] but found [ false ]");
    }

    public static void fail(String message){

    }
}