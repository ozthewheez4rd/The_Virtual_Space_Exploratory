import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;

public class Star extends CelestialObject implements Serializable {

    public Star(String name, String mass, String specs, HashSet<Resource> resources, double size, double temperature, double luminosity, double criticalMass) {
        super("Star", name, mass, specs, size, "", temperature, luminosity, criticalMass);
        this.getResources().addAll(resources);
    }

    public static void addStar(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Star: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Star (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Star: ");
        String specs = scanner.next();

        // Collect resources
        HashSet<Resource> resources = new HashSet<>();
        System.out.print("Enter the number of resources for the Star: ");
        int numResources = scanner.nextInt();
        for (int i = 0; i < numResources; i++) {
            System.out.print("Enter resource " + (i + 1) + ": ");
            String resource = scanner.next();
            resources.add(new Resource(resource));
        }

        System.out.print("Enter the size of the Star: ");
        double size = scanner.nextDouble();

        System.out.print("Enter the temperature of the Star (in K): ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the luminosity of the Star (in watts): ");
        double luminosity = scanner.nextDouble();

        System.out.print("Enter the critical mass of the Star (in kg): ");
        double criticalMass = scanner.nextDouble();

        repository.addCelestialObject(new Star(name, mass, specs, resources, size, temperature, luminosity, criticalMass));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the Star " + getName() + " with a temperature of " + getTemperature() + " K" +
                ". It has a luminosity of " + getLuminosity() + " watts and the critical mass situated at " + getCriticalMass() +
                ". It has specifications: " + getSpecs() + ", resources: " + getResources());
    }
}
