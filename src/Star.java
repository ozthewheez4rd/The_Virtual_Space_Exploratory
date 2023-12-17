import java.io.Serializable;
import java.util.Scanner;

public class Star extends CelestialObject implements Serializable {


    public Star(String name, String mass, String specs, String res, double size, double temperature, double luminosity, double criticalMass) {
        super("Star ", name, mass, specs, res, size, "", temperature, luminosity, criticalMass);

    }



    public static void addStar(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Star: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Star in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Star: ");
        String specs = scanner.next();

        System.out.print("Enter the resources of the Star: ");
        String res = scanner.next();

        System.out.print("Enter the radius of the Star (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the temperature of the Star (in K): ");
        double temperature = scanner.nextInt();

        System.out.print("Enter the luminosity of the Star (in watts): ");
        double luminosity = scanner.nextDouble();

        System.out.print("Enter the critical mass of the Star (in kg): ");
        double criticalMass = scanner.nextDouble();

        repository.addCelestialObject(new Star(name, mass, specs, res, radius, temperature, luminosity, criticalMass));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the Star " + getName() + " with a temperature of " + getTemperature() + " Celsius" + ". " + "It's luminosity is " + getLuminosity() + " and the critical mass situated at " + getCriticalMass() +
                ". It has specifications: " + getSpecs() + ", resources: " + getRes());
    }
}

