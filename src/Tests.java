import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        testManageCrew();
        testManageCargo();
    }

    private static void testManageCrew() {
        System.out.println("Testing manageCrew method:");

        // Instantiate your repositories
        CrewMemberRepo repositoryCrew = new CrewMemberRepo();

        // Create a test instance of the Main class
        Main main = new Main();

        // Add a crew member for testing
        CrewMember.addCrewMember(repositoryCrew, new Scanner(System.in));

        // Call the manageCrew method
        main.manageCrew(repositoryCrew, new Scanner(System.in));

        // Assert that the repository is not empty
        assert !repositoryCrew.getAllCrewMembers().isEmpty() : "Crew repository should not be empty";

        System.out.println("Manage Crew method test complete.\n");
    }

    private static void testManageCargo() {
        System.out.println("Testing manageCargo method:");

        // Instantiate your repositories
        CargoRepo repositoryCargo = new CargoRepo();

        // Create a test instance of the Main class
        Main main = new Main();

        // Add cargo for testing
        Cargo.addCargo(repositoryCargo, new Scanner(System.in));

        // Call the manageCargo method
        main.manageCargo(repositoryCargo, new Scanner(System.in));

        // Assert that the repository is not empty
        assert !repositoryCargo.getAllCargo().isEmpty() : "Cargo repository should not be empty";

        System.out.println("Manage Cargo method test complete.\n");
    }
}
