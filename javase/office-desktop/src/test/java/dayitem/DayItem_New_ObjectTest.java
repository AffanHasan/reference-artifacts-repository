/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayitem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.annotations.Ignore;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Affan Hasan
 */
public class DayItem_New_ObjectTest {
    
    private final DayItem dayItem = new DefaultDayItem();
    
    private final SimpleDateFormat standardDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy");
    
    public DayItem_New_ObjectTest() {
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
    public void dayItem_must_have_date_as_milliseconds_long(){
        try{
            long date = dayItem.getDateAsLong();
            new Date(date);
        }catch(NullPointerException e ){
            fail();
        }
        catch(Exception e){
            fail();
        }
    }
    
    @Test
    public void date_must_be_equal_to_current_system_date(){
        Date currentDate = new Date(System.currentTimeMillis());
        Date objectDate = new Date(dayItem.getDateAsLong());
        SimpleDateFormat sdf = new SimpleDateFormat();
        assertEquals(sdf.format(objectDate), sdf.format(currentDate));
    }
    
    /**
     * Standard string format for Date is : <b>Wed, Dec 17 2014</b>
     */
    @Test
    public void must_return_date_in_standard_string_format(){
        String currentDate = standardDateFormat.format(new Date(System.currentTimeMillis()));
        String objectDate = dayItem.getStandardDate();
        assertEquals(objectDate, currentDate);
    }
    
    @Test
    public void should_be_able_to_create_object_with_a_particular_date_passed_as_standard_format_string(){
        try {
            String date = "Tue, Dec 16 2014";
            DayItem day = new DefaultDayItem(date);
            assertEquals(date, day.getStandardDate());
        } catch (ParseException ex) {
            fail();
        }
    }
    
    @Test
    public void must_throw_parse_exception_when_creating_an_object_with_incorrect_standard_format_string(){
        try {
            String date = "Wed, Dec 17, 2014";//Wrong format
            DayItem day = new DefaultDayItem(date);
        } catch (ParseException ex) {
            return;
        }
        fail();
    }
    
    @Test
    public void must_contain_an_empty_TaskItem_list_by_default(){
        assertTrue(dayItem.getTasks().isEmpty());
    }
    
}