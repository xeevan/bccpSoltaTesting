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
 * @author IMM
 */
public class UsageRecordUnitTest {

    public static void main(String[] args) throws NullPointerException {

        //get current time in millies
        long millisStart = Calendar.getInstance().getTimeInMillis();

        //Add 2 hour duration for the Season ticket
        long millisEnd = millisStart + 7200000;

        //create usageRecord Object
        UsageRecord usageRecord = new UsageRecord("S0001", millisStart);

        // Test finalise method in order to test accessor methods 
        usageRecord.finalise(millisEnd);

        //Testing for accessor methods
        System.out.println("Testing for getSeasonTicketId: " + usageRecord.getSeasonTicketId());
        System.out.println("Testing for getStartTime in millies: " + usageRecord.getStartTime());
        System.out.println("Testing for getEndTime in millies: " + usageRecord.getEndTime());
        //Testing Milli Seconds in Date Time formar
        System.out.println("Testing for getStartTime(DateTime format): " + convertTime(usageRecord.getStartTime()));
        System.out.println("Testing for getEndTime(DateTime format): " + convertTime(usageRecord.getEndTime()));
        
        //Testing To String Method in UsageRecords
        System.out.println("Testing for toString: " + usageRecord.toString());
        

    }

    //method for convert mili seconds to  Date time format
    public static String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        return format.format(date);

    }
}
