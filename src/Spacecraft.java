import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Observer interface
interface SpacecraftObserver {
    void spacecraftUpdate(String message);
}

// Subject interface
interface SpacecraftSubject {
    void addObserver(SpacecraftObserver observer);
    void removeObserver(SpacecraftObserver observer);
    void notifyObservers(String message);
}
public class Spacecraft implements Serializable, SpacecraftSubject{
    private String name;
    private double health;
    private double fuel;
    private static SpacecraftConfig spacecraftConfig = SpacecraftConfig.getInstance();
    private List<SpacecraftObserver> observers = new ArrayList<>();


    public Spacecraft(String name, double health, double fuel){
        this.name = name;
        this.fuel = fuel;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int newHealth) {
        this.health = this.health - newHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setFuel(int newFuel) {
        this.fuel = this.fuel - newFuel;
    }

    public double getFuel() {
        return fuel;
    }
    public double getMaxHealth() {
        return spacecraftConfig.getMaxHealth();
    }

    public double getMaxFuel() {
        return spacecraftConfig.getMaxFuel();
    }

    public void addObserver(SpacecraftObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SpacecraftObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (SpacecraftObserver observer : observers) {
            observer.spacecraftUpdate(message);
        }
    }

    public void updateStatus(double health, double fuel) {
        this.health = health;
        this.fuel = fuel;
        notifyObservers("Status update - Health: " + health + ", Fuel: " + fuel);
    }

    static class HealthMonitor implements SpacecraftObserver {
        private String name;

        public HealthMonitor() {
        }

        @Override
        public void spacecraftUpdate(String message) {
            System.out.println("Health Monitor " + name + " received an update: " + message);
        }
    }

    static class FuelMonitor implements SpacecraftObserver {
        private String name;

        public FuelMonitor() {
        }

        @Override
        public void spacecraftUpdate(String message) {
            System.out.println("Fuel Monitor " + name + " received an update: " + message);
        }
    }
}