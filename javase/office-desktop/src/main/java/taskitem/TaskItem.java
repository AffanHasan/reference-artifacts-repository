/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskitem;

import java.time.Instant;
import persistence.engine.PersistenceEngine;

/**
 * Represents a TaskItem
 * @author Affan Hasan
 */
public interface TaskItem {
    
    String getCategory();
    
    void setCategory(String category);
    
    PersistenceEngine.STATUS_LIST getStatus();
    
    void setStatus(PersistenceEngine.STATUS_LIST status);
    
    String getDescription();
    
    void setDescription(String description);
    
    int getOrderNumber();
    
    void setOrderNumber(int orderNo);
    
    String getTotalTime();
    
    /**
     * Time Instant on which this task item is last modified
     * @return 
     */
    Instant getLastModifiedInstant();
    
}