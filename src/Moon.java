import java.io.Serializable;
import java.util.Scanner;

public class Moon extends CelestialObject implements Serializable {


    public Moon(String name, String mass, String specs, String res, double size, double temperature, double luminosity, double criticalMass) {
        super("Moon", name, mass, specs, res, size, "", temperature, luminosity, criticalMass);

    }



    public static void addMoon(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Moon: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Moon (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Moon: ");
        String specs = scanner.next();

        System.out.print("Enter the resources of the Moon: ");
        String res = scanner.next();

        System.out.print("Enter the radius of the Moon(in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the temperature of the Moon (in K): ");
        double temperature = scanner.nextInt();

        System.out.print("Enter the luminosity of the Moon (in watts): ");
        double luminosity = scanner.nextDouble();

        System.out.print("Enter the critical mass of the Moon (in kg): ");
        double criticalMass = scanner.nextDouble();

        repository.addCelestialObject(new Moon(name, mass, specs, res, radius, temperature, luminosity, criticalMass));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the Moon " + getName() + " with a temperature of " + getTemperature() + " Celsius" + ". " + "It's luminosity is " + getLuminosity() + " and the critical mass situated at " + getCriticalMass() +
                ". It has specifications: " + getSpecs() + ", resources: " + getRes());
    }
}


