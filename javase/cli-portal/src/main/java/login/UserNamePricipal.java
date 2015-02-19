/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.security.Principal;

/**
 *
 * @author Affan Hasan
 */
public class UserNamePricipal implements Principal {
    
    private final String name;

    public UserNamePricipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;                
    }
    
}
