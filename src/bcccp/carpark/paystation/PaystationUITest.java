/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.carpark.paystation;

import bcccp.carpark.Carpark;

/**
 *
 * @author Pramesh
 */
public class PaystationUITest {
    public static void main(String[] args){
    
  
    PaystationUI pu=new PaystationUI(20, 30);
        
    pu.beep();
    pu.display("Display message");
    pu.log("Pramesh");
    pu.printTicket("cp1", 22, 15, 200, 40, "A3");
    pu.pay();
    //pu.log("Pramesh");
   }
} 
    
    
    
