package com.rc.wefunit;

import com.rc.wefunit.DependencySignature;
import java.lang.reflect.Method;

/**
 * Created by Affan Hasan on 4/7/15.
 */
public class FixtureDependency {

    private final DependencySignature _dependencySignature;

    private final Method _producerMethod;

    public FixtureDependency(DependencySignature ds, Method producerMethod){
        this._dependencySignature = ds;
        this._producerMethod = producerMethod;
    }

    public DependencySignature getSignature(){
        return this._dependencySignature;
    }

    public Object getDependency(){
        return null;
    }
}