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

        public static WebDriver getInstance(){
            try{
                return new FirefoxDriver();
            }catch(IllegalStateException e){

            }

            try{
                return new ChromeDriver();
            }catch(IllegalStateException e){

            }

            try{
                return new InternetExplorerDriver();
            }catch(IllegalStateException e){

            }
            return null;
        }
    }
}