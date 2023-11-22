import java.util.HashSet;

// Proxy class for CelestialObject
public class CelestialObjectProxy extends CelestialObject {
    private boolean isRealObjectInitialized = false;

    public CelestialObjectProxy(String name, double mass, double size) {
        super(name, mass, size);
    }

    // Lazy initialization of the real CelestialObject
    private void initializeRealObject() {
        if (!isRealObjectInitialized) {
            System.out.println("Initializing the real CelestialObject...");
            // Additional logic for initialization if needed
            isRealObjectInitialized = true;
        }
    }

    @Override
    public void explore() {
        // Log before exploration
        System.out.println("Logging: Before exploring " + getName());

        // Lazy initialization of the real CelestialObject
        initializeRealObject();

        // Actual exploration logic
        System.out.println("Exploring the celestial object " + getName());

        // Log after exploration
        System.out.println("Logging: After exploring " + getName());
    }

    // Proxy class does not have access to the real resources
    @Override
    public HashSet<Resource> getResources() {
        throw new UnsupportedOperationException("Proxy does not have access to real resources");
    }

    // Proxy class does not have access to the real addResource operation
    @Override
    public void addResource(Resource resource) {
        throw new UnsupportedOperationException("Proxy does not have access to real addResource operation");
    }

    // Proxy class does not have access to the real removeResource operation
    @Override
    public void removeResource(Resource resource) {
        throw new UnsupportedOperationException("Proxy does not have access to real removeResource operation");
    }
}
