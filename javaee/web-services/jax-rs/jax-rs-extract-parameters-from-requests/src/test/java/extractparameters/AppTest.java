package extractparameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import jdkhttprestserver.DefaultRestTestingServer;
import jdkhttprestserver.RestTestingServer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    
    @Test
    public void query_params_add_two_numbers(){
        try(RestTestingServer httpServer = new DefaultRestTestingServer()){//Since server is java.lang.AutoCloseable
            int portNumber = httpServer.startServer(new App());
            String appName = App.class.getAnnotation(ApplicationPath.class).value();
            String param1 = "1";
            String param2 = "2";
            String result = "3";
            
            URL url = new URL("http://localhost:"+portNumber+ "/" + appName + "/queryparams/addtwonumbers" + "?firstnumber=" + param1 + "&secondnumber=" + param2);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String response = null;
            while( (response = bufferedReader.readLine()) != null ){
//                Assert that result is 3
                Assert.assertEquals(response, result);
            }
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void sending_a_blob_as_query_param(){
        
//      Our sample object
        class Obj1 implements Serializable{

            private final String message = "Partial obedience is no obedience";

            @Override
            public String toString() {
                return message;
            }
        }

        try (RestTestingServer rts = new DefaultRestTestingServer()){
            int port = rts.startServer(new App());
            URL url = new  URL("http://localhost:" + port + "/" + 
                    App.class.getAnnotation(ApplicationPath.class).value()
                    + "/queryparams/blob" );
            URLConnection urlConnection = url.openConnection();
            
            urlConnection.setDoOutput(true);
            OutputStreamWriter oow = new OutputStreamWriter(urlConnection.getOutputStream());
            oow.write("hallowelt");
            oow.close();
            
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String response = null;
            while( (response = bufferedReader.readLine()) != null ){
                System.out.println(response);
            }
        } catch (IOException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e){
            Assert.fail(e.toString());
        }
    }
    
    @Test
    public void you_cannot_write_to_an_input_stream_to_an_http_get_method(){
        try(RestTestingServer rts = new DefaultRestTestingServer()){
            int port = rts.startServer(new App());
            URL url = new URL("http://localhost:" + port + "/" + App.class.getAnnotation(ApplicationPath.class).value() + "/queryparams" + "/getinputstreamtest");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write("Hallo! was ist das?");
            conn.getInputStream();
        }catch(Exception e){
            return;
        }
        Assert.fail();
    }
}