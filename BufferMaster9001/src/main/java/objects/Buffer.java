
package objects;

import java.util.ArrayList;
import java.util.List;


public class Buffer extends NamedObject {
    
    private List<String> components;
    private double volume;

    public Buffer(String name, double volume) {
        super(name);
        this.volume = volume;
        this.components = new ArrayList<>();
    }
    
    public void addToList(String component) {
        this.components.add(component);
    }
    
    public List<String> getComponentList() {
        return this.components;
    }
    
    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    public double getVolume() {
        return this.volume;
    }
    
    
}
