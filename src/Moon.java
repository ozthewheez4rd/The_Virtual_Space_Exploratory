import java.io.Serializable;

public class Moon extends CelestialObject implements Serializable {
    private double temperature;
    private double criticalMass;
    private double luminosity;

    public Moon(String name, double size, double mass, double temperature, double criticalMass, double luminosity) {
        super(name, size, mass);
        this.temperature = temperature;
        this.criticalMass = criticalMass;
        this.luminosity = luminosity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getCriticalMass() {
        return criticalMass;
    }

    public double getLuminosity() {
        return luminosity;
    }

    @Override
    public void explore() {
        System.out.println("Exploring the moon " + getName() + " with a temperature of " + getTemperature() + " Celsius. It has a critical mass of " + getCriticalMass() + " kg and a luminosity of " + getLuminosity() + " watts.");
    }
}
