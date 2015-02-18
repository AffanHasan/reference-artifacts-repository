/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_item;

import java.sql.Time;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import persistence.engine.FileBasedDataStore;
import persistence.engine.PersistenceEngine;
import taskitem.DefaultTaskItem;
import taskitem.TaskItem;

/**
 *
 * @author root
 */
public class TaskItem_behaviorTest {
    
    private TaskItem taskItem;
    private final String category = "Personalized Menus";
    private final String description = "Some task";
    private PersistenceEngine.STATUS_LIST status = null;
    private final Instant base =  Instant.parse("2007-12-03T10:15:30.00Z");
    
    private final PersistenceEngine pEngine = FileBasedDataStore.getInstance();
    
    public TaskItem_behaviorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        taskItem = new DefaultTaskItem();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void must_set_category_as_string() {
        taskItem.setCategory(category);
        assertTrue(taskItem.getCategory().equals(category));
    }
    
    @Test
    public void must_not_null_after_setting_CATEGORY() {
        taskItem.setCategory(category);
        assertNotNull(taskItem.getCategory());
    }
    
    @Test
    public void must_not_empty_after_setting_CATEGORY() {
        taskItem.setCategory(category);
        assertTrue(taskItem.getCategory().length() > 0);
    }
    
    @Test
    public void must_set_description_as_string() {
        taskItem.setDescription(description);
        assertTrue(taskItem.getDescription().equals(description));
    }
    
    @Test
    public void must_not_null_after_setting_DESCRIPTION() {
        taskItem.setDescription(description);
        assertNotNull(taskItem.getDescription());
    }
    
    @Test
    public void must_not_empty_after_setting_DESCRIPTION() {
        taskItem.setDescription(description);
        assertTrue(taskItem.getDescription().length() > 0);
    }
    
    @Test
    public void must_accept_a_byte_as_order_number(){
        byte number = 1;
        taskItem.setOrderNumber(number);
        assertEquals(this.taskItem.getOrderNumber(), number);
    }
    
