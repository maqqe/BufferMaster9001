
package objects;

public abstract class NamedObject {
    
    public String name;
    
    public NamedObject(String name) {
        this.name = name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getName() {
        return this.name;
    }
    
}
