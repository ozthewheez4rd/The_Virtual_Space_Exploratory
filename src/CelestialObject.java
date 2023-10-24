import java.io.Serializable;
public abstract class CelestialObject implements Serializable {
    private String name;
    private double size;
    private double mass;

    public CelestialObject(String name, double mass, double size ) {
        this.name = name;
        this.size = size;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public double getMass() {
        return mass;
    }

    //Common methods that can be overridden by subclasses
    public abstract void explore();
}

