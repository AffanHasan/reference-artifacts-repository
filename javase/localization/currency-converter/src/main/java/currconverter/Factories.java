package currconverter;

import java.util.Locale;

/**
 *
 * @author Affan Hasan
 */
public class Factories {
    
    public static class ConverterFactory{

        public static CurrencyConverter getInstance() {
            return new DefaultCurrencyConverter();
        }
        
    }
    
    public static class CurrencyAmountFactory{

        public static CurrencyAmount getInstance(double amount, Locale locale) {
            return new DefaultCurrencyAmount(amount, locale);
        }
        
    }
    
}