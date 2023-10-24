import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Create an instance of the repositories
        CelestialObjectRepo repositoryObj = new CelestialObjectRepo();
        ResourceRepo repositoryRes = new ResourceRepo();

        // Create an instance of the Spaceship
        Spaceship spaceship = new Spaceship("Aurora", 100.0, 100.0, 200.0);

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
            System.out.println("| [6] Add Entries                        |");
            System.out.println("| [0] Exit                               |");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Retrieve celestial objects from the repository and explore them
                    List<CelestialObject> celestialObjects = repositoryObj.getAllCelestialObjects();
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
                    viewSpaceship(spaceship);
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
                case 6:
                    // Add Entries
                    addEntry(repositoryObj, scanner);
                    break;
                case 0:
                    System.out.println("Exiting Space Exploration Console.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void addEntry(CelestialObjectRepo repository, Scanner scanner) {
        int objectChoice;
        do {
            clearConsole();
            System.out.println("==========================================");
            System.out.println("           Add Celestial Object          ");
            System.out.println("==========================================");
            System.out.println("| [1] Add a Star                         |");
            System.out.println("| [2] Add a Planet                       |");
            System.out.println("| [3] Add a Moon                         |");
            System.out.println("| [4] Add an Asteroid                    |");
            System.out.println("| [5] Add a Comet                        |");
            System.out.println("| [0] Finish adding entries              |");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");
            objectChoice = scanner.nextInt();

            switch (objectChoice) {
                case 1:
                    Star.addStar(repository, scanner);
                    break;
                case 2:
                    Planet.addPlanet(repository, scanner);
                    break;
                case 3:
                    Moon.addMoon(repository, scanner);
                    break;
                case 4:
                    Asteroid.addAsteroid(repository, scanner);
                    break;
                case 5:
                    Comet.addComet(repository, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (objectChoice != 0);
    }

    private static void viewSpaceship(Spaceship spaceship) {
        clearConsole();
        System.out.println("==========================================");
        System.out.println("            Spaceship Details            ");
        System.out.println("==========================================");
        System.out.println("Name: " + spaceship.getName());
        System.out.println("Hull Health: " + spaceship.getHullHealth());
        System.out.println("Fuel: " + spaceship.getFuel());
        System.out.println("Max Cargo Capacity: " + spaceship.getMaxCargoCapacity());
        System.out.println("Current Cargo Load: " + spaceship.getCurrentCargoLoad());
        System.out.println("Cargo: " + spaceship.getCargo());
        System.out.println("Press [0] to exit the Spaceship View");
        System.out.println("==========================================");
        new Scanner(System.in).nextLine();
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
