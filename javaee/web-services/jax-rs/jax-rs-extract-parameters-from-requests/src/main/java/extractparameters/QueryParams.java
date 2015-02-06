package extractparameters;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Affan Hasan
 */

@Path("queryparams")
public class QueryParams {
    
    @GET
    public String method1( @QueryParam("param1") String param ){
        return param;
    }
}
