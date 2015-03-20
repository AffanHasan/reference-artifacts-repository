package com.rc.wefunit;

/**
 * Created by Affan Hasan on 3/20/15.
 */
public @interface Test {

    public boolean enabled() default true;
}