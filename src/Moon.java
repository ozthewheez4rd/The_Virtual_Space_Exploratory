import java.io.Serializable;
import java.util.Scanner;

public class Moon extends CelestialObject implements Serializable {
    private double temperature;
    private double criticalMass;
    private double luminosity;

    public Moon(String name, double size, String mass, double temperature, double criticalMass, double luminosity) {
        super(name, mass, size);
        this.temperature = temperature;
        this.criticalMass = criticalMass;
        this.luminosity = luminosity;
    }

    // Adjusting the getter method to return a string
    public String getMass() {
        return mass;
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

    public static void addMoon(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the moon: ");
        String moonName = scanner.next();

        System.out.print("Enter the radius of the moon (in km): ");
        double moonRadius = scanner.nextDouble();

        System.out.print("Enter the mass of the moon (in kg): ");
        String moonMass = scanner.next(); // Change to read a string

        System.out.print("Enter the temperature of the moon (in Celsius): ");
        double moonTemperature = scanner.nextDouble();

        System.out.print("Enter the critical mass of the moon (in kg): ");
        double moonCriticalMass = scanner.nextDouble();

        System.out.print("Enter the luminosity of the moon (in watts): ");
        double moonLuminosity = scanner.nextDouble();

        repository.addCelestialObject(new Moon(moonName, moonRadius, moonMass, moonTemperature, moonCriticalMass, moonLuminosity));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the moon " + getName() + " with a temperature of " + getTemperature() + " Celsius. It has a critical mass of " + getCriticalMass() + " kg and a luminosity of " + getLuminosity() + " watts.");
    }
}
