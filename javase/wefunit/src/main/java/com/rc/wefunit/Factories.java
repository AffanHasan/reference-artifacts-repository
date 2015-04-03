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

    public static class TestClassInstantiationUtilityFactory {
        public static TestClassInstantiationUtility getInstance(){
            return new DefaultTestClassInstantiationUtility();
        }
    }

    public static class FixtureDependencyInjectorUtilityFactory {
        public static FixtureDependencyInjectorUtility getInstance(){
            return new DefaultFixtureDependencyInjectorUtility();
        }
    }
}