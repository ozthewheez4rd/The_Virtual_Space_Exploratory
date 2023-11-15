import java.util.HashSet;
import java.util.Set;

public class Resource {
    private String name;
    private Set<CelestialObject> celestialObjects = new HashSet<>();

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        celestialObjects.add(celestialObject);
        celestialObject.getResources().add(this);
    }

    public void removeCelestialObject(CelestialObject celestialObject) {
        celestialObjects.remove(celestialObject);
        celestialObject.getResources().remove(this);
    }
}
