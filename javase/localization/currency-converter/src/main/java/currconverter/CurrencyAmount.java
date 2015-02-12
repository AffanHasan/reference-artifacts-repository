package currconverter;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Represents a currency amount for a particular locale
 * @author Affan Hasan
 */
public abstract class CurrencyAmount {
    
    private final Locale _locale;
    
    private final double _amount;

    public CurrencyAmount(double amount, Locale locale) {
        this._locale = locale;
       
        this._amount = amount;
    }
    
    public double getAmount(){
        return _amount;
    }
    
    public Locale getCurrencyLocale(){
        return _locale;
    }
    
    public String getCurrencySymbol(){
        return NumberFormat.getCurrencyInstance(_locale).getCurrency().getSymbol(_locale);
    }
    
    public String getCurrencyCode(){
        return NumberFormat.getCurrencyInstance(_locale).getCurrency().getCurrencyCode();
    }
    
    @Override
    public String toString(){
        return NumberFormat.getCurrencyInstance(_locale).format(_amount);
    }
}