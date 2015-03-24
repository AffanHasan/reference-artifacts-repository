package com.rc.wefunit;

/**
 * Created by Affan Hasan on 3/24/15.
 */
public class Factories {

    public static class RunnerFactory {
        public static Runner getInstance(){
            return new DefaultRunner();
        }
    }
}