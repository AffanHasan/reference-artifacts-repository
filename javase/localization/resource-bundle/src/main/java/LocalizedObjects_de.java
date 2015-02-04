

import java.util.ListResourceBundle;

public class LocalizedObjects_de extends ListResourceBundle {

    private final Object[][] localizedResources;

    public LocalizedObjects_de() {
        this.localizedResources = new Object [][]
        { 
            { "hello", "hallo" }            
        };
    }
    
    @Override
    protected Object[][] getContents() {
        return localizedResources;
    }    
}
