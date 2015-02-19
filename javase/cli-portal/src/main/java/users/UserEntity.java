package users;

import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author Affan Hasan
 */
public abstract class UserEntity implements Serializable{
    
    private String name = "";
    
    private Locale locale = new Locale.Builder().build();

    public UserEntity() {
    }
    
    public UserEntity(String name, Locale locale){
        this.name = name;
        this.locale = locale;
    }
    
    public String getName(){
        return name;
    }
    
    public Locale getLocale(){
        return locale;
    }

}