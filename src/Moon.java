import java.io.Serializable;

public class Moon extends CelestialObject implements Serializable {
    private String parentPlanet;

    public Moon(String name, double size, double mass, String parentPlanet) {
        super(name, size, mass);
        this.parentPlanet = parentPlanet;
    }

    public String getParentPlanet() {
        return parentPlanet;
    }

    @Override
    public void explore() {
        System.out.println("Exploring the moon " + getName() + " orbiting around the planet " + getParentPlanet() + ". It has a radius of " + super.getSize() + " km and a mass of " + super.getMass() + " kg.");
    }

    // Define a custom getSize() method specific to the Moon class if needed
    public double getSize() {
        return super.getSize();
    }
}
