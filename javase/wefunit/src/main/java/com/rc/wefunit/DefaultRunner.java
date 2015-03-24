package com.rc.wefunit;

import com.bowstreet.util.SystemProperties;

/**
 * Created by Affan Hasan on 3/24/15.
 */
public class DefaultRunner implements Runner {

    @Override
    public String getWebInfDirPath() {
        return SystemProperties.getWebInfDir();
    }
}
