

import java.util.ListResourceBundle;

public class LocalizedObjects_en extends ListResourceBundle {

    private final Object[][] localizedResources;

    public LocalizedObjects_en() {
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
