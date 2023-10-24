import java.io.Serializable;
import java.util.Scanner;

public class Planet extends CelestialObject implements Serializable {
    private String composition;

    public Planet(String name, double size, double mass, String composition) {
        super(name, size, mass);
        this.composition = composition;
    }

    public String getComposition() {
        return composition;
    }

    public static void addPlanet(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the planet: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the planet (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the planet (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the composition of the planet: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Planet(name, radius, mass, composition));
    }


    @Override
    public void explore() {
        System.out.println("Exploring the planet " + getName() + " with a composition of " + getComposition() + ". It has a radius of " + getSize() + " km and a mass of " + getMass() + " kg.");
    }
}
