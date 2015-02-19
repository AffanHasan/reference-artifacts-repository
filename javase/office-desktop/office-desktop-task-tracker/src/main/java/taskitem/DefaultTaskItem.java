/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskitem;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.DatatypeConstants;
import persistence.engine.FileBasedDataStore;
import persistence.engine.PersistenceEngine;

/**
 *
 * @author root
 */
public class DefaultTaskItem implements TaskItem {
    
    private String category = "";
    
    private String description = "";
    
//    private PersistenceEngine.STATUS_LIST status = null;
    
    private int orderNumber;
    
    private final PersistenceEngine pEngine = FileBasedDataStore.getInstance();
    
    private final List<StatusObject> statusLog = new ArrayList<>();

    @Override
    public Instant getLastModifiedInstant() {
        return this.statusLog.get(this.statusLog.size() - 1).getTimeStamp();
    }
    
    private class StatusObject{
        
        private final PersistenceEngine.STATUS_LIST status;
        
        private final Instant timeStamp;

        public StatusObject() {
            this.status = PersistenceEngine.STATUS_LIST.PENDING;
            this.timeStamp = Instant.now();
        }
        
        public StatusObject(PersistenceEngine.STATUS_LIST status) {
            this.status = status;
            this.timeStamp = Instant.now();
        }

        public Instant getTimeStamp() {
            return timeStamp;
        }
        
        public PersistenceEngine.STATUS_LIST getStatus(){
            return this.status;
        }
        
    }
    
    public DefaultTaskItem() {
        addStatus(PersistenceEngine.STATUS_LIST.PENDING);
    }
    
    private StatusObject getDefaultStatusObject(){
        return new StatusObject();
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public PersistenceEngine.STATUS_LIST getStatus() {
        return statusLog.get(statusLog.size() - 1).getStatus();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(int orderNo) {
        if(orderNo < 0){
            throw new IllegalArgumentException("Order Number Must Not Be Negative");
        }
        this.orderNumber = orderNo;
    }

    @Override
    public String getTotalTime() {
        return getDuration();
    }
    
    private String getDuration(){
        Duration dur = extractTotalDuration();
        final String duration;
        if(dur.toHours() > 0){//If one or more hours
            if(dur.minus(dur.toHours(), ChronoUnit.HOURS).toMinutes() > 0){
                long minutes = dur.minus(dur.toHours(), ChronoUnit.HOURS).toMinutes();
                duration = String.valueOf(dur.toHours()) + " hour(s)" 
                            + " " +String.valueOf(minutes) + " minute(s)";
            }else{
                duration = String.valueOf(dur.toHours()) + " hour(s)";
            }
        }else if(dur.toMinutes() > 0){//If one or more minutes
            if(dur.minus(dur.toMinutes(), ChronoUnit.MINUTES).getSeconds() > 0){
                long seconds = dur.minus(dur.toMinutes(), ChronoUnit.MINUTES).getSeconds();
                duration = String.valueOf(dur.toMinutes()) + " minute(s)" 
                            + " " +String.valueOf(seconds) + " second(s)";
            }else{
                duration = String.valueOf(dur.toMinutes()) + " minute(s)";
            }
        }else if(dur.getSeconds() > 0){//If one or more seconds
            duration = String.valueOf(dur.getSeconds()) + " second(s)";
        }else{//default
            duration = "0 second(s)";
        }
        return duration;
    }
    
    private Duration extractTotalDuration(){
        Duration totalTime = Duration.ZERO;
        Instant t1 = null;
        Instant t2 = null;
        boolean ip = false;
        for(StatusObject obj : statusLog ){
            
            if(obj.getStatus() == PersistenceEngine.STATUS_LIST.IN_PROGRESS){
                t1 = obj.getTimeStamp();
                ip = true;
            }else if(ip){
                t2 = obj.getTimeStamp();
                totalTime = totalTime.plus(Duration.between(t1, t2));
                ip = false;
            }
        }
        return totalTime;
    }
    
    protected final void addStatus(PersistenceEngine.STATUS_LIST status){
        if(status != null){
            this.statusLog.add(new StatusObject(status));
        }
        else{
            throw new IllegalArgumentException("Status cannot be null");
        }
    }

    @Override
    public void setStatus(PersistenceEngine.STATUS_LIST status) {
        addStatus(status);
    }
    
}