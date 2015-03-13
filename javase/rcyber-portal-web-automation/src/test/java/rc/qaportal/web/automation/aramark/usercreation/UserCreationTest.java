package rc.qaportal.web.automation.aramark.usercreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import rc.qaportal.web.automation.aramark.enums.AramarkCompanies;
import rc.qaportal.web.automation.aramark.enums.AramarkEnvs;
import rc.qaportal.web.automation.aramark.AramarkFactories;
import rc.qaportal.web.automation.aramark.enums.AramarkLanguages;
import rc.qaportal.web.automation.aramark.enums.AramarkUserRoles;

/**
 * Created by Affan Hasan on 3/10/15.
 */
public class UserCreationTest {

    private final AramarkUserCreator _ucFixture = AramarkFactories.UserCreatorFactory.getInstance();
    private final String _dev2_CPS_URLFixture = "http://dev2-portal.ecps.ca/wps/portal/eCPS/";
    private final String _dev2_GESPRA_URLFixture = "http://dev2-portal.ecps.ca/wps/portal/GESPRA/";
    private final String _preqa_CPS_URLFixture = "https://preqa-portal.ecps.ca/wps/portal/eCPS/";
    private final String _preqa_GESPRA_URLFixture = "https://preqa-portal.ecps.ca/wps/portal/GESPRA/";

    @Test
    public void dev2_CPS_url_correctness(){
        Assert.assertEquals(_ucFixture.getURL(AramarkEnvs.DEV_2_CPS), _dev2_CPS_URLFixture);
    }

    @Test
    public void dev2_GESPRA_url_correctness(){
        Assert.assertEquals(_ucFixture.getURL(AramarkEnvs.DEV_2_GESPRA), _dev2_GESPRA_URLFixture);
    }

    @Test
    public void preqa_CPS_url_correctness(){
        Assert.assertEquals(_ucFixture.getURL(AramarkEnvs.PRE_QA_CPS), _preqa_CPS_URLFixture);
    }

    @Test
    public void preqa_GESPRA_url_correctness(){
        Assert.assertEquals(_ucFixture.getURL(AramarkEnvs.PRE_QA_GESPRA), _preqa_GESPRA_URLFixture);
    }

    @Test(enabled = false)
    public void dev2_ecpsMenuAdmin_role_user_creation(){
        final String userName = "ecpsMenuAdmin1", userPassword = "passw0rd";
        Object credentials[] = {userName, userPassword, AramarkCompanies.CPS, AramarkLanguages.en_US, AramarkUserRoles.ECPS_MENU_ADMIN};
        _ucFixture.createUser(AramarkEnvs.DEV_2_CPS, credentials);
//        Test user existence
        _loginDev2ForCheckingUserExistenceTest(userName, userPassword);
    }

    private void _loginDev2ForCheckingUserExistenceTest(String userName, String userPassword){

//        Verify that the user is created
        WebDriver driver = new FirefoxDriver();
        driver.get(_dev2_CPS_URLFixture);
        WebElement uNameInput = driver.findElement(By.id("usernameInput"));
        WebElement uPasswordInput = driver.findElement(By.id("passwordInput"));

        uNameInput.sendKeys(userName);//enter User Name
        uPasswordInput.sendKeys(userPassword);//Enter User Password
        driver.findElement(By.name("btn_submit")).click();
//        Verify the after login screen
        Assert.assertTrue(driver.findElement(By.id("wrapper-userinfo")).getText().trim().length() == 0);
    }
}