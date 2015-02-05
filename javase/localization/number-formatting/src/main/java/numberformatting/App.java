package numberformatting;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class App {
    
    public static void main( String[] args ){
        double amount = 100000.0034;
        int quantity =  100000;
        
        Locale [] locales = new Locale []{ 
                                            Locale.forLanguageTag("ja-*"), 
                                            Locale.CHINESE, 
                                            Locale.forLanguageTag("th"), Locale.ENGLISH,
                                            Locale.TAIWAN
                                         };
        
        NumberFormat formatter;
        for( Locale locale : locales ){
            formatter = NumberFormat.getNumberInstance(locale);
            System.console().printf("\n amount in %s: %s \n", locale.getDisplayLanguage(), formatter.format(amount));
            System.console().printf("\n quantity in %s: %s \n", locale.getDisplayLanguage(),  formatter.format(quantity));
        }
    }
}
