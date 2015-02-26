/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbh;

import javax.security.auth.callback.Callback;

/**
 *
 * @author Affan Hasan
 */
public class UserPasswordCallBack implements Callback{
    
    private String _password;
    
    public void setPassword(String password){
        this._password = password;
    }
    
    public String getPassword(){
        return _password;
    }
}
