import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cargo implements Serializable {
    private String name;
    private int quantity;
    private double value;
    private List<Resource> resources;

    public Cargo(String name, int quantity, double value, List<Resource> resources) {
        this.name = name;
        this.quantity = quantity;
        this.value = value;
        this.resources = resources;
    }

    public static void addCargo(CargoRepo repository, Scanner scanner) {
        System.out.print("Enter Cargo Description: ");
        String name = scanner.next();
        System.out.print("Enter Cargo Quantity: ");
        int quantity = Integer.parseInt(scanner.next());
        System.out.print("Enter Cargo Market Value: ");
        double value = Double.parseDouble(scanner.next());

        // Assuming you have a method to add resources to the cargo
        List<Resource> resources = new ArrayList<>();
        // Add logic to populate the resources list

        repository.addCargo(new Cargo(name, quantity, value, resources));
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValue() {
        return value;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void removeResource(Resource resource) {
        resources.remove(resource);
    }
}
