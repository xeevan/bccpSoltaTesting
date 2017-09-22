/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.carpark.entry;

/**
 *
 * @author Sunil
 */
public class EntryUIintegrationTesting {
   public static void main(String[] args){
       System.out.println("Creating an instance of EntryUI class..");
       EntryUI EU= new EntryUI(100,100);
       System.out.println("Testing the display method..");
       EU.display("Sunil Integration testing");
       System.out.println("Testing the beep method");
       EU.beep();
       System.out.println(EU.ticketPrinted());
       System.out.println("Tested successfully");
       
       
       
       
   } 
}
