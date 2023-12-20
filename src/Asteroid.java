import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;

public class Asteroid extends CelestialObject implements Serializable {

    public Asteroid(String name, String mass, String specs, HashSet<Resource> resources, double size, String composition) {
        super("Asteroid", name, mass, specs, resources, size, composition, 0, 0, 0);
    }

    public static void addAsteroid(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the asteroid: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the asteroid (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the asteroid: ");
        String specs = scanner.next();

        // Collect resources
        HashSet<Resource> resources = new HashSet<>();
        System.out.print("Enter the number of resources for the asteroid: ");
        int numResources = scanner.nextInt();
        for (int i = 0; i < numResources; i++) {
            System.out.print("Enter resource " + (i + 1) + ": ");
            String resource = scanner.next();
            resources.add(new Resource(resource));
        }

        System.out.print("Enter the radius of the asteroid (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the composition of the asteroid: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Asteroid(name, mass, specs, resources, radius, composition));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the asteroid " + getName() + " with a composition of " + getComposition() +
                ". It has specifications: " + getSpecs() + ", resources: " + getResourceNames() +
                ". It has a radius of " + getSize() + " and a mass of " + getMass() + " kg.");
    }
}
