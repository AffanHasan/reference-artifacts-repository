package listresourcebundle;

import java.util.ListResourceBundle;

public class Localized_de extends ListResourceBundle {

    private final Object[][] localizedResources;

    public Localized_de() {
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
