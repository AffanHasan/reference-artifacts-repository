package persistence;

import factories.Factory;
import java.util.Locale;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import users.UserEntity;

/**
 *
 * @author Affan Hasan
 */
public class PersistenceEngineTest {
    
    private PersistenceEngine pe;
    
    private final UserEntity u1 = Factory.UserEntityFactory.
            getInstance("Fahad Al Falasi", Locale.forLanguageTag("ar-SA") );
    
    @BeforeTest
    public void bt(){
        pe = Factory.PersistenceFactory.getInstance();
    }
    
    @AfterTest
    public void at(){
        pe = null;
    }
    
    @Test
    public void able_to_save_user_entity(){
        pe.persistUser(u1);
        UserEntity entity = pe.searchUser(u1.getName());
        Assert.assertEquals(entity, u1);
    }
    
    @Test
    public void able_to_search_user_entity_by_name(){
        pe.persistUser(u1);
        UserEntity entity = pe.searchUser(u1.getName());
        Assert.assertEquals(entity, u1);
    }
}