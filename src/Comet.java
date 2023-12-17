import java.io.Serializable;
import java.util.Scanner;

public class Comet extends CelestialObject implements Serializable {


    public Comet(String name, String mass, String specs, String res, double size, String composition) {
        super("Comet ", name, mass, specs, res, size, composition, 0, 0, 0);

    }



    public static void addComet(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the Comet: ");
        String name = scanner.next();

        System.out.print("Enter the mass of the Comet (in kg): ");
        String mass = scanner.next();

        System.out.print("Enter the specifications of the Comet: ");
        String specs = scanner.next();

        System.out.print("Enter the resources of the Comet: ");
        String res = scanner.next();

        System.out.print("Enter the radius of the Comet (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the composition of the Comet: ");
        String composition = scanner.next();


        repository.addCelestialObject(new Comet(name, mass, specs, res, radius, composition));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the Comet " + getName() + " with a composition of " + getComposition() +
                ". It has specifications: " + getSpecs() + ", resources: " + getRes() +
                ". It has a radius of " + getSize() + " and a mass of " + getMass() + " kg.");
    }
}





