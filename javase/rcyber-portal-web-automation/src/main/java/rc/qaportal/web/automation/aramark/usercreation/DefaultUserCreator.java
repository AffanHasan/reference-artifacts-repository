package rc.qaportal.web.automation.aramark.usercreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rc.qaportal.web.automation.aramark.enums.AramarkEnvs;
import selcommns.Factories;

/**
 * Created by Affan Hasan on 3/10/15.
 */
public class DefaultUserCreator implements AramarkUserCreator {
    @Override
    public void createECPSMenuAdmin1(String userName, String userPassword) {

    }

    @Override
    public void createUser(AramarkEnvs env, Object[] credentials) {
//        switch (env){
//            case DEV_2_CPS:
//                WebDriver wd = Factories.WebDriverFactory.getInstance();
//                wd.get(getURL(env));
//
//                WebElement e = wd.findElement(By.id("sizing_myprofile"));
//                if(!e.getText().isEmpty()){
//
//                }
//                break;
//        }
    }

    @Override
    public String getURL(AramarkEnvs aramarkEnv) {
        switch (aramarkEnv){
            case DEV_2_CPS:
                return "http://dev2-portal.ecps.ca/wps/portal/eCPS/";
            case DEV_2_GESPRA:
                return "http://dev2-portal.ecps.ca/wps/portal/GESPRA/";
            case PRE_QA_CPS:
                return "https://preqa-portal.ecps.ca/wps/portal/eCPS/";
            case PRE_QA_GESPRA:
                return "https://preqa-portal.ecps.ca/wps/portal/GESPRA/";
            default:
                return null;
        }
    }
}