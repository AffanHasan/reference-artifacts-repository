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
    public void by_default_should_return_instance_of_FireFoxDriver(@Mocked FirefoxDriver fd){

        new Expectations(){
            {
                new FirefoxDriver(); result = new FireFoxNotFoundException();
            }
        };

        try( AutoCloseableWebDriver wd = Factories.WebDriverFactory.getInstance() ){
            Assert.fail();
        } catch (FireFoxNotFoundException e) {
            return;
        }
        Assert.fail();
    }

    @Test(enabled = true)
    public void by_default_should_return_instance_of_FireFoxDriver_(@Mocked FirefoxDriver fd){

        new Expectations(){
            {
                new FirefoxDriver(); result = new FireFoxNotFoundException();
            }
        };

        try( AutoCloseableWebDriver wd = Factories.WebDriverFactory.getInstance() ){
            Assert.fail();
        } catch (FireFoxNotFoundException e) {
            return;
        }
        Assert.fail();
    }

    @Test(enabled = true)
    public void if_firefox_is_not_found_then_ask_for_the_firefox_installed_path(){

        try( AutoCloseableWebDriver wd = Factories.WebDriverFactory.getInstance() ){
            Assert.assertEquals( wd.getBrowserType(), FirefoxDriver.class.getName() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false)
    public void if_no_FF_and_no_chrome_is_installed_then_ask_for_at_least_one_of_the_browser_paths
            (@Mocked FirefoxDriver fd, @Mocked ChromeDriver cd){
//
//        new Expectations(){
//            {
//                new FirefoxDriver(); result = new WebDriverException();
//                new ChromeDriver(); result = new WebDriverException();
//            }
//        };
    }

    @Test(enabled = false)
    public void by_default_should_return_instance_of_FireFoxDriver_IF_firefox_is_not_available_then_return_instance_of_ChromeDriver(@Mocked FirefoxDriver fd){

        new Expectations(){//Making firefox unavailable
            {
                new FirefoxDriver(); result = new WebDriverException();
            }
        };

        try( AutoCloseableWebDriver wd = Factories.WebDriverFactory.getInstance() ){
            Assert.assertEquals( wd.getBrowserType(), ChromeDriver.class.getName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            new InternetExplorerDriver();
        }catch ( WebDriverException | IllegalStateException e ){
            if( e instanceof IllegalStateException ){
                System.out.println(((IllegalStateException) e).getClass().getName());
            }else if(e instanceof WebDriverException){
                System.out.println(((IllegalStateException) e).getClass().getName());

            }
        }
    }
}