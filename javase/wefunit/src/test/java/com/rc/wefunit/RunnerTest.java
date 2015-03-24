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
import java.util.Hashtable;

/**
 * Created by Affan Hasan on 3/23/15.
 */
public class RunnerTest {

    private final Runner _runner = Factories.RunnerFactory.getInstance();

    @Test
    public void web_INF_directory_path_not_null(@Mocked SystemProperties systemProperties){
        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = "resources/WEB-INF";
            }
        };
        String path = _runner.getWebInfDirPath();
        Assert.assertNotNull(path);
    }

    @Test
    public void web_INF_directory_path_web_inf_as_last_directory(@Mocked SystemProperties systemProperties){
        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = "resources/WEB-INF";
            }
        };
        String path = _runner.getWebInfDirPath();
        Assert.assertTrue(path.endsWith("WEB-INF"));
    }

    @Test
    public void web_INF_directory_path_verify_that_this_is_a_wef_project(@Mocked SystemProperties systemProperties){
        new Expectations(){
            {
                SystemProperties.getWebInfDir(); result = "resources/WEB-INF";
            }
        };
        String path = _runner.getWebInfDirPath();
        File file = new File(path);
        Assert.assertTrue(file.isDirectory());
        boolean containsModelFolder = false;
        boolean containsWorkFolder = false;
        for( File item : file.listFiles() ){
            if(item.getName().equals("models") && item.isDirectory()){
                containsModelFolder = true;
            }
            if(item.getName().equals("work") && item.isDirectory()){
                containsWorkFolder = true;
            }
        }
        Assert.assertTrue(containsModelFolder);//Must contain "models" folder
        Assert.assertTrue(containsWorkFolder);//Must contain "work" folder
    }
}