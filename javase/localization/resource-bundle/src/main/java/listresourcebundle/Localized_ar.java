package listresourcebundle;

import java.util.ListResourceBundle;

public class Localized_ar extends ListResourceBundle {

    private final Object[][] localizedResources;

    public Localized_ar() {
        this.localizedResources = new Object [][]
        { 
            { "hello", "مرحبا" }            
        };
    }
    
    @Override
    protected Object[][] getContents() {
        return localizedResources;
    }    
}
