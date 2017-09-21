/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.tickets.adhoc;

/**
 *
 * @author Jeevan
 */
public class AdhocTicketFactoryUnitTest {
    public static void main(String[] args){
        IAdhocTicketFactory adhocTicFac = new AdhocTicketFactory();
        
        //tests the make() method of AdhocTicketFactory Class
        IAdhocTicket adhocTic = adhocTicFac.make("EarlyBird",5);
        
        //prints the information of the ticket
        System.out.println(adhocTic.toString());
    }
}
