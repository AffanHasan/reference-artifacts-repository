package cbh;

import javax.security.auth.callback.Callback;

/**
 *
 * @author Affan Hasan
 */
public class UserEmailCallBack implements Callback{
    
    private String _email;
    
    void setEmail(String email){
        this._email = email;
    }
    
    String getEmail(){
        return _email;
    }
}
