import java.util.HashMap;
import java.util.Map;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Spaceship {
    private String name;
    private double hullHealth;
    private double fuel;
    private double currentCargoLoad;
    private double maxCargoCapacity;
    private ResourceRepo resourceRepo;
    private Map<String, Integer> cargo;

    public Spaceship(String name, double hullHealth, double fuel, double maxCargoCapacity) {
        this.name = name;
        this.fuel = fuel;
        this.hullHealth = hullHealth;
        this.maxCargoCapacity = maxCargoCapacity;
        this.currentCargoLoad = 0.0;
        this.cargo = new HashMap<>();
        this.resourceRepo = new ResourceRepo();
    }

    public String getName() {
        return name;
    }

    public double getHullHealth() {
        return hullHealth;
    }

    public double getFuel() {
        return fuel;
    }

    public double getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    public double getCurrentCargoLoad() {
        return currentCargoLoad;
    }

    public Map<String, Integer> getCargo() {
        return new HashMap<>(cargo);
    }

    public double getResourcePrice(String resourceName) {
        return resourceRepo.getPricePerUnit(resourceName);
    }

    public void addResourceToCargo(String resourceName, int quantity) {
        int currentQuantity = cargo.getOrDefault(resourceName, 0);
        cargo.put(resourceName, currentQuantity + quantity);
        currentCargoLoad += quantity;
    }

    public boolean canAddResource(String resourceName, int quantity) {
        return currentCargoLoad + quantity <= maxCargoCapacity;
    }

    public void saveResourceRepo() {
        try (FileOutputStream fileOut = new FileOutputStream("ResourceRepo.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(resourceRepo);
            System.out.println("ResourceRepo has been saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
