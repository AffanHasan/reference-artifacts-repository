/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbh;

import factories.Factories;
import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *
 * @author Affan Hasan
 */
public class CliCallBackHandler implements CallbackHandler{

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        UserEmailCallBack uecb = (UserEmailCallBack)callbacks[0];
        UserPasswordCallBack upcb = (UserPasswordCallBack)callbacks[1];
        
        uecb.setEmail(System.console().readLine(Factories.LocalizedTextFactory.getInstance().getString("provideEmail")));
        upcb.setPassword(new String(System.console().readPassword(Factories.LocalizedTextFactory.getInstance().getString("providePassword"))));
    }
    
}