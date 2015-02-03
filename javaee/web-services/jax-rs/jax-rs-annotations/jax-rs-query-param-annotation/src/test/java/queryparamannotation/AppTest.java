package queryparamannotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import jdkhttprestserver.DefaultRestTestingServer;
import jdkhttprestserver.RestTestingServer;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
    
    private final RestTestingServer restTestingServer = new DefaultRestTestingServer();
    
    @Test
    public void testApp(){
        
        restTestingServer.startServer(new App());
        
        try {
            
            URL url = new URL("http://localhost:8080/rest");
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } catch (MalformedURLException e) {
            System.console().printf("\n %s \n", e.toString());
            Assert.fail();
        } 
        catch( IOException e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}