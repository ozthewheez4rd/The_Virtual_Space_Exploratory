import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class CelestialObjectRepo {
    private List<CelestialObject> celestialObjects;

    public CelestialObjectRepo() {
        celestialObjects = loadCelestialObjects();
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        if (!celestialObjects.contains(celestialObject)) {
            celestialObjects.add(celestialObject);
            saveCelestialObjects(celestialObjects);
        }
    }


    public List<CelestialObject> getAllCelestialObjects() {
        return celestialObjects;
    }

    // Load celestial objects from a file
    private List<CelestialObject> loadCelestialObjects() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("celestial_objects.dat"))) {
            return (List<CelestialObject>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Save celestial objects to a file
    private void saveCelestialObjects(List<CelestialObject> objects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("celestial_objects.dat"))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
