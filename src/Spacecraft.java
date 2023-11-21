import java.io.Serializable;

public class Spacecraft implements Serializable{
    private String name;
    private double health;
    private double fuel;
    private static SpacecraftConfig spacecraftConfig = SpacecraftConfig.getInstance();

    public Spacecraft(String name, double health, double fuel){
        this.name = name;
        this.fuel = fuel;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setHealth() {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public void setFuel() {
        this.fuel = fuel;
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
}