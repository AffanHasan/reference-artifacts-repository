package rc.qaportal.web.automation.aramark.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import rc.qaportal.web.automation.aramark.enums.AramarkEnvs;

/**
 * Created by Affan Hasan on 3/11/15.
 */
public class CommonUtilitiesTest {

    @Test
    public void test_for_user_login(){
//      Login User
        WebDriver wd = SuperUserLoginUtility.loginAsSuperUser(AramarkEnvs.DEV_2_CPS);
      Assert.assertTrue(CommonUtilities.isUserLoggedInToAramarkPortal(wd));
        wd.close();
    }
}