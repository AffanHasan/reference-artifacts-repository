package login;

import factories.Factory;
import java.security.Principal;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import mockit.Expectations;
import org.testng.Assert;
import org.testng.annotations.Test;
import persistence.PersistenceEngine;

/**
 *
 * @author Affan Hasan
 */
public class LoginModuleTest {
    
    private final PersistenceEngine pe = Factory.PersistenceFactory.getInstance();
    
    @Test
    public void login_for_KSA_arabic_user(){
        String name = "Fahad Al Falasi";
//      Mocking persistence engine
        new Expectations() {
            {
                pe.searchUser(name);
                result = Factory.UserEntityFactory.
                        getInstance("Fahad AL Falasi", Locale.forLanguageTag("ar-SA"));
            }
        };
        
        Subject subject = new  Subject();
        LoginContext lc = null;
        try {
            lc = new LoginContext("LM", subject, new GUICallBackHandler());
            lc.login();
            
//          Verify that the user is logged in
//            By Checking User Name
            for( Principal principal :  lc.getSubject().getPrincipals(UserNamePricipal.class) ){
                Assert.assertEquals(principal.getName(), name);
            }
        } catch (LoginException ex) {
            Logger.getLogger(LoginModuleTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail("Fail to login KSA ARAB");
        }
        
    }
}