package loginmodules;

import cbh.UserEmailCallBack;
import cbh.UserPasswordCallBack;
import factories.Factories;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import user.UserEmailPrincipal;
import user.UserPasswordCredential;

/**
 *
 * @author Affan Hasan
 */
public class DefaultLM implements LoginModule{
    
    private Subject _sub;
    private CallbackHandler _cbh;
    private UserEmailPrincipal _uep;
    private UserPasswordCredential _upc;
    
    private boolean _isloginSucceeeded;
    private boolean _isCommitSucceeeded;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this._sub = subject;
        this._cbh = callbackHandler;
    }

    @Override
    public boolean login() throws LoginException {
        Callback[] callBacks = {
                                new UserEmailCallBack(),
                                new UserPasswordCallBack()
                               };
        try {
            _cbh.handle(callBacks);
        } catch (IOException | UnsupportedCallbackException ex) {
            Logger.getLogger(DefaultLM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Verify the user identity
        UserEmailCallBack uecb = ((UserEmailCallBack) callBacks[0]);
        UserPasswordCallBack upcb = ((UserPasswordCallBack) callBacks[1]);
        
        String _userEmail = "blahblah@blahblah.com";
        String _userPassword = "opensessame";
        
        if(_userEmail.equals(uecb.getEmail()) && _userPassword.equals(upcb.getPassword())){
            this._uep = Factories.UserFactory.getUserEmailPrincipal(_userEmail);
            this._upc = Factories.UserFactory.getUserPasswordCredential(_userPassword);
            _isloginSucceeeded = true;
            return _isloginSucceeeded;
        }
        else{
            _isloginSucceeeded = false;
            return _isloginSucceeeded;
        }
    }

    @Override
    public boolean commit() throws LoginException {
        if(!_isloginSucceeeded)
            return false;
        
        this._sub.getPrincipals().add(this._uep);
        this._sub.getPrivateCredentials().add(_upc);
        this._isCommitSucceeeded = true;
        return _isCommitSucceeeded;
    }

    @Override
    public boolean abort() throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean logout() throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}