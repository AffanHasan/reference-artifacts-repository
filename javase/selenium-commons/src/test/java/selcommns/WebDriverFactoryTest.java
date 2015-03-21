package selcommns;

import mockit.Expectations;
import mockit.Mocked;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * For these tests to be successfully run; it is necessary that either FireFox is installed to the system
 */
public class WebDriverFactoryTest {

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
//        Check whether FireFox is installed on the system or not
        try{//For Fire Fox
           WebDriver wd = new FirefoxDriver();
            wd.close();
        }catch( IllegalStateException | WebDriverException e ){
            e.printStackTrace();
            System.exit(0);
        }

//        try{//For Chrome
//           WebDriver wd = new ChromeDriver();
//            wd.close();
//        }catch( IllegalStateException | WebDriverException e ){
//            e.printStackTrace();
//            System.exit(0);
//        }
    }

    @Test(enabled = true)
    public void a_web_driver_needs_to_be_auto_closeable(){

        try( AutoCloseable wd = Factories.WebDriverFactory.getInstance() ){
            Assert.assertTrue( wd instanceof WebDriver );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = true)
    public void by_default_should_return_FireFoxDriver(){

        try( AutoCloseableWebDriver wd = Factories.WebDriverFactory.getInstance() ){
            Assert.assertEquals( wd.getBrowserType(), FirefoxDriver.class.getName() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void if_no_FF_is_installed_then_ask_for_the_browser_path(@Mocked FirefoxDriver ffd){

       new Expectations(){
           {
               new FirefoxDriver(); result = new WebDriverException();
           }
       };

        try(AutoCloseableWebDriver awd = Factories.WebDriverFactory.getInstance()){
            Assert.fail();
        }catch(FireFoxNotFoundException e){
            Assert.assertEquals(e.getMessage(), "FireFox not found please provide FireFox exe file path");
        }
    }
}