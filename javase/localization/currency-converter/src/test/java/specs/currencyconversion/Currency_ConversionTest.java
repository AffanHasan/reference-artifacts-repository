package specs.currencyconversion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import currconverter.CurrencyAmount;
import currconverter.CurrencyConverter;
import currconverter.Factories;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Describes the types of users
 * @author Affan Hasan
 */
public class Currency_ConversionTest {
    
    private static class ConverterFixture{
    
        static double getRate(String baseCurrency, String targetCurrency){
            double rate = 0.0;
            try {
                URL url = new URL("http://jsonrates.com/get/?from="+ baseCurrency +"&to="+targetCurrency);
                URLConnection urlConnection = url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String response = null;
                while( (response = br.readLine()) != null ){
                    JsonObject obj = (new Gson()).fromJson(response, JsonObject.class);
                    rate = obj.get("rate").getAsDouble();
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(Currency_ConversionTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch(IOException e){
                Logger.getLogger(Currency_ConversionTest.class.getName()).log(Level.SEVERE, null, e);
            }
            return rate;
        }
    }
    
    private final CurrencyConverter _converter = Factories.ConverterFactory.getInstance();
    
    @Test
    public void KSA_arabic_user_should_get_converted_values_in_saudi_riyal(){
        Locale saudiLocale = Locale.forLanguageTag("ar-SA");
        String saudiRiyalCurrSymbol = NumberFormat.getCurrencyInstance(saudiLocale).getCurrency().getSymbol(saudiLocale);
        
        CurrencyAmount usDollars = Factories.CurrencyAmountFactory.getInstance(1.0, Locale.US);
        CurrencyAmount convertedAmount = _converter.convert(usDollars, saudiLocale);
        double rate = ConverterFixture.getRate("USD", "SAR");
//      Assertions
        Assert.assertEquals(saudiRiyalCurrSymbol, convertedAmount.getCurrencySymbol());
        Assert.assertEquals(rate, convertedAmount.getAmount());
        Assert.assertEquals(saudiLocale, convertedAmount.getCurrencyLocale());
        Assert.assertEquals(NumberFormat.getCurrencyInstance(saudiLocale).format(rate), convertedAmount.toString());
    }
    
    @Test
    public void USA_english_user_should_get_converted_values_in_us_dollars(){
        Assert.fail();
    }
    
    @Test
    public void UK_english_user_should_get_converted_values_in_pounds(){
        Assert.fail();
    }
    
    @Test
    public void france_french_user_should_get_converted_values_in_euro(){
        Assert.fail();
    }
    
    @Test
    public void german_german_speaking_user_should_get_converted_values_in_euro(){
        Assert.fail();
    }
    
}