import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ResourceRepo implements Serializable {
    private Map<String, Double> resourcePrices;
    private static final String RESOURCE_REPO_FILE = "resource_repo.dat";

    public ResourceRepo() {
        this.resourcePrices = loadResourcePrices();
    }

    public void addResource(String resourceName, double pricePerUnit) {
        resourcePrices.put(resourceName, pricePerUnit);
        saveResourcePrices(resourcePrices);
    }

    public double getPricePerUnit(String resourceName) {
        return resourcePrices.getOrDefault(resourceName, 0.0);
    }

    // Load resource prices from a file
    private Map<String, Double> loadResourcePrices() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RESOURCE_REPO_FILE))) {
            return (Map<String, Double>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    // Save resource prices to a file
    private void saveResourcePrices(Map<String, Double> prices) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RESOURCE_REPO_FILE))) {
            oos.writeObject(prices);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other resource management methods
}
