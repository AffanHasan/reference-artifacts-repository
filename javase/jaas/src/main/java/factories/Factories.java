package factories;

import cbh.CliCallBackHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import user.DefaultUserPasswordCredential;
import user.UserEmailPrincipal;
import user.UserPasswordCredential;

/**
 *
 * @author Affan Hasan
 */
public class Factories {
    
    public static class UserFactory{
        
        public static UserEmailPrincipal getUserEmailPrincipal(String email){
            return new UserEmailPrincipal(email);
        }
        
        public static UserPasswordCredential getUserPasswordCredential(String password){
            return new DefaultUserPasswordCredential(password);
        }
    }
    
    public static class LCFactory{
        
        public static LoginContext getInstance(String lm, 
                CallbackHandler cbh){
            try {
                return new LoginContext(lm, cbh);
            } catch (LoginException ex) {
                Logger.getLogger(Factories.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
    
    public static class CBHFactory{
        
        public static CliCallBackHandler getCliLoginCallBackHandler(){
            return new CliCallBackHandler();
        }
    }
}