import java.io.Serializable;
import java.util.Scanner;

public class Comet extends CelestialObject implements Serializable {
    private String composition;

    public Comet(String name, double size, double mass, String composition) {
        super(name, size, mass);
        this.composition = composition;
    }

    public String getComposition() {
        return composition;
    }

    public static void addComet(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the comet: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the comet (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the comet (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the composition of the comet: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Comet(name, radius, mass, composition));
    }


    @Override
    public void explore() {
        System.out.println("Exploring the comet " + getName() + " with a composition of " + getComposition() + ". It has a radius of " + getSize() + " km and a mass of " + getMass() + " kg.");
    }
}
