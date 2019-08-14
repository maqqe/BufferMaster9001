/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maqqeworx.buffermaster9001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;




/**
 *
 * @author makke
 */
public class BufferMaster9001 {
    
    private static List<String> components;
    private static List<Double> amounts;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        components = new ArrayList<>();
        amounts = new ArrayList<>();
        
        Scanner reader = new Scanner(System.in);
        
        
        System.out.println("\n\n\n");
        System.out.println("      ###  #  # #### #### #### ###  ");
        System.out.println("      #  # #  # #    #    #    #  # ");
        System.out.println("      #  # #  # #    #    #    #  # ");
        System.out.println("      ###  #  # ###  ###  ###  ###  ");
        System.out.println("      #  # #  # #    #    #    #  # ");
        System.out.println("      #  # #  # #    #    #    #  # ");
        System.out.println("      ###   ##  #    #    #### #  # ");
        System.out.println("");
        System.out.println("     #   #  ##   ### ##### #### ### ");
        System.out.println("     ## ## #  # #      #   #    #  #");
        System.out.println("     # # # #  # #      #   #    #  #");
        System.out.println("     #   # ####  ##    #   ###  ### ");
        System.out.println("     #   # #  #    #   #   #    #  #");
        System.out.println("     #   # #  #    #   #   #    #  #");
        System.out.println("     #   # #  # ###    #   #### #  #");
        System.out.println("");
        System.out.println("             ##   ##   ##   #       ");
        System.out.println("            #  # #  # #  # ##       ");
        System.out.println("            #  # #  # #  #  #       ");
        System.out.println("             ### #  # #  #  #       ");
        System.out.println("               # #  # #  #  #       ");
        System.out.println("            #  # #  # #  #  #       ");
        System.out.println("             ##   ##   ##   #       ");
        System.out.println("\n\n\n");
        
        
        int finalVolume = 0;
        int volumeRemaining = 0;
        
        System.out.print("Please give a name for your buffer: ");
        String bufferName = reader.nextLine();
        
        
        while (true) {
            System.out.print("\nPlease give the final volume of your buffer in ml: ");
            String input = reader.nextLine();
            if (isPositiveInteger(input)) {
                finalVolume = Integer.parseInt(input);
                volumeRemaining = finalVolume;
                break;
            } else {
                System.out.println("Incorrect input.");
            }
        }
        
        while (true) {
            System.out.println("\nWould you like to\n");
            System.out.println("(1) Add a component by diluting a stock solution");
            System.out.println("(2) Add a solid component");
            System.out.println("(q) Quit and show summary if possible\n");
            System.out.print("Selection: ");
            String selection = reader.nextLine();
            System.out.println("");
            
            if (selection.equals("1")) {
                double initialConcentration = 0;
                double finalConcentration = 0;
                
                System.out.print("Please give the name of the component: ");
                String componentName = reader.nextLine();
                
                
                System.out.print("\nPlease give the concentration of the stock solution in millimolar (mM): ");
                initialConcentration = readDouble(reader);
                System.out.println("");
                
                System.out.print("Please give the final concentration of the component in the buffer in millimolar (mM): ");
                finalConcentration = readDouble(reader);
                readString(reader);
                System.out.println("");
                
                double volumeToAdd = calculateVolume(finalVolume, initialConcentration, finalConcentration);
                
                if (volumeToAdd < volumeRemaining) {
                    volumeRemaining -= volumeToAdd;
                    amounts.add(volumeToAdd);
                    components.add(componentName);
                    System.out.println("The volume of stock solution you need to add is: " + volumeToAdd + " ml");
                } else {
                    System.out.println("There is not enough volume left in the buffer for this addition.");
                }
                
                
            } else if (selection.equals("2")) {
                double molarMass = 0;
                double finalConcentration = 0;
                
                System.out.print("Please give the name of the component: ");
                String componentName = reader.nextLine();
                components.add(componentName);
                
                System.out.print("\nPlease give the molar mass of the component in grams per mole: ");
                molarMass = readDouble(reader);
                
                System.out.println("");
                
                System.out.print("Please give the final concentration of the component in the buffer in millimolar (mM): ");
                finalConcentration = readDouble(reader);
                readString(reader);
                System.out.println("");
                
                
                
                double massToAdd = calculateMass(finalVolume, molarMass, finalConcentration);
                amounts.add(massToAdd);
                System.out.println("The mass of component you need to add is: " + massToAdd + " g");
                
                
            } else if (selection.equals("q")) {
                break;
            } else if (selection.equals("x")) {
                
                readDouble(reader);
                System.out.println("");
                System.out.println(readString(reader));
                
            }
            
        }
        
        if (!components.isEmpty()) {
            System.out.println("\nSummary\n");
            System.out.println("Buffer name: " + bufferName);
            System.out.println("\nComponents\n");
        
            for (int x = 0; x < components.size(); x++) {
                System.out.println(components.get(x) + " " + amounts.get(x));
            }
            System.out.println("Water " + volumeRemaining);
            System.out.println("-----------------------------\n"
                    + "Total " + finalVolume);
        }
        
        System.out.println("\n\nThank you for using BufferMaster9001");
        
        
        
        
        
        
    }
    
    public static double calculateVolume(double finalVolume, double startingConcentration, double finalConcentration) {
        return (finalVolume * finalConcentration / startingConcentration);
    }
    
    public static double calculateMass(double finalVolume, double molarMass, double finalConcentration) {
        return ((finalVolume / 1000) * molarMass * (finalConcentration / 1000));
    }
    
    public static boolean isPositiveInteger(String value) {
        try {
            Integer possibleNumber = Integer.parseInt(value);
            if (possibleNumber > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public static double readDouble(Scanner reader) {
        
        double value = 0;
        while (true) {
            
            value = reader.nextDouble();
            if (value <= 0) {
                System.out.println("\nThe value must be greater than 0.");
            } else {
                break;
            }
        }
        
        return value;
    }
    
    public static String readString(Scanner reader) {
        
        String value = reader.nextLine();
//        
        return value;
    }
    
}
    

