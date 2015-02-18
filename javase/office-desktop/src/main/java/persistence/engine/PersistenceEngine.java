/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.engine;

/**
 * Interface for the persistence engine
 * @author Affan Hasan
 */
public interface PersistenceEngine {
    
    public enum STATUS_LIST{
        
        PENDING ("PENDING"),
        IN_PROGRESS ("IN PROGRESS"),
        DONE ("DONE"),
        DISCARDED ("DISCARDED");
        
        private final String statusName;
        
        STATUS_LIST(String status){
            this.statusName = status;
        }
        
        String getStatusName(){
            return this.statusName;
        }
    }
    
    /**
     * 
     * @return The string name of default status
     */
    String getDefaultStatusName();
    
    /**
     * @return A String array of status names
     */
    String[] getStatusNames();
}