/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.tickets.season;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 11629800 Iranga Mendis
 */
public class SeasonTicketUnitTesting {

    public static void main(String[] args) throws NullPointerException{
        
        //get current time in millies
        long millisStart = Calendar.getInstance().getTimeInMillis();
        
        //Add 2 hour duration for the Season ticket
        long millisEnd = millisStart+7200000;
      
        //create a season ticket object
        SeasonTicket seasonTicket = new SeasonTicket("S00001", "carpark1",millisStart,millisEnd);
        
        //Testing accessors methods
        System.out.println("Testing seasonTicket getId method: "+seasonTicket.getId());
        System.out.println("Testing  seasonTicket getCarparkId method: "+seasonTicket.getCarparkId());
        System.out.println("Testing seasonTicket getStartValidPeriod method: "+seasonTicket.getStartValidPeriod());
        System.out.println("Testing seasonTicket getStartValidPeriod method: "+seasonTicket.getEndValidPeriod());
        
        //create usage record 
        IUsageRecord usageRecord = new UsageRecord(seasonTicket.getId(), seasonTicket.getStartValidPeriod());
        
        //Testing seasonTicket inUse() method
        System.out.println("Testing seasonTicket inUse() method: "+seasonTicket.inUse());
     
        
        
        //inorder Test seasonTicket getCurrentUsageRecord  method, test before finalise and recordUsage methods
        usageRecord.finalise(seasonTicket.getEndValidPeriod());
        seasonTicket.recordUsage(usageRecord);
        
        //Testing seasonTicket getCurrentUsageRecord() method
        System.out.println("Testing seasonTicket getCurrentUsageRecord() method: "+seasonTicket.getCurrentUsageRecord());
        
         //Testing seasonTicket getUsageRecords() method
        System.out.println("Testing seasonTicket inUse() method: "+seasonTicket.getUsageRecords());
        
        
        
        
         
      
        
        
    }
    
    //method for convert mili seconds to  Date time format
    public static String convertTime(long time){
    Date date = new Date(time);
    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
    return format.format(date);
}
}
