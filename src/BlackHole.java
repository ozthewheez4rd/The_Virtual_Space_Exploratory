import java.io.Serializable;
import java.util.Scanner;

public class BlackHole extends CelestialObject implements Serializable {
    private double temperature;
    private double luminosity;
    private double criticalMass;

    public BlackHole(String name, double size, double mass, double temperature, double criticalMass, double luminosity) {
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

    public static void addStar(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the BlackHole: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the BlackHole (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the BlackHole (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the temperature of the BlackHole (in K): ");
        int temperature = scanner.nextInt();

        System.out.print("Enter the critical mass of the BlackHole (in kg): ");
        double criticalMass = scanner.nextDouble();

        System.out.print("Enter the luminosity of the BlackHole (in watts): ");
        double luminosity = scanner.nextDouble();

        repository.addCelestialObject(new BlackHole(name, radius, mass, temperature, criticalMass, luminosity));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the BlackHole " + getName() + " with a temperature of " + getTemperature() + " Celsius" + ". " + "It's luminosity is " + getLuminosity() + " and the critical mass situated at " + getCriticalMass() + ". ");
    }
}
