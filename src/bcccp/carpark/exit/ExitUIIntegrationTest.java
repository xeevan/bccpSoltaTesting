/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.carpark.exit;

import bcccp.carpark.CarSensor;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.adhoc.IAdhocTicketFactory;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.IUsageRecordFactory;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecordFactory;

/**
 *
 * @author Jeevan
 */
public class ExitUIIntegrationTest {
    public static void main(String[] args){
        //new parameterized instance of ExitUI class created
        ExitUI exitui = new ExitUI(20,20);
        
        IAdhocTicketFactory adhocticketfactory = new AdhocTicketFactory();
        IAdhocTicketDAO iadhocticketdao = new AdhocTicketDAO(adhocticketfactory);
        
        IUsageRecordFactory usagerecordfactory = new UsageRecordFactory();
        ISeasonTicketDAO iseasonticketdao = new SeasonTicketDAO(usagerecordfactory);
        
        //IAdhocTicket iadhocticket = adhocticketfactory.make("Early Bird",5);
        
        Carpark carpark = new Carpark("Early Bird", 50, iadhocticketdao, iseasonticketdao);
        IGate igate = new Gate(20,20);
        ICarSensor insidecarsensor = new CarSensor("Car123",10,10);
        ICarSensor outsidecarsensor = new CarSensor("Car123",15,15);
        IExitUI iexitui = new ExitUI(40,40);
        
        //tests the creation of ExitController instance
        IExitController exitcontroller = new ExitController(carpark,igate,insidecarsensor,outsidecarsensor,iexitui);
        
        //test the registerController() method
        exitui.registerController(exitcontroller);
        System.out.println("Successful Test:Controller registered for ExitUI");
        
        //test the registerController() method
        exitui.deregisterController();
        System.out.println("Successful Test:Controller assigned null for ExitUI");
        System.out.println("The value of controller is "+exitui.controller);
        
        //test the display() method
        exitui.display("This is the message to be displayed");
        System.out.println("Successful Test: "+exitui.displayTextField.getText());
        
//        //test the readTicket() method
//        exitui.readTicket();
//        System.out.println("Successful Test: readTicket() method invoked");
        
//        //test the takeTicket() method
//        exitui.takeTicket();
//        System.out.println("Successful Test: takeTicket() method invoked");
        
        //test the discardTicket() method
        exitui.discardTicket();
        System.out.println("Successful Test: discardTicket() method invoked");
        System.out.println("This value read by Ticket Reader is :"+exitui.ticketReaderTextField.getText());
        
        //test the beep() method
        exitui.beep();
        System.out.println("Successful Test: beep sound generated..");
    }   
    
}
