package com.rc.wefunit;

import java.util.Set;

/**
 * Created by Affan Hasan on 3/24/15.
 */
public interface Runner {

    public String getWebInfDirPath();

    public Set<String> scanTestClasses();

    public Set<Class> getTestClassesSet( ClassLoader cl) throws ClassNotFoundException;
}
