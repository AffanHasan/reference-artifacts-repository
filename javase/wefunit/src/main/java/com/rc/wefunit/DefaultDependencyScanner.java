package com.rc.wefunit;

import java.util.SortedSet;

/**
 * Created by Affan Hasan on 4/6/15.
 */
public class DefaultDependencyScanner implements DependencyScanner {

    @Override
    public void scanDependencies(){

    }

    @Override
    public SortedSet getDependenciesSignatures(){
        return null;
    }

    @Override
    public Object getDependency(DependencySignature ds){
        return null;
    }
}