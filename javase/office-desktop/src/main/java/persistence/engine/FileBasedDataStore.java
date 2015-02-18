/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.engine;

/**
 * @author Affan Hasan
 */
public class FileBasedDataStore implements PersistenceEngine {
    
    /**
     * Making this constructor a private in order to make it singleton
     */
    private FileBasedDataStore(){
    }
    
    @Override
    public String[] getStatusNames() {
        String[] list = new String[STATUS_LIST.values().length];
        for( int i=0; i < STATUS_LIST.values().length; i++ ){
            list[i] = STATUS_LIST.values()[i].getStatusName();
        }
        return list;
    }
    
    private static class Holder{
        private static final FileBasedDataStore holder = new FileBasedDataStore();
    }
    
    /**
     * Since this class is implemented as singleton; hence this is the factory method.
     * @return 
     */
    public static FileBasedDataStore getInstance(){
        return Holder.holder;
    }
    
    @Override
    public String getDefaultStatusName() {
        return STATUS_LIST.values()[0].getStatusName();
    }
    
}