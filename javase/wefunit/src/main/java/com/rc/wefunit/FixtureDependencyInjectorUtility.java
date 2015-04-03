package com.rc.wefunit;

import java.lang.reflect.Field;

/**
 * Created by Affan Hasan on 4/3/15.
 */
public interface FixtureDependencyInjectorUtility {

    public void inject(Field field, Object obj);
}