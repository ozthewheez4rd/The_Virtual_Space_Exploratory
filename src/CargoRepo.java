import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class CargoRepo {
    private List<Cargo> cargoList;
    public CargoRepo() {
        cargoList = loadCargoData();
    }

    public void addCargo(Cargo cargo) {
        if (!cargoList.contains(cargo)) {
            cargoList.add(cargo);
            saveCargoData(cargoList);
        }
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

    // Save crew members to a file
    private void saveCargoData(List<Cargo> objects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\cargo.dat"))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}