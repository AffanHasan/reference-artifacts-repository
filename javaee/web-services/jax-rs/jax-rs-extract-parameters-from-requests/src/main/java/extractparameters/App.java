package extractparameters;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// http://localhost:8080/extractparamsrestapp/queryparams/addtwonumbers?firstnumber=1&secondnumber=2
@ApplicationPath("extractparamsrestapp")
public class App extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new LinkedHashSet<Class<?>>();
        set.add(QueryParams.class);
        return set;
    }
}