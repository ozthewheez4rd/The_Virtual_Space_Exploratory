import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;

public class BlackHole extends CelestialObject implements Serializable {

    public BlackHole(String name, String mass, String specs, HashSet<Resource> resources, double size, double temperature, double luminosity, double criticalMass) {
        super("Blackhole", name, mass, specs, resources, size, "", temperature, luminosity, criticalMass);
    }

    public static void addBlackHole(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Black Hole: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Black Hole (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Black Hole: ");
        String specs = scanner.next();

        // Collect resources
        HashSet<Resource> resources = new HashSet<>();
        System.out.print("Enter the number of resources for the Black Hole: ");
        int numResources = scanner.nextInt();
        for (int i = 0; i < numResources; i++) {
            System.out.print("Enter resource " + (i + 1) + ": ");
            String resource = scanner.next();
            resources.add(new Resource(resource));
        }

        System.out.print("Enter the size of the Black Hole: ");
        double size = scanner.nextDouble();

        System.out.print("Enter the temperature of the Black Hole (in K): ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the luminosity of the Black Hole (in watts): ");
        double luminosity = scanner.nextDouble();

        System.out.print("Enter the critical mass of the Black Hole (in kg): ");
        double criticalMass = scanner.nextDouble();

        repository.addCelestialObject(new BlackHole(name, mass, specs, resources, size, temperature, luminosity, criticalMass));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the Black Hole " + getName() + " with a temperature of " + getTemperature() + " K" +
                ". It has a luminosity of " + getLuminosity() + " watts and the critical mass situated at " + getCriticalMass() +
                ". It has specifications: " + getSpecs() + ", resources: " + getResourceNames());
    }
}
