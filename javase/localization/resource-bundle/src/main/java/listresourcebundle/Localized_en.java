package listresourcebundle;

import java.util.ListResourceBundle;

public class Localized_en extends ListResourceBundle {

    private final Object[][] localizedResources;

    public Localized_en() {
        this.localizedResources = new Object [][]
        { 
            { "hello", "Hello" }            
        };
    }
    
    @Override
    protected Object[][] getContents() {
        return localizedResources;
    }    
}
