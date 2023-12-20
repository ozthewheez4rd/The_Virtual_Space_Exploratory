import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void testAddCrewMember() {
        CrewMemberRepo crewMemberRepo = new CrewMemberRepo();

        // Create a CrewMember object with predefined body statuses
        CrewMember crewMember = new CrewMember("John Doe", "Astronaut");
        crewMember.getBody().setTorso("Healthy");
        crewMember.getBody().setHead("Healthy");
        crewMember.getBody().setLeftArm("Healthy");
        crewMember.getBody().setRightArm("Healthy");
        crewMember.getBody().setLeftLeg("Healthy");
        crewMember.getBody().setRightLeg("Healthy");


        assertFalse(crewMemberRepo.getAllCrewMembers().contains(crewMember));


        crewMemberRepo.getAllCrewMembers().add(crewMember);


        assertTrue(crewMemberRepo.getAllCrewMembers().contains(crewMember));


        System.out.println("Test Add Crew Member passed!");
    }

    @Test
    public void testAddCargo() {
        CargoRepo cargoRepo = new CargoRepo();


        Cargo cargo = new Cargo("Iron", 10, 50, new ArrayList<>());


        assertFalse(cargoRepo.getAllCargo().contains(cargo));


        cargoRepo.getAllCargo().add(cargo);


        assertTrue(cargoRepo.getAllCargo().contains(cargo));


        System.out.println("Test Add Cargo passed!");
    }

    @Test
    public void testCrewMemberDecorator() {
        // Create a CrewMember object
        CrewMember crewMember = new CrewMember("John Doe", "Astronaut");

        // Create a CrewMemberDecorator object with additional equipment
        CrewMemberDecorator decoratedMember = new CrewMemberDecorator(crewMember, "Helmet1", "Shield2");

        // Check that the decorator retains the original CrewMember details
        assertEquals("John Doe", decoratedMember.getName());
        assertEquals("Astronaut", decoratedMember.getPosition());

        // Check the additional equipment details
        assertEquals("Helmet1", decoratedMember.getHelmet());
        assertEquals("Shield2", decoratedMember.getShield());

        // Print a message or assertion result
        System.out.println("Test CrewMemberDecorator passed!");
    }

    @Test
    public void getNextAvailableID_shouldReturnNextID() {
        // Assuming you have a CelestialObjectRepo instance for testing
        CelestialObjectRepo repo = new CelestialObjectRepo();

        // Save a celestial object to the database to ensure there's an ID assigned
        CelestialObject testObject = new CelestialObjectProxy(
                "Star", "TestStar", "10", "TestSpecs",
                new HashSet<>(Arrays.asList(new Resource("Resource1"), new Resource("Resource2"))),
                100.0, "TestComposition", 5000.0, 20000.0, 50.0
        );
        repo.saveCelestialObject(testObject);

        // Get the next available ID
        int nextID = repo.getNextAvailableID();

        // Ensure that the nextID is greater than 1 (assuming the initial ID is 1)
        assertTrue(nextID > 1);
    }

    @Test
    public void loadCelestialObjects_shouldLoadObjectsFromDatabase() {
        // Assuming you have a CelestialObjectRepo instance for testing
        CelestialObjectRepo repo = new CelestialObjectRepo();

        // Create a CelestialObject for testing
        CelestialObject testObject = new CelestialObjectProxy(
                "Star", "TestStar", "10", "TestSpecs",
                new HashSet<>(Arrays.asList(new Resource("Resource1"), new Resource("Resource2"))),
                100.0, "TestComposition", 5000.0, 20000.0, 50.0
        );

        // Save the celestial object to the database
        repo.saveCelestialObject(testObject);

        // Load celestial objects from the database
        List<CelestialObject> loadedObjects = repo.loadCelestialObjects();

        // Ensure that the loadedObjects list is not null and contains at least one object
        assertNotNull(loadedObjects);
        assertFalse(loadedObjects.isEmpty());

        // Find the loaded object in the list by its name
        CelestialObject loadedObject = loadedObjects.stream()
                .filter(obj -> "TestStar".equals(obj.getName()))
                .findFirst()
                .orElse(null);

        // Ensure that the loaded object is not null
        assertNotNull(loadedObject);

        // Assert the properties of the loaded object
        assertEquals("Star", loadedObject.getType());
        assertEquals("TestStar", loadedObject.getName());
        assertEquals("10", loadedObject.getMass());
        assertEquals("TestSpecs", loadedObject.getSpecs());

        // Assert the resources of the loaded object
        Set<String> loadedResourceNames = loadedObject.getResources().stream()
                .map(Resource::toString)
                .collect(Collectors.toSet());

        assertTrue(loadedResourceNames.contains("Resource1"));
        assertTrue(loadedResourceNames.contains("Resource2"));

        assertEquals(100.0, loadedObject.getSize(), 0.001);
        assertEquals("TestComposition", loadedObject.getComposition());
        assertEquals(5000.0, loadedObject.getTemperature(), 0.001);
        assertEquals(20000.0, loadedObject.getLuminosity(), 0.001);
        assertEquals(50.0, loadedObject.getCriticalMass(), 0.001);
    }

}
