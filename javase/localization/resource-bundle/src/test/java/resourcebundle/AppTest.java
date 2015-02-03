package resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    
    private final String resourceBundleBaseName = "Localized";
    
    @Test
    public void hello_for_english(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundleBaseName, Locale.ENGLISH);
        Assert.assertEquals(resourceBundle.getString("hello"), "Hello");
    }
    
    @Test
    public void hello_for_arabic(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundleBaseName, Locale.forLanguageTag("ar"));
        Assert.assertEquals(resourceBundle.getString("hello"), "مرحبا");
    }
    
    @Test
    public void hello_for_german(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundleBaseName, Locale.GERMAN);
        Assert.assertEquals(resourceBundle.getString("hello"), "hallo");
    }
    
    @Test
    public void hello_for_default_should_be_Hello(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundleBaseName, Locale.KOREA);
        Assert.assertEquals(resourceBundle.getString("hello"), "Hello");
    }
}
