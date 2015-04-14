package com.rc.wefunit;

import com.rc.wefunit.DependencySignature;
import com.rc.wefunit.producers.FactoryProducers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Affan Hasan on 4/7/15.
 */
public class FixtureDependency implements Comparable {

    @Override
    public int compareTo(Object o) {
        FixtureDependency fd;
        try{
            fd = ( FixtureDependency ) o;
        }catch (ClassCastException e){
            throw new IllegalArgumentException("Provided object is not of type com.rc.wefunit.FixtureDependency");
        }
        return this.getSignature().compareTo(fd.getSignature());
    }

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
        FactoryProducers fp = new FactoryProducers();
        try {
            if(this._producerMethod.getParameters().length > 0){
                Object [] params = new Object[]{  };
                return this._producerMethod.invoke(fp, this._producerMethod);
            }else{
                return this._producerMethod.invoke(fp, this._producerMethod);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}