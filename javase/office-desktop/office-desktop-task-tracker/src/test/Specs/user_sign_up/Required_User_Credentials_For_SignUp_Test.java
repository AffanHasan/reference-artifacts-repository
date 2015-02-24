package user_sign_up;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Affan Hasan
 */
public class Required_User_Credentials_For_SignUp_Test {
    
    private Subject _subject;
    
    private final LoginContext lc = Factories.LCFactory.getInstance();

    @BeforeClass
    public void getUserCredentials(){
        try {
            lc.login();
        } catch (LoginException ex) {
            Logger.getLogger(Required_User_Credentials_For_SignUp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this._subject = lc.getSubject();
    }
    
    @Test
    public void must_have_a_name(){
        Assert.assertTrue(
                _subject.getPrincipals(UserNamePrincipal.class).size() == 1);
    }
    
    @Test
    public void must_have_a_locale(){
        Assert.assertTrue(
                _subject.getPrincipals(UserLocalePrincipal.class).size() == 1);
    }
    
    @Test
    public void must_have_an_email(){
        Assert.assertTrue(
                _subject.getPrincipals(UserEmailPrincipal.class).size() == 1);
    }
    
    @AfterClass
    public void tearDownClass(){
        try {
            lc.logout();
        } catch (LoginException ex) {
            Logger.getLogger(Required_User_Credentials_For_SignUp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}