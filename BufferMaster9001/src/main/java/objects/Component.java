
package objects;

public class Component extends NamedObject {
    
    private ComponentType type;
    private Double amount;
    
    public Component(String name, ComponentType type, Double amount) {
        super(name);
        this.type = type;
        this.amount = amount;
        
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getAmount() {
        return this.amount;
    }
    
    public void setType(ComponentType type) {
        this.type = type;
    }
    
    public ComponentType getType() {
        return this.type;
    }
    
}
