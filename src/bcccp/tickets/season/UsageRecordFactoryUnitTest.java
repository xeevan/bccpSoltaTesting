/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bcccp.tickets.season;

import java.util.Calendar;

/**
 *
 * @author 11629800 Iranga Mendis
 */
public class UsageRecordFactoryUnitTest {
    public static void main(String[] args) throws NullPointerException {
        
        UsageRecordFactory usageRecordFactory = new UsageRecordFactory();
        
         //get current time in millies
        long millisStart = Calendar.getInstance().getTimeInMillis();

        //Test usageRecordFactory make(method)
        System.out.println(usageRecordFactory.make("S0001", millisStart).toString());
        
        
    }
    
}
