import java.io.Serializable;

public abstract class CelestialObject implements Serializable {
    private String type;
    private String name;
    private String mass;
    private String specs;
    private String res;
    private double size;
    private String composition;
    private double temperature;
    private double luminosity;
    private double criticalMass;

    public CelestialObject(String type, String name, String mass, String specs, String res, double size, String composition, double temperature, double luminosity, double criticalMass) {
        this.type = type;
        this.name = name;
        this.mass = mass;
        this.specs = specs;
        this.res = res;
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

    public String getRes() {
        return res;
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

    // Common methods that can be overridden by subclasses
    public abstract void explore();


}






