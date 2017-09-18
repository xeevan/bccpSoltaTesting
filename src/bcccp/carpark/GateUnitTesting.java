/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcccp.carpark;
import bcccp.carpark.Gate;


/**
 *
 * @author Sunil
 */
public class GateUnitTesting {
    public static void main(String[] args){
        System.out.println("creating gate1, an instance of the Gate class...");
        Gate gate1= new Gate(100,100);
        System.out.println("gate1, an instance of the Gate class created..");
        System.out.println("Testing the raise method of the Gate class...");
        gate1.raise();
        System.out.println("Testing the israsied method of the Gate class");
        System.out.println(gate1.isRaised());
        System.out.println("Testing the lower method of the Gate class");
        gate1.lower();
        System.out.println(gate1.isRaised());
        
        
    }
}
