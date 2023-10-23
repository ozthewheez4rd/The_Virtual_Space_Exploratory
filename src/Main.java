import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Create an instance of the CelestialObjectRepo
        CelestialObjectRepo repository = new CelestialObjectRepo();

        //Populate Repository with stars
        populateRepositoryWithStars(repository);

        do {
            clearConsole();

            System.out.println("==========================================");
            System.out.println("          Space Exploration Console       ");
            System.out.println("==========================================");
            System.out.println("| [1] Explore Celestial Object           |");
            System.out.println("| [2] View Spacecraft                    |");
            System.out.println("| [3] Manage Crew                        |");
            System.out.println("| [4] Manage Cargo                       |");
            System.out.println("| [5] Spaceship Catalogue                |");
            System.out.println("| [0] Exit                               |");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Retrieve celestial objects from the repository and explore them
                    List<CelestialObject> celestialObjects = repository.getAllCelestialObjects();
                    if (celestialObjects.isEmpty()) {
                        System.out.println("No celestial objects available for exploration.");
                    } else {
                        int objectChoice;
                        do {
                            System.out.println("Select a celestial object to explore:");
                            for (int i = 0; i < celestialObjects.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + celestialObjects.get(i).getName());
                            }
                            System.out.println("[0] Exit exploration");
                            objectChoice = scanner.nextInt();
                            if (objectChoice == 0) {
                                break; // Exit the exploration loop
                            } else if (objectChoice >= 1 && objectChoice <= celestialObjects.size()) {
                                CelestialObject selectedObject = celestialObjects.get(objectChoice - 1);
                                System.out.println("Exploring " + selectedObject.getName() + ":");
                                selectedObject.explore();
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        } while (objectChoice != 0);
                    }
                    break;
                case 2:
                    // View Spacecraft
                    break;
                case 3:
                    // Manage Crew
                    break;
                case 4:
                    // Manage Cargo
                    break;
                case 5:
                    // Spaceship Catalogue
                    break;
                case 0:
                    System.out.println("Exiting Space Exploration Console.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    private static void populateRepositoryWithStars(CelestialObjectRepo repository) {
        repository.addCelestialObject(new Star("Sun", 1392684, 1989000, 5778, 1.989e30, 3.828e26));
        repository.addCelestialObject(new Star("Proxima Centauri", 197162, 0.1234, 3040, 0.123e30, 0.456e26));
        repository.addCelestialObject(new Star("Betelgeuse", 2159734, 0.44, 3500, 2.345e30, 1.678e26));
        repository.addCelestialObject(new Star("Rigel", 2354994, 0.24, 12110, 3.123e30, 2.345e26));
        repository.addCelestialObject(new Star("Aldebaran", 2159734, 0.44, 4000, 1.876e30, 1.543e26));
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
