
package objects;


public class Calculator {
    
    public double calculateVolume(double finalVolume, double startingConcentration, double finalConcentration) {
        return (finalVolume * finalConcentration / startingConcentration);
    }
    
    public double calculateMass(double finalVolume, double molarMass, double finalConcentration) {
        return ((finalVolume / 1000) * molarMass * (finalConcentration / 1000));
    }
}
