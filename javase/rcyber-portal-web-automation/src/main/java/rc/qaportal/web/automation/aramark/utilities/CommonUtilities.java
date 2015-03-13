package rc.qaportal.web.automation.aramark.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Affan Hasan on 3/12/15.
 */
public class CommonUtilities {

    public static boolean isUserLoggedInToAramarkPortal(WebDriver wd){
        if( wd.findElement(By.id("sizing_logout")).getText().length() > 0 )
            return true;
        else
            return false;
    }
}