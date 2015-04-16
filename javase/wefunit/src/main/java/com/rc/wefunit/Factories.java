package com.rc.wefunit;

/**
 * Created by Affan Hasan on 3/24/15.
 */
public class Factories {

    public static class RunnerFactory {

        private static final Runner _runner = new DefaultRunner();

        public static Runner getInstance(){
            return _runner;
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

    public static class DependencyScannerFactory {
        public static DependencyScanner getInstance(){
            return new DefaultDependencyScanner();
        }
    }
}