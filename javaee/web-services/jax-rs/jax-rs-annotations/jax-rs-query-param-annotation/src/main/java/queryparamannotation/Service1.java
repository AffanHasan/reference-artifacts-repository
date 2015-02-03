package queryparamannotation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class Service1 {
    
    @GET
    public String method1(){
        System.console().printf(" \n matrix param is : \n ");
        return "";
    }
}
