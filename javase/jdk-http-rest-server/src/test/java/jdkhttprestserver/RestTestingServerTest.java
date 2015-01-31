package jdkhttprestserver;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTestingServerTest{

    private final RestTestingServer httpServer;
    
    public RestTestingServerTest() {
        httpServer = new DefaultRestTestingServer();
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
        Application app = new DummyRestApp();
        httpServer.startServer(app);
        Assert.fail();
    }
    
    @Test
    public void server_should_by_default_start_at_localhost_port_8080(){
        Assert.fail();
    }
    
    @Test
    public void if_port_8080_is_unavailable_then_search_for_8081_or_onwards(){
        Assert.fail();
    }
    
}
