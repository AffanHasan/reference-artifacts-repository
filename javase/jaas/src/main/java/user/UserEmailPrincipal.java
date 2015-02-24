/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.security.Principal;

/**
 *
 * @author root
 */
public class UserEmailPrincipal implements Principal{
    
    
    private final String _email;

    public UserEmailPrincipal(String email) {
        this._email = email;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
