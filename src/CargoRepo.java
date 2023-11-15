import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CargoRepo {
    private List<Cargo> cargoList;
    private List<Resource> resourceList; // Add a list to store resources

    public CargoRepo() {
        cargoList = loadCargoData();
        resourceList = loadResourceData(); // Initialize the resource list
    }

    public void addCargo(Cargo cargo) {
        if (!cargoList.contains(cargo)) {
            cargoList.add(cargo);
            saveCargoData(cargoList);
        }
    }

    // Add a resource to the resource list
    public void addResource(Resource resource) {
        if (!resourceList.contains(resource)) {
            resourceList.add(resource);
            saveResourceData(resourceList);
        }
    }

    public List<Resource> getAllResources() {
        return resourceList;
    }

    public List<Cargo> getAllCargo() {
        return cargoList;
    }

    // Load celestial objects from a file
    private List<Cargo> loadCargoData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\cargo.dat"))) {
            return (List<Cargo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Save cargo data to a file
    private void saveCargoData(List<Cargo> objects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\cargo.dat"))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load resources from a file
    private List<Resource> loadResourceData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\resources.dat"))) {
            return (List<Resource>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Save resources to a file
    private void saveResourceData(List<Resource> resources) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\resources.dat"))) {
            oos.writeObject(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
