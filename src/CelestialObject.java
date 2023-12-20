import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class CelestialObject implements Serializable {
    private String type;
    private String name;
    private String mass;
    private String specs;
    private HashSet<Resource> resources = new HashSet<>();
    private double size;
    private String composition;
    private double temperature;
    private double luminosity;
    private double criticalMass;

    public CelestialObject(String type, String name, String mass, String specs, HashSet<Resource> resources, double size, String composition, double temperature, double luminosity, double criticalMass) {
        this.type = type;
        this.name = name;
        this.mass = mass;
        this.specs = specs;
        this.resources.addAll(resources);
        this.size = size;
        this.composition = composition;
        this.temperature = temperature;
        this.luminosity = luminosity;
        this.criticalMass = criticalMass;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getMass() {
        return mass;
    }

    public String getSpecs() {
        return specs;
    }

    public HashSet<Resource> getResources() {
        return resources;
    }

    public List<String> getResourceNames() {
        List<String> resourceNames = new ArrayList<>();
        for (Resource resource : resources) {
            resourceNames.add(resource.getName());
        }
        return resourceNames;
    }



    public double getSize() {
        return size;
    }

    public String getComposition() {
        return composition;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public double getCriticalMass() {
        return criticalMass;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void removeResource(Resource resource) {
        resources.remove(resource);
    }

    // Common methods that can be overridden by subclasses
    public abstract void explore();
}


