package jaas;

import factories.Factories;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.UserEmailPrincipal;
import user.UserPasswordCredential;

public class Cli_Login_Test {
    
    private final LoginContext lc;
    
    {
//     System.setProperty("java.security.login.config.url.1", "jaas.config");
        lc = Factories.LCFactory.getInstance("DefaultLM", 
            Factories.CBHFactory.getCliLoginCallBackHandler());    
    }
    
    private Subject sub;
    
    @BeforeClass
    public void initFixtures(){
    }
    
    @Test
    public void login(){
        String userEmailStr = "blahblah@blahblah.com";
        String userPasswordStr = "opensessame";
        UserEmailPrincipal userEmail = 
                Factories.UserFactory.getUserEmailPrincipal(userEmailStr);
        UserPasswordCredential userPassword = 
                Factories.UserFactory.getUserPasswordCredential(userPasswordStr);
        
        try {
            lc.login();
        } catch (LoginException ex) {
            Logger.getLogger(Cli_Login_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        sub = lc.getSubject();
        System.out.println("Unser _sub " + sub.getPrincipals().size());
        Assert.assertTrue(sub.getPrincipals(UserEmailPrincipal.class).size() == 1);
        
        for(UserEmailPrincipal obj : sub.getPrincipals(UserEmailPrincipal.class)){
            Assert.assertTrue(obj.getEmail().equals(userEmailStr));
        }
        
        Assert.assertTrue(sub.getPrivateCredentials(UserPasswordCredential.class).size() == 1);
        
        for(UserPasswordCredential obj : sub.getPrivateCredentials(UserPasswordCredential.class)){
            Assert.assertTrue(obj.getPassword().equals(userPasswordStr));
        }
    }
}