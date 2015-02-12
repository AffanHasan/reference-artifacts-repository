package currconverter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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

/**
 *
 * @author Affan Hasan
 */
public class DefaultCurrencyConverter implements CurrencyConverter{

    @Override
    public CurrencyAmount convert(CurrencyAmount amountToConvert, Locale targetLocale) {
        double rate = 0.0;
        CurrencyAmount amount = null;
            try {
                URL url = new URL("http://jsonrates.com/get/?from="+ amountToConvert.getCurrencyCode()+"&to="+NumberFormat.getCurrencyInstance(targetLocale).getCurrency().getCurrencyCode());
                URLConnection urlConnection = url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String response = null;
                while( (response = br.readLine()) != null ){
                    JsonObject obj = (new Gson()).fromJson(response, JsonObject.class);
                    rate = obj.get("rate").getAsDouble();
                    amount = Factories.CurrencyAmountFactory.getInstance(rate, targetLocale);
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(DefaultCurrencyConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch(IOException e){
                Logger.getLogger(DefaultCurrencyConverter.class.getName()).log(Level.SEVERE, null, e);
            }
            return amount;
    }
    
}