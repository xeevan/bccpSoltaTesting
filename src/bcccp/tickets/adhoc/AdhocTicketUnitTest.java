/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.tickets.adhoc;

import java.util.Date;

/**
 *
 * @author Jeevan
 */
public class AdhocTicketUnitTest {
    public static void main(String[] args){
        
        // creates new instance of AdhocTicket Class
        AdhocTicket adhocTic = new AdhocTicket("Early Bird",5,"B4");
        System.out.println("New instance of AdhocTicket created");
        
        //tests the getter method getBarcode() of the Class
        System.out.println("The bar code of the ticket is "+adhocTic.getBarcode());
        
        //tests the getter method getTicketNo() of the Class
        System.out.println("The ticket number is "+adhocTic.getTicketNo());
        
        //tests the getter method getCarparkId() of the Class
        System.out.println("The bar code of the ticket is "+adhocTic.getCarparkId());
        
        //tests the getter method getBarcode() of the Class
        System.out.println("The bar code of the ticket is "+adhocTic.getBarcode());
        
        //tests the setter method enter() of the Class. This sets the entry date
        adhocTic.enter(9/18/2017);
        
        //tests the getter method getEntryDateTime() of the Class
        System.out.println("The entry date and time is "+adhocTic.getEntryDateTime());
        
        //tests the setter method pay() of the Class. This sets the payment date
        adhocTic.pay(9/19/2017, 3);
        
        //tests the getter method getPaidDateTime() of the Class
        System.out.println("The payment date and time is "+adhocTic.getPaidDateTime());
        
        //tests the getter method getCharge() of the Class
        System.out.println("The amount charged is "+adhocTic.getCharge());
        
        //tests the getter method toString() of the Class
        System.out.println(adhocTic.toString());
        
        //tests the setter method exit() of the Class. This sets the entry date
        adhocTic.exit(9/18/2017);
        
        //tests the getter method getEntryDateTime() of the Class
        System.out.println("The exit date and time is "+adhocTic.getExitDateTime());
        System.out.println(new Date());
    }
}
