package rc.qaportal.web.automation.aramark.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rc.qaportal.web.automation.aramark.AramarkFactories;
import rc.qaportal.web.automation.aramark.enums.AramarkEnvs;
import selcommns.Factories;

/**
 * Created by Affan Hasan on 3/12/15.
 */
public class UserLoginUtility {

    public static WebDriver loginToAramarkPortal(AramarkEnvs env, String[] userCredentials){
//        WebDriver wd = Factories.WebDriverFactory.getInstance();
//        wd.get(AramarkFactories.UserCreatorFactory.getInstance().getURL(env));
//        wd.findElement(By.id("usernameInput")).sendKeys(userCredentials[0]);//Enter user name
//        wd.findElement(By.id("passwordInput")).sendKeys(userCredentials[1]);//Enter user password
//        wd.findElement(By.name("btn_submit")).click();
        return null;
    }
}