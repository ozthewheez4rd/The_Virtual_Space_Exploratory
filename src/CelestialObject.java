import java.io.Serializable;
import java.util.HashSet;

public abstract class CelestialObject implements Serializable {
    private String name;
    private double size;
    private double mass;
    private HashSet<Resource> resources = new HashSet<>();

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

    public HashSet<Resource> getResources() {
        return resources;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
        resource.getCelestialObjects().add(this);
    }

    public void removeResource(Resource resource) {
        resources.remove(resource);
        resource.getCelestialObjects().remove(this);
    }
}
