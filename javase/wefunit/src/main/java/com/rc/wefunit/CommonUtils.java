package com.rc.wefunit;

import com.rc.wefunit.annotations.Qualifier;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by root on 4/16/15.
 */
public class CommonUtils {

    public final Annotation[] filterQualifierAnnotations(Annotation[] annotations){
        List<Annotation> list = new ArrayList<Annotation>();
        for(Annotation item : annotations){
            if(item.annotationType().isAnnotationPresent(Qualifier.class))
                list.add(item);
        }
        Annotation[] arr = new Annotation[list.size()];
        return list.toArray(arr);
    }

    public final void getSuperClassesHierarchy(Class classObject, Set<Class> theSet){
        if(classObject.getSuperclass().equals(Object.class)) {
            theSet.add(classObject.getSuperclass());
            return;
        }else {
            theSet.add(classObject.getSuperclass());
            getSuperClassesHierarchy(classObject.getSuperclass(), theSet);
            return;
        }
    }
}