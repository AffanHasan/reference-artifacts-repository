package regexpatterntester;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Affan Hasan on 3/8/15.
 */
public class Factories {

    public interface FactoryInterface{

        public static Object getInstance(){
            return new NotImplementedException();
        }
    }

    public static class PatternMatcherFactory implements FactoryInterface{

        public static PatternMatcher getInstance(){
            return new DefaultPatternMatcher();
        }
    }
}
