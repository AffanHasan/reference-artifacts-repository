package specs.cli.basiclogin;

import factories.Factories;
import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import mockit.Expectations;
import mockit.Mocked;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.UserEmailPrincipal;
import user.UserPasswordCredential;

public class Cli_Login_Test {

    private final LoginContext _lc;

    {
        _lc = Factories.LCFactory.getInstance("DefaultLM",
                Factories.CBHFactory.getCliLoginCallBackHandler());
    }

    private Subject _sub;

    private final String _userEmailStr = "blahblah@blahblah.com";
    private final String _userPasswordStr = "opensessame";

    @BeforeClass
    public void initFixtures(){
    }

    private void mockSystemAndConsoleClassesBehavior(@Mocked Console _console, @Mocked System _system){

        new Expectations() {
            {
                System.console();
                result = _console;
            }
        };

        new Expectations() {
            {
                _console.readLine(Factories.LocalizedTextFactory.getInstance().getString("provideEmail"));
                result = _userEmailStr;
            }
        };

        new Expectations ()  {
            {
                _console.readPassword(Factories.LocalizedTextFactory.getInstance().getString("providePassword"));
                result = _userPasswordStr.toCharArray();
            }
        };
    }
    
    /**
     * A basic login test for default locale user
     * @param _console
     * @param _system 
     */
    @Test
    public void basic_login(@Mocked Console _console, @Mocked System _system){
        
        mockSystemAndConsoleClassesBehavior(_console, _system);
        
        try {
            _lc.login();
        } catch (LoginException ex) {
            Logger.getLogger(Cli_Login_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
//      Getting Subject
        _sub = _lc.getSubject();
//      Assert that subject only possess one email address
        Assert.assertTrue(_sub.getPrincipals(UserEmailPrincipal.class).size() == 1);
//      Assert That Subject contains correct email address
        for(UserEmailPrincipal obj : _sub.getPrincipals(UserEmailPrincipal.class)){
            Assert.assertTrue(obj.getEmail().equals(_userEmailStr));
        }
//      Assert That User Has Only 1 UserPasswordCredential
        Assert.assertTrue(_sub.getPrivateCredentials(UserPasswordCredential.class).size() == 1);
//      Assert That Subject Contains Correct Password
        for(UserPasswordCredential obj : _sub.getPrivateCredentials(UserPasswordCredential.class)){
            Assert.assertTrue(obj.getPassword().equals(_userPasswordStr));
        }
    }
    
    @Test(dependsOnMethods = {"basic_login"})
    public void basic_authorization(){
//        _sub.do
    }
}