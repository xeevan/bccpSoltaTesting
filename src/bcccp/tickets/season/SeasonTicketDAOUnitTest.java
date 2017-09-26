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
public class SeasonTicketDAOUnitTest {
    public static void main(String[] args) throws NullPointerException{
        
          //get current time in millies
        long millisStart = Calendar.getInstance().getTimeInMillis();
        
         //Add 2 hour duration for the Season ticket
        long millisEnd = millisStart+7200000;
        
        //create UsageRecordFactory to make a instance of seasonTicketDAO
        //unit tests has been done for usageRecordFactory class's methods
        IUsageRecordFactory usageRecordFactory = new UsageRecordFactory();
       
        
        //Testing creat a season tickeDAO
        SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(usageRecordFactory);
        
       
      
        //create a season ticket object
        //unit testing has been done for seasonTickets
        SeasonTicket seasonTicket = new SeasonTicket("S00001", "carpark1",millisStart,millisEnd);
        
        //Testing creating registerTicket method
        seasonTicketDAO.registerTicket(seasonTicket);
        
        //Testing getNumberOfTickets methods to test  season ticket has been succesfully registerd or not by looking
        //-at currentTickets Map size
        System.out.println("Testing getNumberOfTickets methods to count current Season Ticket: "+seasonTicketDAO.getNumberOfTickets());
        
        //Testing findTicketById() method
        //Search above Registered Ticket in the Map
        System.out.println("Testing findTicketById() method: "+seasonTicketDAO.findTicketById(seasonTicket.getId()));
        
        //Testing for recordTicketUsage in Entry to search not in MAP
       // System.out.println("Testing findTicketById() method: "+seasonTicketDAO.findTicketById("hghgh3764743"));
        
        //Testing recordTicketEntry() method
       seasonTicketDAO.recordTicketEntry(seasonTicket.getId());
       
        //Testing recordTicketEntry() method for non valid ticket
      // seasonTicketDAO.recordTicketEntry("hghgh3764743");
        
      // Testing  recordTicketExit() method
        seasonTicketDAO.recordTicketExit(seasonTicket.getId());
        
        //Testing recordTicketExit() method for non valid ticket
      // seasonTicketDAO.recordTicketExit("hghgh3764743");
        
         //Testing deregisterTicket() method for non valid ticket
       seasonTicketDAO.deregisterTicket(seasonTicket);
       
       
       //Testing deregisterTicket()method
       seasonTicketDAO.deregisterTicket(seasonTicket);
        
        //To test wehether that the ticket is removed from the MAP
        //currentTickets Map size
        System.out.println("Testing getNumberOfTickets method count current Season Ticket: "+seasonTicketDAO.getNumberOfTickets());
    }
    
}
