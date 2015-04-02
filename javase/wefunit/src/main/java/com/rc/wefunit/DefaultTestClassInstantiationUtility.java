package com.rc.wefunit;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * Created by Affan Hasan on 4/1/15.
 */
public class DefaultTestClassInstantiationUtility implements TestClassInstantiationUtility {

    @Override
    public Object instantiateTestClass(Class testClass) {
        Object instance = null;
        try {
//            Instantiate object
            instance = testClass.newInstance();

//            Now inject dependencies
            if(instance instanceof GenericServiceOperationTest){
                try {//Injecting 'serviceOperationName'
                    String classSimpleName = testClass.getSimpleName();
                    String soName =  classSimpleName.split("Test")[1];
                    soName = soName.replaceFirst(soName.substring(0, 1), (soName.substring(0, 1).toLowerCase()));
                    Field field = testClass.getField("serviceOperationName");
                    field.set(instance, soName);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }
}