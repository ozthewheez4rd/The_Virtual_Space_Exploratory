import java.io.Serializable;
import java.util.Scanner;

public class Star extends CelestialObject implements Serializable {
    private double temperature;
    private double luminosity;
    private double criticalMass;

    public Star(String name, double size, String mass, double temperature, double criticalMass, double luminosity) {
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

    public double getLuminosity() {
        return luminosity;
    }

    public double getCriticalMass() {
        return criticalMass;
    }

    public static void addStar(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the star: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the star (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the star (in kg): ");
        String mass = scanner.next(); // Change to read a string

        System.out.print("Enter the temperature of the star (in K): ");
        int temperature = scanner.nextInt();

        System.out.print("Enter the critical mass of the star (in kg): ");
        double criticalMass = scanner.nextDouble();

        System.out.print("Enter the luminosity of the star (in watts): ");
        double luminosity = scanner.nextDouble();

        repository.addCelestialObject(new Star(name, radius, mass, temperature, criticalMass, luminosity));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the star " + getName() + " with a temperature of " + getTemperature() + " Celsius" + ". " + "It's luminosity is " + getLuminosity() + " and the critical mass situated at " + getCriticalMass() + ". ");
    }
}
