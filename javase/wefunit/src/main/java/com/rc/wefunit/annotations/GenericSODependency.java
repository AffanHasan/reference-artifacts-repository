package com.rc.wefunit.annotations;

import com.rc.wefunit.enums.GenericSOInjectables;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by root on 4/2/15.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenericSODependency {

    public GenericSOInjectables dependency();
}