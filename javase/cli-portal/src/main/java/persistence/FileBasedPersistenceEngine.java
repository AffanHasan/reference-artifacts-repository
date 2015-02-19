package persistence;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import users.UserEntity;

/**
 *
 * @author Affan Hasan
 */
public class FileBasedPersistenceEngine implements PersistenceEngine, Serializable{
    
    private class DB{

        private final List<UserEntity> entitiesList = new ArrayList<>();

        void addUser(UserEntity entity){
            this.entitiesList.add(entity);
        }

        UserEntity getUser(String name){
            for( UserEntity entity : this.entitiesList ){
                if(name.equals(entity.getName()))
                    return entity;
            }
            return null;
        }
    }
    
    private final DB db = new DB();

    @Override
    public void persistUser(UserEntity entity) {
        db.addUser(entity);//Add user in memory
//      Persist the DB to  file
        try( ObjectOutputStream oos 
                = new ObjectOutputStream(new FileOutputStream("db.db"));){
            
            oos.writeObject(db);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found");
        } catch (IOException ex) {
            System.err.println("Some IO Exception");
        }        
    }

    @Override
    public UserEntity searchUser(String name) {
        return db.getUser(name);
    }

}