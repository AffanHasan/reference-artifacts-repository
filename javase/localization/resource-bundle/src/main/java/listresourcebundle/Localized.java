package listresourcebundle;

public class Localized extends java.util.ListResourceBundle{

    private final Object[][] localizedResources;

    public Localized() {
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
