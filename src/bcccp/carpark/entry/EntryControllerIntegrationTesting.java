/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.carpark.entry;
import bcccp.carpark.CarSensor;
import bcccp.carpark.entry.EntryController;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.adhoc.IAdhocTicketFactory;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.IUsageRecordFactory;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecordFactory;

/**
 *
 * @author Sunil
 */
public class EntryControllerIntegrationTesting {
   public static void main(String[] args){
        System.out.println("Creating an instance of IAdhocticketFactory class...");
        IAdhocTicketFactory adhocticketfactory = new AdhocTicketFactory();
        System.out.println("Creating an instance of IAdhocTicketDAO class...");
        IAdhocTicketDAO iadhocticketdao = new AdhocTicketDAO(adhocticketfactory);
        System.out.println("Creating an instance of IUsageRecordFactory class...");
        IUsageRecordFactory usagerecordfactory = new UsageRecordFactory();
        System.out.println("Creating an instance of ISeasonTicketDAO class...");
        ISeasonTicketDAO iseasonticketdao = new SeasonTicketDAO(usagerecordfactory);
        System.out.println("Creating an instnce of Carpark class...");
        Carpark cp =new Carpark("Bathrust",1000,iadhocticketdao,iseasonticketdao);
        System.out.println("Creating an instance of igate class...");
        IGate igate = new Gate(20,20);
        System.out.println("Creating an instance of insideCarSensor class..");
        ICarSensor insidecarsensor = new CarSensor("bathrust123",10,10);
        System.out.println("Creating an instance of outside car sensoor");
        ICarSensor outsidecarsensor = new CarSensor("bathrust123",15,15);
        System.out.println("Creating an instanace of entryUi class...");
        IEntryUI ientryui = new EntryUI(40,40);
        System.out.println("Creating an instance of EntryController class...");
        EntryController EC=new EntryController(cp,igate,outsidecarsensor,insidecarsensor,ientryui);
        System.out.println("Testing the log method..");
        EC.log("Sunil Integration testing");
        System.out.println("Testing the carEventDetected method...");
        EC.carEventDetected("Sunil", true);
         EC.buttonPushed();
        System.out.println("Testing the ticketInserted method..");
        EC.ticketInserted("A3");
        System.out.println("Testing the notifyCarpark event..");
        EC.notifyCarparkEvent();
        System.out.println("Testing the ticket taken method...");
        EC.ticketTaken();
        System.out.println("Tested Successfully");
       
        
        
        
        
        
       
       
   } 
}
