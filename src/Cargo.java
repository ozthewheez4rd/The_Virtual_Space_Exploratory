import java.io.Serializable;
import java.util.Scanner;
public class Cargo implements Serializable {
    private String name;
    private int quantity;
    private double value;

    public Cargo(String name, int quantity, double value){
        this.name = name;
        this.quantity = quantity;
        this.value = value;
    }

    public static void addCargo(CargoRepo repository, Scanner scanner){
        System.out.print("Enter Cargo Description: ");
        String name = scanner.next();
        System.out.print("Enter Cargo Quantity: ");
        int quantity = Integer.parseInt(scanner.next());
        System.out.print("Enter Cargo Market Value: ");
        double value = Double.parseDouble(scanner.next());

        repository.addCargo(new Cargo(name, quantity, value));
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

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
