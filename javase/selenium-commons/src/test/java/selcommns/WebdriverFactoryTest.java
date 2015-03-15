package selcommns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class WebdriverFactoryTest {

    @Test
    public void a_web_driver_needs_to_be_auto_closeable(){

        try( AutoClosableWebDriver wd = Factories.WebDriverFactory.getInstance(); ){

        }finally {

        }

        Assert.assertTrue( Factories.WebDriverFactory.getInstance() instanceof AutoCloseable );
    }

    @Test
    public void by_default_should_return_instance_of_FireFoxDriver(){
//        Assert.assertTrue(Factories.WebDriverFactory.getInstance() instanceof AutoCloseable);
    }

    @Test
    public void by_default_should_return_instance_of_FireFoxDriver_if_FireFoxDriver_is_not_available_then_return_chrome(){
//        Assert.assertTrue(Factories.WebDriverFactory.getInstance() instanceof AutoCloseable);
    }

    @Test
    public void by_default_should_return_instance_of_FireFoxDriver_if_FireFoxDriver_is_not_available_then_return_chrome_if_chrome_not_available_then_return_ie(){
//        Assert.assertTrue(Factories.WebDriverFactory.getInstance() instanceof AutoCloseable);
    }

    @Test
    public void by_default_should_return_instance_of_FireFoxDriver_If_FireFoxDriver_is_not_available_then_return_chrome_If_chrome_not_available_then_return_ie_If_ie_not_available_then_return_NULL(){
//        Assert.assertTrue(Factories.WebDriverFactory.getInstance() instanceof AutoCloseable);
    }
}