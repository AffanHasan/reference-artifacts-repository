package users;

import factories.Factory;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Affan Hasan
 */
public class UserEntityTest {
    
    private final UserEntity entity;

    public UserEntityTest() {
        this.entity = Factory.UserEntityFactory.getInstance();
    }
    
    @Test
    public void entity_must_have_a_name(){
        Assert.assertTrue(entity.getName() instanceof String);
    }
    
    @Test
    public void entity_must_have_a_locale(){
        Assert.assertTrue(entity.getLocale() instanceof Locale);
    }
    
    @Test
    public void entity_must_be_serializable(){
        Assert.assertTrue(entity instanceof Serializable);
    }
    
    @Test
    public void should_be_able_to_create_entity_with_name_and_locale(){
        Assert.assertNotNull( 
                Factory.UserEntityFactory.getInstance("Fahad Al Falasi"
                , Locale.forLanguageTag("ar-SA")) );
    }
}