import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Create an instance of the CelestialObjectRepo
        CelestialObjectRepo repository = new CelestialObjectRepo();

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
                case 6:
                    // Add Entries
                    addEntry(repository, scanner);
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
                    addStar(repository, scanner);
                    break;
                case 2:
                    addPlanet(repository, scanner);
                    break;
                case 3:
                    addMoon(repository, scanner);
                    break;
                case 4:
                    addAsteroid(repository, scanner);
                    break;
                case 5:
                    addComet(repository, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (objectChoice != 0);
    }

    // Implementations for adding celestial objects

    private static void addStar(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the star: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the star (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the star (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the temperature of the star (in K): ");
        int temperature = scanner.nextInt();

        System.out.print("Enter the critical mass of the star (in kg): ");
        double criticalMass = scanner.nextDouble();

        System.out.print("Enter the luminosity of the star (in watts): ");
        double luminosity = scanner.nextDouble();

        repository.addCelestialObject(new Star(name, radius, mass, temperature, criticalMass, luminosity));
    }

    private static void addPlanet(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the planet: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the planet (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the planet (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the composition of the planet: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Planet(name, radius, mass, composition));
    }

    private static void addMoon(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the moon: ");
        String moonName = scanner.next();

        System.out.print("Enter the radius of the moon (in km): ");
        double moonRadius = scanner.nextDouble();

        System.out.print("Enter the mass of the moon (in kg): ");
        double moonMass = scanner.nextDouble();

        System.out.print("Enter the temperature of the moon (in Celsius): ");
        double moonTemperature = scanner.nextDouble();

        System.out.print("Enter the critical mass of the moon (in kg): ");
        double moonCriticalMass = scanner.nextDouble();

        System.out.print("Enter the luminosity of the moon (in watts): ");
        double moonLuminosity = scanner.nextDouble();

        repository.addCelestialObject(new Moon(moonName, moonRadius, moonMass, moonTemperature, moonCriticalMass, moonLuminosity));
    }

    private static void addAsteroid(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the asteroid: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the asteroid (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the asteroid (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the composition of the asteroid: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Asteroid(name, radius, mass, composition));
    }

    private static void addComet(CelestialObjectRepo repository, Scanner scanner) {
        System.out.print("Enter the name of the comet: ");
        String name = scanner.next();

        System.out.print("Enter the radius of the comet (in km): ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the mass of the comet (in kg): ");
        double mass = scanner.nextDouble();

        System.out.print("Enter the composition of the comet: ");
        String composition = scanner.next();

        repository.addCelestialObject(new Comet(name, radius, mass, composition));
    }


    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
