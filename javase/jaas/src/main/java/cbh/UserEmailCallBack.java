package cbh;

import javax.security.auth.callback.Callback;

/**
 *
 * @author Affan Hasan
 */
public class UserEmailCallBack implements Callback{
    
    private String _email;
    
    public void setEmail(String email){
        this._email = email;
    }
    
    public String getEmail(){
        return _email;
    }
}