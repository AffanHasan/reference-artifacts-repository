package jdkhttprestserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.Uri;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestTestingServerTest{

    private final RestTestingServer httpServer;
    
    private final Application dummyRestApp = new DummyRestApp();
    
    public RestTestingServerTest() {
        httpServer = new DefaultRestTestingServer();
    }
    
    @BeforeTest
    public void beforeTest(){
    }
    
    @ApplicationPath("/test")
    private class DummyRestApp extends Application{

        @Override
        public Set<Class<?>> getClasses() {
            Set<Class<?>> services = new LinkedHashSet<Class<?>>();
            services.add(DummyRestService.class);
            return services;
        }
        
        @Path("/")
        private class DummyRestService{
            
            @GET
            @Produces("text/html")
            private String get(){
                return "Server is up and running";
            }
        }
    }
    
    @Test
    public void server_should_start_on_localhost_8080_when_rest_Application_is_passed_to_it(){
        httpServer.startServer(dummyRestApp);
        URL url = null;
        BufferedReader bufferedReader = null;
        try{
            url = new URL("http://localhost:8080");
            URLConnection httpConnection = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            String chunk = null;
            while((chunk = bufferedReader.readLine()) != null ){
                Assert.assertEquals(chunk, "Server is running");
            }
            bufferedReader.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(RestTestingServerTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }catch (IOException ex) {
            Logger.getLogger(RestTestingServerTest.class.getName()).log(Level.SEVERE, null, ex);
            Assert.fail();
        }finally{
            httpServer.stopServer();
        }
    }
    
    @Test
    public void if_port_8080_is_unavailable_then_search_for_8081_or_onwards(){
//      Starting the server which will occupy the 8080 port
        httpServer.startServer(dummyRestApp);
        
        {
//            Another rest application
            @ApplicationPath("/test2")
            class AnotherRestApp extends DummyRestApp{

            }
            
            URL url = null;
            BufferedReader bufferedReader = null;
//          Starting another instance of RestTesting Server wich should ocupy port 8081
            RestTestingServer server2 = new DefaultRestTestingServer();
            try{
                URLConnection httpConnection;
//                Verifying the port 8080 is occupied
                url = new URL("http://localhost:8080");
                httpConnection = url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                String chunk = null;
                while((chunk = bufferedReader.readLine()) != null ){
                    Assert.assertEquals(chunk, "Server is running");
                }
                bufferedReader.close();
                
                try{
//                  Now verifying the port 8081 is not occupied
                    url = new URL("http://localhost:8081");
                    httpConnection = url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                    Assert.fail();
                }catch( Exception e ){
                    //If here it means that port 8081 is not in use
                }
//              Now deploying the second application
                server2.startServer(new AnotherRestApp());
//              Now verifying the port 8081 is occupied
                url = new URL("http://localhost:8081");
                httpConnection = url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                chunk = null;
                while((chunk = bufferedReader.readLine()) != null ){
                    Assert.assertEquals(chunk, "Server is running");
                }
                bufferedReader.close();
            } catch (MalformedURLException ex) {
                Logger.getLogger(RestTestingServerTest.class.getName()).log(Level.SEVERE, null, ex);
                Assert.fail();
            }catch (IOException ex) {
                Logger.getLogger(RestTestingServerTest.class.getName()).log(Level.SEVERE, null, ex);
                Assert.fail();
            }finally{
                server2.stopServer();
            }
            
        }
        
        httpServer.stopServer();
    }
    
}