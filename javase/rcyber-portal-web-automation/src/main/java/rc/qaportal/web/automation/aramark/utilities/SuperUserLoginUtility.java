package rc.qaportal.web.automation.aramark.utilities;

import org.openqa.selenium.WebDriver;
import rc.qaportal.web.automation.aramark.enums.AramarkEnvs;

/**
 * Created by Affan Hasan on 3/12/15.
 */
public class SuperUserLoginUtility {

    private static final String [] _dev2SuperUserCredentials = new String[]{ "super", "cyber2004" };

    private static final String [] _preQSuperUserCredentials = new String[]{ "cps_admin1", "passw0rd" };

    public static String[] getDev2SuperUserCredentialsECPS(){
        return _dev2SuperUserCredentials;
    }

    public static String[] getDev2SuperUserCredentialsGESPRA(){
        return _dev2SuperUserCredentials;
    }

    public static String[] getPreQaSuperUserCredentialsCPS(){
        return _preQSuperUserCredentials;
    }

    public static String[] getPreQaSuperUserCredentialsGESPRA(){
        return _preQSuperUserCredentials;
    }

    public static WebDriver loginAsSuperUser(AramarkEnvs env){
        return UserLoginUtility.loginToAramarkPortal(env, _dev2SuperUserCredentials);
    }
}