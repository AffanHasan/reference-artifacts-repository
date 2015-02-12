package currconverter;

import java.util.Locale;

/**
 *
 * @author Affan Hasan
 */
public interface CurrencyConverter {
    
    public CurrencyAmount convert(CurrencyAmount amountToConvert, Locale targetLocale);
}