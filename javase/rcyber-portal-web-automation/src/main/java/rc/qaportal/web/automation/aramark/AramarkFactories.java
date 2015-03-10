package rc.qaportal.web.automation.aramark;

import rc.qaportal.web.automation.aramark.usercreation.AramarkUserCreator;
import rc.qaportal.web.automation.aramark.usercreation.DefaultUserCreator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Affan Hasan on 3/10/15.
 */
public class AramarkFactories {

    public interface FactoryInterface{

        public static Object getInstance(){
            throw new NotImplementedException();
        }
    }

    public static class UserCreatorFactory implements FactoryInterface{

        public static AramarkUserCreator getInstance(){
            return new DefaultUserCreator();
        }
    }
}
