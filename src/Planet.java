import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;

public class Planet extends CelestialObject implements Serializable {

    public Planet(String name, String mass, String specs, HashSet<Resource> resources, double size, String composition) {
        super("Planet", name, mass, specs, size, composition, 0, 0, 0);
        this.getResources().addAll(resources);
    }

    public static void addPlanet(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Planet: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Planet (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Planet: ");
        String specs = scanner.next();

        // Collect resources
        HashSet<Resource> resources = new HashSet<>();
        System.out.print("Enter the number of resources for the Planet: ");
        int numResources = scanner.nextInt();
        for (int i = 0; i < numResources; i++) {
            System.out.print("Enter resource " + (i + 1) + ": ");
            String resource = scanner.next();
            resources.add(new Resource(resource));
        }

        System.out.print("Enter the radius of the Planet (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the composition of the Planet: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Planet(name, mass, specs, resources, radius, composition));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the Planet " + getName() + " with a composition of " + getComposition() +
                ". It has specifications: " + getSpecs() + ", resources: " + getResources() +
                ". It has a radius of " + getSize() + " and a mass of " + getMass() + " kg.");
    }
}






