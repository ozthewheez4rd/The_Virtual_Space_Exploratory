import java.io.Serializable;

public class Asteroid extends CelestialObject implements Serializable {
    private String composition;

    public Asteroid(String name, double size, double mass, String composition) {
        super(name, size, mass);
        this.composition = composition;
    }

    public String getComposition() {
        return composition;
    }

    @Override
    public void explore() {
        System.out.println("Exploring the asteroid " + getName() + " with a composition of " + getComposition() + ". It has a radius of " + getSize() + " km and a mass of " + getMass() + " kg.");
    }
}
