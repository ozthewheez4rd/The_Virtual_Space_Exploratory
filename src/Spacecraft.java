import java.io.Serializable;

public class Spacecraft implements Serializable{
    private String name;
    private double health;
    private double fuel;


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
}