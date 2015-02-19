/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskitem.DefaultTaskItem;
import static org.testng.Assert.*;
import taskitem.TaskItem;

/**
 *
 * @author Affan Hasan
 */
public class DayItem_BehaviorTest {
    
    private DayItem dayItem;
    private TaskItem taskItem;
    
    @BeforeMethod
    public void setUpMethod() throws Exception{
        dayItem = new DefaultDayItem();
        taskItem = new DefaultTaskItem();
    }
    
    @Test
    public void add_a_task_item(){
        int size = dayItem.getTasks().size();
        dayItem.addTask(taskItem);
        assertTrue(dayItem.getTasks().size() == size + 1);
    }
    
    @Test
    public void adding_a_task_item_at_index_0(){
        int size = dayItem.getTasks().size();
        dayItem.addTask(taskItem, 0);
        assertTrue(dayItem.getTasks().size() == size + 1);
    }
    
    @Test
    public void adding_a_task_item_at_index_value_smaller_than_0_must_throw_illegalargexception(){
        try{
            int size = dayItem.getTasks().size();
            dayItem.addTask(taskItem, -1);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void adding_a_task_item_at_index_3(){
        addTasks(4);
        int size = dayItem.getTasks().size();
        taskItem = new DefaultTaskItem();
        dayItem.addTask(taskItem, 3);
        assertTrue(dayItem.getTasks().size() == size + 1);
    }
    
    @Test
    public void adding_a_task_item_at_index_should_auto_assign_the_order_no_to_task_item(){
        addTasks(4);
        int size = dayItem.getTasks().size();
        taskItem = new DefaultTaskItem();
        dayItem.addTask(taskItem, 3);
        
        for(int index = 0; index < size + 1; index++){
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
    }
    
    @Test
    public void adding_a_task_item_at_higher_index_should_through_illegalargumentexception(){
        try{
            for(int index = 0; index < 4; index++){
                taskItem = new DefaultTaskItem();
                dayItem.addTask(taskItem);
                assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
            }
            int size = dayItem.getTasks().size();
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem, 8);
        }catch(IllegalArgumentException e){
            return ;
        }
        fail();
    }
    
    @Test
    public void add_a_task_item_should_auto_assign_the_order_no_to_task_item(){
        for(int index = 0; index < 3; index++){
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem);
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
    }
    
    @Test
    public void remove_task_item_by_order_number(){
        dayItem.addTask(taskItem);
        int size = dayItem.getTasks().size();
        byte orderNo = 0;
        dayItem.removeTask(orderNo);
        assertTrue(dayItem.getTasks().size() == size - 1);
    }
    
    @Test
    public void remove_task_item_by_order_number_must_maintain_correct_ordering(){
        addTasks(4);
        dayItem.removeTask(3);
        for(int i=0; i < 3; i++){
            assertTrue(dayItem.getTasks().get(i).getOrderNumber() == i);
        }
    }
    
    @Test
    public void remove_task_item_must_throw_illegalargumentexception_when_order_no_is_outofbound(){
        addTasks(4);
        try{
            dayItem.removeTask(10);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void remove_task_item_by_order_number_illegal_argument_exception_when_no_is_negative(){
        try{
            dayItem.addTask(taskItem);
            int size = dayItem.getTasks().size();
            byte orderNo = -1;
            dayItem.removeTask(orderNo);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void reordering_a_task(){
        addTasks(4);
        taskItem = new DefaultTaskItem();
        String description = "reordering_a_task";
        taskItem.setDescription(description);
        dayItem.reorderTaskItem(taskItem, 0);
        assertTrue(dayItem.getTasks().get(0).getDescription().equals("reordering_a_task"));
    }
    
    @Test
    public void reordering_a_task_must_maintain_correct_ordering(){
        addTasks(4);
        String description = "reordering_a_task";
        taskItem.setDescription(description);
        dayItem.reorderTaskItem(taskItem, 0);
        for(int index = 0; index < 4; index++){
            assertTrue(dayItem.getTasks().get(index).getOrderNumber() == index);
        }
    }
    
    @Test
    public void update_task(){
        int index = 1;
        String description = "Some Updates";
        addTasks(4);
        TaskItem task = dayItem.getTasks().get(index);
        task.setDescription(description);
        dayItem.replaceTask(task, index);
        assertTrue(dayItem.getTasks().get(index).getDescription().equals(description));
    }
    
    @Test
    public void update_task_at_higher_index_must_throw_illegalargumentexception(){
        try{
            int index = 1;
            String description = "Some Updates";
            addTasks(4);
            TaskItem task = dayItem.getTasks().get(index);
            task.setDescription(description);
            dayItem.replaceTask(task, 100);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    @Test
    public void update_task_at_index_smalle_than_zero_must_throw_IllegalArgumentException(){
        try{
            int index = 1;
            String description = "Some Updates";
            addTasks(4);
            TaskItem task = dayItem.getTasks().get(index);
            task.setDescription(description);
            dayItem.replaceTask(task, -3);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    private void addTasks(int numberOfTasks){
        for(int index = 0; index < numberOfTasks; index++){
            taskItem = new DefaultTaskItem();
            dayItem.addTask(taskItem);
        }
    }
}