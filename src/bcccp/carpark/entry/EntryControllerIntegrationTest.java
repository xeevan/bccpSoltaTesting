/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.carpark.entry;

import bcccp.carpark.CarSensor;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.adhoc.IAdhocTicketFactory;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.IUsageRecordFactory;
import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecordFactory;
import java.util.Calendar;

/**
 *
 * @author 11629800 Iranga Mendis
 */
public class EntryControllerIntegrationTest {
    public static void main(String[] args){
        
        //create adhocticketfactory object
         IAdhocTicketFactory adhocticketfactory = new AdhocTicketFactory();
         //create iadhocticketdao object
        IAdhocTicketDAO iadhocticketdao = new AdhocTicketDAO(adhocticketfactory);
        //create usagerecordfactory object
        IUsageRecordFactory usagerecordfactory = new UsageRecordFactory();
        //create iseasonticketdao object
        ISeasonTicketDAO iseasonticketdao = new SeasonTicketDAO(usagerecordfactory);
       //create carpark object
        Carpark carpark = new Carpark("Early Bird", 50, iadhocticketdao, iseasonticketdao);
        
         //get current time in millies
        long millisStart = Calendar.getInstance().getTimeInMillis();
        
        //Add 2 hour duration for the Season ticket
        long millisEnd = millisStart+7200000;
      
        //create a season ticket object
        ISeasonTicket seasonTicket = new SeasonTicket("S0000001", carpark.getName(), millisStart, millisEnd);
        
        //Create Gate Object
        IGate igate = new Gate(20,20);
        //Create Inside Car Sensor Object
        ICarSensor insidecarsensor = new CarSensor("Car123",10,10);
        //Create OutSide Car Sensor Object
        ICarSensor outsidecarsensor = new CarSensor("Car123",15,15);
        //Create Entry UI Object
        IEntryUI entryui = new EntryUI(40,40);
        
        //tests the creation of entrycontroller instance
        EntryController entrycontroller = new EntryController(carpark, igate, outsidecarsensor, insidecarsensor, entryui);
        
        //tests the carEventDetected method
        entrycontroller.carEventDetected("Car123", true);
        //Test is season ticket valid or not
        carpark.isSeasonTicketValid(seasonTicket.getId());
        //Check Season is Ticket in 
        carpark.isSeasonTicketInUse(seasonTicket.getId());
        
        
        
        
    
    }
}
