import java.io.Serializable;
import java.util.Scanner;

public class Planet extends CelestialObject implements Serializable {


    public Planet(String name, String mass, String specs, String res, double size, String composition) {
        super("Planet ", name, mass, specs, res, size, composition, 0, 0, 0);

    }



    public static void addPlanet(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Planet: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Planet (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Planet: ");
        String specs = scanner.next();

        System.out.print("Enter the resources of the Planet: ");
        String res = scanner.next();

        System.out.print("Enter the radius of the Planet (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the composition of the Planet: ");
        String composition = scanner.next();


        repository.addCelestialObject(new Planet(name, mass, specs, res, radius, composition));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the Planet " + getName() + " with a composition of " + getComposition() +
                ". It has specifications: " + getSpecs() + ", resources: " + getRes() +
                ". It has a radius of " + getSize() + " and a mass of " + getMass() + " kg.");
    }
}





