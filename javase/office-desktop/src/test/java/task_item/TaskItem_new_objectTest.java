/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_item;

import java.time.Instant;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import persistence.engine.PersistenceEngine;
import taskitem.DefaultTaskItem;
import taskitem.TaskItem;

/**
 * Requirements for newly created TaskItem object
 * 
 * @author Affan Hasan
 */
public class TaskItem_new_objectTest {
    
    public static final String hours = " hour(s)";
    public static final String minutes = " minute(s)";
    public static final String seconds = " second(s)";
    
    private TaskItem taskItem = new DefaultTaskItem();
    
    public TaskItem_new_objectTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void task_item_must_return_CATEGORY_as_string() {
        assertTrue(taskItem.getCategory() instanceof String);
    }
    
    @Test
    public void task_item_must_return_CATEGORY_as_empty_string() {
        assertTrue(taskItem.getCategory().equals(""));
    }
    
    @Test
    public void task_item_must_return_DESCRIPTION_as_string() {
        assertTrue(taskItem.getDescription() instanceof String);
    }
    
    @Test
    public void task_item_must_return_DESCRIPTION_as_empty_string() {
        assertTrue(taskItem.getDescription().equals(""));
    }
    
    @Test
    public void task_item_must_return_PENDING_as_status() {
        assertEquals(taskItem.getStatus(), PersistenceEngine.STATUS_LIST.PENDING);
    }
    
    @Test
    public void must_have_an_order_number() {
        assertNotNull(taskItem.getOrderNumber());
    }
    
    @Test
    public void must_return_zero_seconds_as_total_processing_time(){
        assertEquals(taskItem.getTotalTime(), 0 + seconds);
    }
    
    @Test
    public void get_last_modified_instant(){
        assertTrue(taskItem.getLastModifiedInstant() instanceof Instant);
    }
    
    @Test
    public void get_last_modified_instant_not_null(){
        assertNotNull(taskItem.getLastModifiedInstant());
    }
    
}