package queryparamannotation;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new LinkedHashSet<Class<?>>();
        set.add(Service1.class);
        return set;
    }
}
