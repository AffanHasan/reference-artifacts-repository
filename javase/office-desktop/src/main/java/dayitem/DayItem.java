/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import java.util.List;
import taskitem.TaskItem;

/**
 *
 * @author Affan Hasan
 */
public interface DayItem {
        
    long getDateAsLong();
    
    /**
     * Standard string format for Date is for example : <b>Wed, Dec 17 2014</b>
     * @return 
     */
    String getStandardDate();
    
    List<TaskItem> getTasks();
    
    void addTask(TaskItem task);
    
    void addTask(TaskItem task, int index);
    
    void replaceTask(TaskItem task, int index);
    
    void removeTask(int orderNo);
    
    /**
     * Here the index is the task item order number
     * @param index 
     */
    void reorderTaskItem(TaskItem task, int index);
}