package persistence;

import users.UserEntity;

/**
 *
 * @author Affan Hasn
 */
public interface PersistenceEngine {
    
    public void persistUser(UserEntity entity);
    
    public UserEntity searchUser(String name);
    
}
