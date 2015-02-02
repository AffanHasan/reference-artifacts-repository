package availablelocales;

import java.text.DateFormat;
import java.util.Locale;

public class App{
    public static void main( String[] args ){
        
//        We can get all available suppored locales by JVM as follows
        
        System.console().printf("Using Locale.getAvailableLocales() \n");
//      To list all available locales use Locale.getAvailableLocales() method
        for( Locale locale : Locale.getAvailableLocales() ){
            System.console().printf("\n Locale :  %s\n", locale.toString());
        }
        
        System.console().printf("Using DateFormat.getAvailableLocales() \n");
//      To list all available locales use DateFormat.getAvailableLocales() method
        for( Locale locale : DateFormat.getAvailableLocales() ){
            System.console().printf("\n Locale :  %s\n", locale.toString());
        }
        
        System.console().printf("Displaying the Readable Locale Display Name \n");
//      To list all available locales use DateFormat.getAvailableLocales() method
        for( Locale locale : Locale.getAvailableLocales() ){
            System.console().printf("\n Locale display name :  %s\n", locale.getDisplayName());
        }
    }
}
