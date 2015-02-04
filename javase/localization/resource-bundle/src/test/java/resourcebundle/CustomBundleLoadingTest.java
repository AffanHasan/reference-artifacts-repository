package resourcebundle;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * To
 * @author Affan Hasan
 */
public class CustomBundleLoadingTest {
    
    private class CustomResourceBundleLoader extends ResourceBundle.Control{
        
        private final Locale userLocale;

        CustomResourceBundleLoader( Locale userLocale ){
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
    
    @Test
    public void custom_locale_loading_for_saudi_arab(){
        System.out.printf("\n inside 'custom_locale_loading_for_saudi_arab' \n");
        Locale userLocale = new Locale("ar", "KSA");//An Arabic user of Saudi Arabia
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Localized", new CustomResourceBundleLoader(userLocale));
//        For an Arabic User Of Saudi Arabia should display arabic message
        Assert.assertEquals(resourceBundle.getString("hello"), "مرحبا");
    }
    
    @Test
    public void custom_locale_loading_for_iraqi_arab_user(){
        Locale userLocale = Locale.forLanguageTag("ar_IRQ");//An Arabic user of Iraq
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Localized", new CustomResourceBundleLoader(userLocale));
//        For a Non Saudi Arab user should display english message
        Assert.assertEquals(resourceBundle.getString("hello"), "Hello");
    }
    
    @Test
    public void custom_locale_loading_for_bahraini_arab_user(){
        Locale userLocale = Locale.forLanguageTag("ar_BAH");//An Arabic user of Bahrain
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Localized", new CustomResourceBundleLoader(userLocale));
//        For a Non Saudi Arab user should display english message
        Assert.assertEquals(resourceBundle.getString("hello"), "Hello");
    }
}