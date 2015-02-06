package extractparameters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.ws.rs.ApplicationPath;
import jdkhttprestserver.DefaultRestTestingServer;
import jdkhttprestserver.RestTestingServer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    
    @Test
    public void extract_parameter_from_query_param(){
        try(RestTestingServer httpServer = new DefaultRestTestingServer()){//Since server is java.lang.AutoCloseable
            int portNumber = httpServer.startServer(new App());
            String appName = App.class.getAnnotation(ApplicationPath.class).value();
            String param1 = "param1Value";
            URL url = new URL("http://localhost:"+portNumber+ "/" + appName + "/queryparams" + "?param1="+param1);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            String message = null;
            while( (message = bufferedReader.readLine()) != null ){
                Assert.assertEquals(message, param1);
            }
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
}