import java.io.Serializable;
import java.util.Scanner;

public class BlackHole extends CelestialObject implements Serializable {


    public BlackHole(String name, String mass, String specs, String res, double size, double temperature, double luminosity, double criticalMass) {
        super("Blackhole", name, mass, specs, res, size, "", temperature, luminosity, criticalMass);

    }



    public static void addBlackHole(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Blackhole: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Blackhole (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Blackhole: ");
        String specs = scanner.next();

        System.out.print("Enter the resources of the Blackhole: ");
        String res = scanner.next();

        System.out.print("Enter the radius of the Blackhole(in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the temperature of the BlackHole (in K): ");
        double temperature = scanner.nextInt();

        System.out.print("Enter the luminosity of the BlackHole (in watts): ");
        double luminosity = scanner.nextDouble();

        System.out.print("Enter the critical mass of the BlackHole (in kg): ");
        double criticalMass = scanner.nextDouble();

        repository.addCelestialObject(new BlackHole(name, mass, specs, res, radius, temperature, luminosity, criticalMass));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the BlackHole " + getName() + " with a temperature of " + getTemperature() + " Celsius" + ". " + "It's luminosity is " + getLuminosity() + " and the critical mass situated at " + getCriticalMass() +
                ". It has specifications: " + getSpecs() + ", resources: " + getRes());
    }
}

