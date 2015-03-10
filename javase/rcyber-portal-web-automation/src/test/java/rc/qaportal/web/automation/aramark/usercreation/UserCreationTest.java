package rc.qaportal.web.automation.aramark.usercreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import rc.qaportal.web.automation.aramark.AramarkEnvs;
import rc.qaportal.web.automation.aramark.AramarkFactories;

/**
 * Created by Affan Hasan on 3/10/15.
 */
public class UserCreationTest {

    private final AramarkUserCreator _ucFixture = AramarkFactories.UserCreatorFactory.getInstance();
    private final String _dev2URLFixture = "http://dev2-portal.ecps.ca/wps/portal/eCPS/";

    @Test
    public void dev2_url_correctness(){
        Assert.assertEquals(uc.getDev2URL(), _dev2URLFixture);
    }

    @Test
    public void dev2_ecpsMenuAdmin_role_user_creation(){
        final String userName = "ecpsMenuAdmin1", userPassword = "passw0rd";
        Object arr[] = {userName, userPassword, AramarkCompanies.CPS, AramarkLanguages.en, AramarkUserRoles.ECPS_MENU_ADMIN};

        _ucFixture.CreateUser(AramarkEnvs.DEV_2, userName, userPassword);
//        Test user existence
        _loginDev2ForCheckingUserExistenceTest(userName, userPassword);
    }

    private void _loginDev2ForCheckingUserExistenceTest(String userName, String userPassword){

//        Verify that the user is created
        WebDriver driver = new FirefoxDriver();
        driver.get(_dev2URLFixture);
        WebElement uNameInput = driver.findElement(By.id("usernameInput"));
        WebElement uPasswordInput = driver.findElement(By.id("passwordInput"));

        uNameInput.sendKeys(userName);//enter User Name
        uPasswordInput.sendKeys(userPassword);//Enter User Password
        uPasswordInput.submit();//Submit the form
//        Verify the after login screen
        Assert.assertTrue(driver.findElement(By.id("wrapper-userinfo")).getText().trim().length() == 0);
    }
}