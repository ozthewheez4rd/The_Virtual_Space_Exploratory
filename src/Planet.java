import java.io.Serializable;

public class Planet extends CelestialObject implements Serializable {
    private String composition;

    public Planet(String name, double size, double mass, String composition) {
        super(name, size, mass);
        this.composition = composition;
    }

    public String getComposition() {
        return composition;
    }

    @Override
    public void explore() {
        System.out.println("Exploring the planet " + getName() + " with a composition of " + getComposition() + ". It has a radius of " + getSize() + " km and a mass of " + getMass() + " kg.");
    }
}
