
package ui;


import java.util.ArrayList;
import java.util.Scanner;
import objects.Buffer;
import objects.Calculator;


public class ui {
    
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        Calculator calculator = new Calculator();
        ArrayList<Buffer> buffers = new ArrayList<>();
        
        
        
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
        
        
        
        
        System.out.println("Welcome to BufferMaster9001!\n");
        
        while (true) {
            
            System.out.println("Would you like to...\n");
            System.out.println("(1) create a new buffer");
            System.out.println("(2) quit the program\n");
            
            System.out.print("Selection: ");
            String selection = reader.nextLine();
            
            if (selection.equals("1")) {
                
                System.out.print("\nPlease name buffer: ");
                String name = reader.nextLine();
                
                double volume;
                while (true) {
                    System.out.println("\nPlease give the final volume for the buffer: ");
                    String volumeAsString = reader.nextLine();
                    if (getPositiveDouble(volumeAsString) > 0) {
                        volume = getPositiveDouble(volumeAsString);
                        break;
                    } else {
                        
                    }
                }
                
                Buffer buffer = new Buffer(name, volume);
                
                while (true) {
                    
                }
                
            } else if (selection.equals("2")) {
                break;
            } else {
                System.out.println("Incorrect input.\n");
            }
            
            
        }
        
        
        
        
        
        System.out.println("\n\nThank you for using BufferMaster9001");
        System.out.println("");
        
        
        
        
        
        
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
    
    public static double getPositiveDouble(String input) {
        
        try {
            double d = Double.parseDouble(input);
            if (d > 0) {
                return d;
            } else {
                System.out.println("The input value needs to be greater than 0.");
            }
        } catch (Exception e) {
            System.out.println("Incorrect input.");
        }
        return 0;
    }
    
}
    

