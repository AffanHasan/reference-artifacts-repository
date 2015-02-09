package extractparameters;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import sun.misc.IOUtils;

/**
 *
 * @author Affan Hasan
 */
@Path("queryparams")
public class QueryParams {

    @GET
    @Path("addtwonumbers")
    @Produces("text/plain")
    public int addTwoNumbers( @QueryParam("firstnumber") int firstNumber, @QueryParam("secondnumber") int secondNumber ){
        return firstNumber + secondNumber;
    }
    
    @POST
    @Path("blob")
    @Consumes("application/x-www-form-urlencoded")
    public String postBlob(InputStream is){
        byte [] arr = new byte[2000];
        try {
            is.read(arr);
            System.out.println(new String(arr));
        } catch (IOException ex) {
            Logger.getLogger(QueryParams.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "response";
    }
    
    @GET
    @Path("/getinputstreamtest")
    public String getMethodSupportInputStreams(InputStream is){
        byte [] arr = new byte[2000];
        try {
            is.read(arr);
            System.out.println(new String(arr));
        } catch (IOException ex) {
            Logger.getLogger(QueryParams.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "response";
    }
}