/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Affan Hasan
 */
public class DefaultUserPasswordCredential implements UserPasswordCredential{
    
    private final String _password;

    public DefaultUserPasswordCredential(String password) {
        this._password = password;
    }

    @Override
    public String getPassword() {
        return this._password;
    }
}
