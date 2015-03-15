package selcommns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Set;

/**
 * Created by Affan Hasan on 3/11/15.
 */
public class Factories {

    public interface FactoryInterface{

        public static Object getInstance(){
            throw new NotImplementedException();
        }
    }

    public static class WebDriverFactory{

        private static AutoClosableWebDriver getDriver(WebDriver wd){
            return new AutoClosableWebDriver(wd);
        }

        public static AutoClosableWebDriver getInstance(){

            try{
                return getDriver(new FirefoxDriver());
            }catch(IllegalStateException | org.openqa.selenium.WebDriverException e){

            }

            try{
                return getDriver(new ChromeDriver());
            }catch(IllegalStateException | org.openqa.selenium.WebDriverException e){

            }

            try{
                return getDriver(new InternetExplorerDriver());
            }catch(IllegalStateException | org.openqa.selenium.WebDriverException e){

            }
            return null;
        }
    }
}