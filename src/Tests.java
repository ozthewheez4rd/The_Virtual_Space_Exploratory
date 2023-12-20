import org.junit.Test;

import java.util.ArrayList;

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

}
