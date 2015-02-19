package factories;

import java.util.Locale;
import persistence.FileBasedPersistenceEngine;
import persistence.PersistenceEngine;
import users.DefaultUserEntity;
import users.UserEntity;

/**
 *
 * @author Affan Hasan
 */
public class Factory {
    
    public static class UserEntityFactory{
        
        public static UserEntity getInstance(){
            return new DefaultUserEntity();
        }
        
        public static UserEntity getInstance(String name, Locale locale){
            return new DefaultUserEntity(name, locale);
        }
    }
    
    public static class PersistenceFactory{
        
        public static PersistenceEngine getInstance(){
            return new FileBasedPersistenceEngine();
        }
    }
}
