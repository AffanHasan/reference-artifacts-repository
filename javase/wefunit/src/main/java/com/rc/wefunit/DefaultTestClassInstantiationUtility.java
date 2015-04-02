package com.rc.wefunit;

import com.rc.wefunit.annotations.Inject;

import java.lang.reflect.Field;

/**
 * Created by Affan Hasan on 4/1/15.
 */
public class DefaultTestClassInstantiationUtility implements TestClassInstantiationUtility {

    private Object _instance = null;

    @Override
    public Object instantiateTestClass(Class testClass) {

        class InjectableFieldsFilter {

            public Field[] getInjectableFields(Field[] fields){
                Field[] injectableFields = null;;
                for( int c = 0; c < fields.length ; c++){
                    if(fields[c].isAnnotationPresent(Inject.class))
                        injectableFields[c] = fields[c];

                }
                return  fields;
            }
        }

        try {
//            Instantiate object
            _instance = testClass.newInstance();

//            Now inject dependencies For class "GenericServiceOperationTest"
            if(_instance instanceof GenericServiceOperationTest){
                try {
//                    Get those fields which are annotated @Inject
                    Field[] injectableFields = new InjectableFieldsFilter().getInjectableFields(testClass.getFields());
                    for( Field item : injectableFields ){
                        //Injecting 'serviceOperationName'
                    }
                    String classSimpleName = testClass.getSimpleName();
                    String soName =  classSimpleName.split("Test")[0];
                    soName = soName.replaceFirst(soName.substring(0, 1), (soName.substring(0, 1).toLowerCase()));
                    Field serviceOperationName = testClass.getSuperclass().getDeclaredField("serviceOperationName");
                    serviceOperationName.set(_instance, soName);
                    //Injecting 'serviceOperationName' ends
                    //Injecting 'dataServiceName' starts
                    String packageNameArray[] = testClass.getPackage().getName().split("\\Q.\\E");
                    String dsName = packageNameArray[packageNameArray.length - 1];
                    dsName = dsName.split("Test")[0];
                    dsName = dsName + "SC";
                    Field dataServiceName = testClass.getSuperclass().getDeclaredField("dataServiceName");
                    dataServiceName.set(_instance, dsName);
                    //Injecting 'dataServiceName' ends
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return _instance;
    }
}