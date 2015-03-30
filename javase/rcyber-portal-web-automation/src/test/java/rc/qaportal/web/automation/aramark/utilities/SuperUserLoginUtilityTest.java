package rc.qaportal.web.automation.aramark.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import rc.qaportal.web.automation.aramark.enums.AramarkEnvs;

/**
 * Created by Affan Hasan on 3/11/15.
 */
public class SuperUserLoginUtilityTest {

    @Test(enabled = false)
    public void dev2_super_user_credentials_for_cps(){
        String arr[] = SuperUserLoginUtility.getDev2SuperUserCredentialsECPS();
        Assert.assertEquals(arr[0], "super");//User Name
        Assert.assertEquals(arr[1], "cyber2004");//User Password
    }

    @Test(enabled = false)
    public void dev2_super_user_credentials_for_gespra(){
        String arr[] = SuperUserLoginUtility.getDev2SuperUserCredentialsGESPRA();
        Assert.assertEquals(arr[0], "super");//User Name
        Assert.assertEquals(arr[1], "cyber2004");//User Password
    }

    @Test(enabled = false)
    public void preqa_super_user_credentials_for_cps(){
        String arr[] = SuperUserLoginUtility.getPreQaSuperUserCredentialsCPS();
        Assert.assertEquals(arr[0], "cps_admin1");//User Name
        Assert.assertEquals(arr[1], "passw0rd");//User Password
    }

    @Test(enabled = false)
    public void preqa_super_user_credentials_for_gespra(){
        String arr[] = SuperUserLoginUtility.getPreQaSuperUserCredentialsGESPRA();
        Assert.assertEquals(arr[0], "cps_admin1");//User Name
        Assert.assertEquals(arr[1], "passw0rd");//User Password
    }

    @Test(enabled = false)
    public void login_super_dev2_cps(){
        WebDriver wd = SuperUserLoginUtility.loginAsSuperUser(AramarkEnvs.DEV_2_CPS);
        CommonUtilities.isUserLoggedInToAramarkPortal(wd);
        wd.close();
    }

    @Test(enabled = false)
    public void login_super_dev2_gespra(){
        WebDriver wd = SuperUserLoginUtility.loginAsSuperUser(AramarkEnvs.DEV_2_GESPRA);
        CommonUtilities.isUserLoggedInToAramarkPortal(wd);
        wd.close();
    }

    @Test(enabled = false)
    public void login_super_preqa_cps(){
        WebDriver wd = SuperUserLoginUtility.loginAsSuperUser(AramarkEnvs.PRE_QA_CPS);
        CommonUtilities.isUserLoggedInToAramarkPortal(wd);
        wd.close();
    }

    @Test(enabled = false)
    public void login_super_preqa_gespra(){
        WebDriver wd = SuperUserLoginUtility.loginAsSuperUser(AramarkEnvs.PRE_QA_GESPRA);
        CommonUtilities.isUserLoggedInToAramarkPortal(wd);
        wd.close();
    }
}