package com.rc.wefunit;

import com.rc.wefunit.annotations.GenericSODependency;
import com.rc.wefunit.annotations.Inject;

import java.lang.reflect.Field;

/**
 * Created by Affan Hasan on 4/3/15.
 */
public class DefaultFixtureDependencyInjectorUtility implements FixtureDependencyInjectorUtility {

    @Override
    public void inject(Field field, Object instance) {
        if(!field.isAnnotationPresent(Inject.class))//If field is not an injectable one
            throw new IllegalStateException("Provided field is not Injectable");

        final Class testClass = instance.getClass();
        if(instance instanceof GenericServiceOperationTest){//If this is a Service Operation Test
            try {
                switch (field.getAnnotation(GenericSODependency.class).value()){
                    case DATA_SERVICE_NAME:
                        String packageNameArray[] = testClass.getPackage().getName().split("\\Q.\\E");
                        String dsName = packageNameArray[packageNameArray.length - 1];
                        dsName = dsName.split("Test")[0];
                        dsName = dsName + "SC";
                        field.set(instance, dsName);
                        break;
                    case SERVICE_OPERATION_NAME:
                        String classSimpleName = testClass.getSimpleName();
                        String soName =  classSimpleName.split("Test")[0];
                        soName = soName.replaceFirst(soName.substring(0, 1), (soName.substring(0, 1).toLowerCase()));
                        field.set(instance, soName);
                        break;
                    case SERVICE_CONSUMER_BUILDERS_FIXTURE_MODEL:
                        break;
                    }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}