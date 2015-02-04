

public class LocalizedObjects extends java.util.ListResourceBundle{

    private final Object[][] localizedResources;

    public LocalizedObjects() {
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