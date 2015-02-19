package users;

import java.util.Locale;

/**
 *
 * @author Affan Hasan
 */
public class DefaultUserEntity extends UserEntity {

    public DefaultUserEntity() {
    }
    
    public DefaultUserEntity(String name, Locale locale) {
        super(name, locale);
    }
}