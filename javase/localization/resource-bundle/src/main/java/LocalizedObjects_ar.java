

import java.util.ListResourceBundle;

public class LocalizedObjects_ar extends ListResourceBundle {

    private final Object[][] localizedResources;

    public LocalizedObjects_ar() {
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
