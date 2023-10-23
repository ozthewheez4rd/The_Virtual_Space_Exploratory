import java.io.Serializable;
public class Star extends CelestialObject implements Serializable {
    private double temperature;
    private double luminosity;
    private double criticalMass;

    public Star(String name, double size, double mass, double temperature, double criticalMass, double luminosity) {
        super(name, size, mass);
        this.temperature = temperature;
        this.criticalMass = criticalMass;
        this.luminosity = luminosity;
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

    @Override
    public void explore() {
        System.out.println("Exploring the star " + getName() + " with a temperature of " + getTemperature() + " Celsius" + ". " + "It's luminosity is " + getLuminosity() + " and the critical mass situated at " + getCriticalMass() + ". ");
    }
}
