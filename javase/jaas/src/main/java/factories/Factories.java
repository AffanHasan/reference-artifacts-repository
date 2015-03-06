package factories;

import cbh.CliCallBackHandler;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import user.DefaultUserEmailPrincipal;
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
            return new DefaultUserEmailPrincipal(email);
        }
        
        public static UserPasswordCredential getUserPasswordCredential(String password){
            return new DefaultUserPasswordCredential(password);
        }
    }
    
    public static class LCFactory{
        
        public static LoginContext getInstance(String lm, 
                CallbackHandler cbh){
            try {
                Configuration.getConfiguration();
                return new LoginContext(lm, cbh);
            } catch (LoginException ex) {
                System.out.println("Inside exception");
                Logger.getLogger(Factories.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
    
    public interface Flyer{
        
        public static String identifyMySelf(){
            return "";
        }
    }
    
    public static class CBHFactory implements Flyer{
        
        public static CliCallBackHandler getCliLoginCallBackHandler(){
            return new CliCallBackHandler();
        }
    }
    
    public static class LocalizedTextFactory{
        
        private static final String _bundleName = "jaas";
        
        public static ResourceBundle getInstance(){
            return ResourceBundle.getBundle(_bundleName);
        }
    }
}