package listresourcebundle;

import java.util.ResourceBundle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListResourceBundleTest {
    
    @Test
    public void for_english_hello_should_be_hello(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("LocalizedObjects");
        Assert.assertEquals(resourceBundle.getObject("hello"), "Hello");
    }
}