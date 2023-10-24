import java.io.Serializable;
import java.util.Scanner;

public class Asteroid extends CelestialObject implements Serializable {
    private String composition;

    public Asteroid(String name, double size, double mass, String composition) {
        super(name, size, mass);
        this.composition = composition;
    }

    public String getComposition() {
        return composition;
    }

    public static void addAsteroid(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the asteroid: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the asteroid (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the asteroid (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the composition of the asteroid: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Asteroid(name, radius, mass, composition));
    }

    @Override
    public void explore() {
        System.out.println("Exploring the asteroid " + getName() + " with a composition of " + getComposition() + ". It has a radius of " + getSize() + " km and a mass of " + getMass() + " kg.");
    }
}
