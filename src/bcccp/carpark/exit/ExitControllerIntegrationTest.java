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
public class ExitControllerIntegrationTest {
    public static void main(String[] args){
                
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
        ExitController exitcontroller = new ExitController(carpark,igate,insidecarsensor,outsidecarsensor,iexitui);
        
        //tests the carEventDetected method
        exitcontroller.carEventDetected("Car123", true);
        
        //tests the ticketInserted method
        exitcontroller.ticketInserted("A5");
        
        //tests the ticketTaken method
        exitcontroller.ticketTaken();
    }   
    
}