    @Test
    public void must_not_accept_a_negative_byte_value_as_order_number(){
        byte number = -1;
        try{
            taskItem.setOrderNumber(number);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    @Test
    public void must_return_status_as_STATUS_LIST(){
        assertTrue(taskItem.getStatus() instanceof PersistenceEngine.STATUS_LIST);
    }
    
    @Test
    public void must_accept_status_as_STATUS_LIST_value(){
        taskItem.setStatus(PersistenceEngine.STATUS_LIST.IN_PROGRESS);
        assertEquals(taskItem.getStatus(), PersistenceEngine.STATUS_LIST.IN_PROGRESS);
    }
    
    @Test
    public void must_throw_illegalArgsException_when_null_is_passed_as_status(){
        try{
            taskItem.setStatus(null);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    
    private void testForRangeOfTimeIntervals(ChronoUnit timeUnit, long start, long end){
        if(start <= 0)
            throw new IllegalArgumentException("start must be greater than 0");


//              Test for random time intervals
            for(; start <= end; start++){
                taskItem = new DefaultTaskItem();
                if(timeUnit == ChronoUnit.HOURS){
                    changeStatus(ChronoUnit.MINUTES, 1, PersistenceEngine.STATUS_LIST.IN_PROGRESS);
//                          Check for time interval where time interval equals 'start' number of hours
                    changeStatus(timeUnit, start, PersistenceEngine.STATUS_LIST.PENDING);
                    assertEquals(taskItem.getTotalTime(), start + TaskItem_new_objectTest.hours);

                    final long hour = start;
                    long minutes = 1;
//                            Check for hour transition ex: 1 hour 1 minute to 1 hour 59 minutes
                    for(; minutes <= 59; minutes++){
                        changeStatus(ChronoUnit.MINUTES, 1, PersistenceEngine.STATUS_LIST.IN_PROGRESS);
                        changeStatus(ChronoUnit.MINUTES, 1, PersistenceEngine.STATUS_LIST.PENDING);
                        assertEquals(taskItem.getTotalTime()
                                ,start + TaskItem_new_objectTest.hours + " " + minutes + TaskItem_new_objectTest.minutes);
                    }
                } else if(timeUnit == ChronoUnit.MINUTES){
//                          Check for time interval where time interval equals 'start' number of minutes
                    changeStatus(timeUnit, 1, PersistenceEngine.STATUS_LIST.IN_PROGRESS);
                    changeStatus(timeUnit, start, PersistenceEngine.STATUS_LIST.PENDING);
                    assertEquals(taskItem.getTotalTime(), start + TaskItem_new_objectTest.minutes);

                    final long minute = start;
                    long seconds = 1;
//                            Check for minute transition ex: 1 minute 1 second to 1 minute 59 seconds
                    for(; seconds <= 59; seconds++){
                        changeStatus(ChronoUnit.SECONDS, 1, PersistenceEngine.STATUS_LIST.IN_PROGRESS);
                        changeStatus(ChronoUnit.SECONDS, 1, PersistenceEngine.STATUS_LIST.PENDING);
                        assertEquals(taskItem.getTotalTime(), start + TaskItem_new_objectTest.minutes + " " + seconds + TaskItem_new_objectTest.seconds);
                    }
                } else if(timeUnit == ChronoUnit.SECONDS){
                    changeStatus(timeUnit, 1, PersistenceEngine.STATUS_LIST.IN_PROGRESS);
                    changeStatus(timeUnit, start, PersistenceEngine.STATUS_LIST.PENDING);
                    assertEquals(taskItem.getTotalTime(), start + TaskItem_new_objectTest.seconds);
                }
            }
    }
    
    private void changeStatus(ChronoUnit timeUnit, long interval, PersistenceEngine.STATUS_LIST status){

//              Mocking the time interval
        new Expectations(){
            {
                Instant.now();
//                      Adding the fake time interval
                result = taskItem.getLastModifiedInstant().plus(interval, timeUnit);
            }
        };
//              Setting status
        taskItem.setStatus(status);
    }
    
    @Test
    public void changing_status_with_random_hourly_intervals_should_calculate_total_time_correctly(@Mocked("now") Instant instant){
        
//      Check from 1 to 24 hours
        testForRangeOfTimeIntervals(ChronoUnit.HOURS,1, 24);
    }
    
    @Test
    public void changing_status_with_random_minute_intervals_should_calculate_total_time_correctly(@Mocked("now") Instant instant){
        
//      Check from 1 to 59 minutes
        testForRangeOfTimeIntervals(ChronoUnit.MINUTES,1 , 59);
    }
    
    @Test
    public void test_for_60_minutes_interval(@Mocked("now") Instant instant){
        changeStatus(ChronoUnit.MINUTES, 1, PersistenceEngine.STATUS_LIST.IN_PROGRESS);
        changeStatus(ChronoUnit.MINUTES, 60, PersistenceEngine.STATUS_LIST.PENDING);
        assertTrue(taskItem.getTotalTime().equals(1 + TaskItem_new_objectTest.hours));
    }
    
    @Test
    public void changing_status_with_random_seconds_intervals_should_calculate_total_time_correctly(@Mocked("now") Instant instant){
        
//            Check from 1 to 59 seconds
        testForRangeOfTimeIntervals(ChronoUnit.SECONDS,1 , 59);
    }
    
    @Test
    public void test_for60_seconds_interval(@Mocked("now") Instant instant){
        changeStatus(ChronoUnit.SECONDS, 1, PersistenceEngine.STATUS_LIST.IN_PROGRESS);
        changeStatus(ChronoUnit.SECONDS, 60, PersistenceEngine.STATUS_LIST.PENDING);
        assertTrue(taskItem.getTotalTime().equals(1 + TaskItem_new_objectTest.minutes));
    }
    
}