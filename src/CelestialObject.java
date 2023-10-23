public abstract class CelestialObject {
    private String name;
    private double size;
    private double mass;

    public CelestialObject(String name, double type, double size ) {
        this.name = name;
        this.size = size;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getsize() {
        return size;
    }

    public double getMass() {
        return mass;
    }

    //Common methods that can be overridden by subclasses
    public abstract void explore();
}

