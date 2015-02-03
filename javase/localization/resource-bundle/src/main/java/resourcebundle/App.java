package resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class App {
    
    public static void main( String... args ){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Localized", Locale.GERMAN);
        System.console().printf("\n hello : %s\n", resourceBundle.getString("hello"));
    }
}
