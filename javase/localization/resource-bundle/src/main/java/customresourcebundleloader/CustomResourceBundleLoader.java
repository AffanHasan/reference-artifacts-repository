/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customresourcebundleloader;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

    
public class CustomResourceBundleLoader extends ResourceBundle.Control{

    private final Locale userLocale;

    public CustomResourceBundleLoader( Locale userLocale ){
        this.userLocale = userLocale;
    }

    @Override
    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
//          For an Arabic user of Saudi Arabia
        if(userLocale.getCountry().equals("KSA") && userLocale.getLanguage().equals("ar")){
            System.out.printf("\n Inside getCandidateLocales method \n");
            return Arrays.asList(new Locale[]
            { 
                userLocale,
                Locale.ROOT 
            });
        }
//          For all other users
        else {
            return super.getCandidateLocales(baseName, locale); //To change body of generated methods, choose Tools | Templates.
        }
    }
}