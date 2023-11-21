public class SpacecraftConfig {
    private static SpacecraftConfig instance;

    private int maxHealth;
    private double maxFuel;

    private SpacecraftConfig() {
        // Initialize default values
        this.maxHealth = 100;
        this.maxFuel = 100.0;
    }

    public static SpacecraftConfig getInstance() {
        if (instance == null) {
            instance = new SpacecraftConfig();
        }
        return instance;
    }

    // Getters and setters for configuration properties

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(double maxFuel) {
        this.maxFuel = maxFuel;
    }
}
