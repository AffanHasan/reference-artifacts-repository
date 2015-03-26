package com.rc.wefunit;

import com.bowstreet.util.SystemProperties;
import com.bowstreet.webapp.WebAppAccess;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.FileSystem;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Affan Hasan on 3/23/15.
 */
public class RunnerTest {

    private Runner _runner;

    private final String _webInfDirPath = "samplewefproject/WebContent/WEB-INF";

    @BeforeTest
    public void beforeTest(){
        _runner = Factories.RunnerFactory.getInstance();
    }

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

    @Test
    public void scan_for_test_classes(@Mocked SystemProperties systemProperties){

        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = _webInfDirPath;
            }
        };

        String packageName = "test.models.test.services.Service1.";
        Set<String> fileNames = new LinkedHashSet<String>();
        fileNames.add(packageName + "SOOneTest.class");
        fileNames.add(packageName + "SOFour_Test.class");
        fileNames.add(packageName + "SOTwoTest.class");

        Set<String> qualifiedFileNames = _runner.scanTestClasses();
        for( String name : fileNames ) {
            Assert.assertTrue(qualifiedFileNames.contains(name));
        }
        Class c;
    }

    @Test
    public void scan_for_test_classes_must_throw_IllegalStateException_when_WEB_INF_dir_is_not_a_wef_project
            (@Mocked SystemProperties sysProps){

        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = "target/";
            }
        };


        try{
            _runner.scanTestClasses();
            Assert.fail("IllegalStateException not thrown");
        }catch(IllegalStateException e){
            Assert.assertEquals(e.getMessage(),
                    "Scan for test classes failed; no valid Web Experience Factory WEB-INF path found");
        }
    }
}