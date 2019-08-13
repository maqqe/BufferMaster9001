/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maqqeworx.buffermaster9001;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author makke
 */
public class BufferMaster9001 {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        
        HashMap<String,Integer> buffer = new HashMap<>();
        
        System.out.println("Welcome to BufferMaster9001!\n");
        
        int finalVolume = 0;
        
        while (true) {
            System.out.print("Please give the final volume of your buffer in ml: ");
            String input = reader.nextLine();
            if (isInteger(input)) {
                finalVolume = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Incorrect input.");
            }
            
        }
        
        System.out.println("\nInsert 1 if you're diluting a stock solution, "
                + "insert 2 if you're adding a component in solid form.\n");
        
        String selection = reader.nextLine();
        
        if (selection.equals("1")) {
            System.out.print("Please give the concentration of your buffer component stock solution: ");
            double startingConcentration = reader.nextDouble();
            
            double finalConcentration = 0;
            
            while (true) {
                System.out.print("Please give the final concentration for your buffer component: ");
                finalConcentration = reader.nextDouble();
                if (finalConcentration > startingConcentration) {
                    System.out.println("Final concentration cannot be higher than the concentration of the stock.");
                    return;
                } else {
                    break;
                }
            }
            
        
            double startingVolume = calculateVolume(finalVolume, startingConcentration, finalConcentration);
                
            System.out.println("\nThe volume you need to add is: " + startingVolume);
            
        } else if (selection.equals("2")) {
            System.out.print("Please give the final concentration for the component in millimolar: ");
            double finalConcentration = reader.nextDouble();
            System.out.print("Please give the molar mass of your component: ");
            double molarMass = reader.nextDouble();
            
            System.out.println("The required mass of the component is: " + calculateMass(finalVolume, molarMass, finalConcentration) + " g");
            
        } else {
            System.out.println("Wrong input ya bastard! Clearly you're too dumb to follow instructions. Exiting program...");
        }
        
        
        
        
    }
    
    public static double calculateVolume(double finalVolume, double startingConcentration, double finalConcentration) {
        return (finalVolume * finalConcentration / startingConcentration);
    }
    
    public static double calculateMass(double finalVolume, double molarMass, double finalConcentration) {
        return ((finalVolume / 1000) * molarMass * (finalConcentration / 1000));
    }
    
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
    

