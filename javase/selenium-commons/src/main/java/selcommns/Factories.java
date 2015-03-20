package selcommns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

        private static AutoCloseableWebDriver getDriver(WebDriver wd){
            return new AutoCloseableWebDriver(wd);
        }

        public static AutoCloseableWebDriver getInstance() throws FireFoxNotFoundException{

            try{
                return getDriver(new FirefoxDriver());
            }catch(IllegalStateException | org.openqa.selenium.WebDriverException e){
                throw new FireFoxNotFoundException();
            }

//            try{
//                System.out.println("Inside chrome clause");
//                return getDriver(new ChromeDriver());
//            }catch(IllegalStateException | org.openqa.selenium.WebDriverException e){
//                System.out.println("Inside chrome clause : exception clause : " + e.toString());
//            }

//            try{
//                System.out.println("Inside ie clause");
//                return getDriver(new InternetExplorerDriver());
//            }catch(IllegalStateException | org.openqa.selenium.WebDriverException e){
//                System.out.println("Inside ie exception clause");
//            }
        }
    }
}