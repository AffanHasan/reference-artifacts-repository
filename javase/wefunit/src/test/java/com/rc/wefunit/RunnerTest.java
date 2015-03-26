package com.rc.wefunit;

import com.bowstreet.util.SystemProperties;
import com.bowstreet.webapp.WebAppAccess;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.FileSystem;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Affan Hasan on 3/23/15.
 */
public class RunnerTest {

    private final Runner _runner = Factories.RunnerFactory.getInstance();

    private final String _webInfDirPath = "samplewefproject/WebContent/WEB-INF";

    @Test
    public void web_INF_directory_path_web_inf_as_last_directory(@Mocked SystemProperties systemProperties){
        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = _webInfDirPath;
            }
        };
        String path = _runner.getWebInfDirPath();
        Assert.assertTrue(path.endsWith("WEB-INF"));
    }

//    @Test
//    public void (){
//
//    }
}