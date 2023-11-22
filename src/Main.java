import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Spacecraft spacecraft = new Spacecraft("Aurora", 100.0, 100.0);
        int choice;

        // Create an instance of the repositories
        CelestialObjectRepo repositoryObj = new CelestialObjectRepo();
        CrewMemberRepo repositoryCrew = new CrewMemberRepo();
        CargoRepo repositoryCarg = new CargoRepo();

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
                    exploreCelestialObjects(repositoryObj, scanner);
                    break;
                case 2:
                    viewSpacecraft(spacecraft);
                    break;
                case 3:
                    manageCrew(repositoryCrew, scanner);
                    break;
                case 4:
                    manageCargo(repositoryCarg, scanner);
                    break;
                case 5:
                    // Spaceship Catalogue
                    // Implement spaceship catalog logic here
                    break;
                case 6:
                    addEntriesMenu(repositoryObj, repositoryCrew, repositoryCarg, scanner);
                    break;
                case 0:
                    System.out.println("Exiting Space Exploration Console.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void exploreCelestialObjects(CelestialObjectRepo repository, Scanner scanner) {
        repository.loadCelestialObjects(); // Reload celestial objects from the database

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
                    //CelestialObject selectedObject = celestialObjects.get(objectChoice - 1);
                    //System.out.println("Exploring " + selectedObject.getName() + ":");
                    //selectedObject.explore();

                    // Use CelestialObjectProxy instead of CelestialObject
                    CelestialObject selectedObject = celestialObjects.get(objectChoice - 1);
                    CelestialObjectProxy proxy = new CelestialObjectProxy(selectedObject.getName(), selectedObject.getMass(), selectedObject.getSize());
                    System.out.println("Exploring " + proxy.getName() + ":");
                    proxy.explore();
                    selectedObject.explore();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (objectChoice != 0);
        }
    }


    private static void viewSpacecraft(Spacecraft spacecraft) {
        System.out.println("==========================================");
        System.out.println("              Spacecraft Overview                  ");
        System.out.println("==========================================");
        System.out.println("Name: " + spacecraft.getName());
        System.out.println("Health: " + spacecraft.getHealth() + "/" + spacecraft.getMaxHealth());
        System.out.println("Fuel: " + spacecraft.getFuel() + "/" + spacecraft.getMaxFuel());
        System.out.println("==========================================");
    }

    public static void manageCrew(CrewMemberRepo repository, Scanner scanner) {
        List<CrewMember> crewMembers = repository.getAllCrewMembers();

        if (crewMembers.isEmpty()) {
            System.out.println("You have no crew. How though?? How did you kill all of them?!");
            CrewMember.addCrewMember(repository, scanner);
        } else {
            int memberChoice;
            do {
                System.out.println("Select a crew member:");
                for (int i = 0; i < crewMembers.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + crewMembers.get(i).getName());
                }
                System.out.println("[0] Exit exploration");
                memberChoice = scanner.nextInt();

                if (memberChoice == 0) {
                    break; // Exit the exploration loop
                } else if (memberChoice >= 1 && memberChoice <= crewMembers.size()) {
                    CrewMember selectedMember = crewMembers.get(memberChoice - 1);
                    //System.out.println("Viewing " + selectedMember.getName() + ":");
                    //selectedMember.explore();
                    // Decorate the selected member with equipment
                    CrewMemberDecorator decoratedMember = new CrewMemberDecorator(selectedMember, "Helmet1", "Shield2");

                    // Use additional functionality related to equipment
                    //decoratedMember.additionalFunctionality();
                    System.out.println("Viewing " + selectedMember.getName() + ":");
                    selectedMember.explore();

                    // Use additional functionality related to equipment
                    decoratedMember.additionalFunctionality();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (memberChoice != 0);
        }
    }

    public static void manageCargo(CargoRepo repository, Scanner scanner) {
        List<Cargo> cargoList = repository.getAllCargo();

        if (cargoList.isEmpty()) {
            System.out.println("Cargo is empty.");
        } else {
            int cargoChoice;
            do {
                System.out.println("Select an item to inspect: ");
                for (int i = 0; i < cargoList.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + cargoList.get(i).getName());
                }
                System.out.println("[0] Exit exploration");
                cargoChoice = scanner.nextInt();

                if (cargoChoice == 0) {
                    break; // Exit the exploration loop
                } else if (cargoChoice >= 1 && cargoChoice <= cargoList.size()) {
                    Cargo selectedObject = cargoList.get(cargoChoice - 1);
                    // Adapt Cargo to CargoInfo using CargoInfoAdapter
                    CargoInfo cargoInfoAdapter = new CargoInfoAdapter(selectedObject);
                    System.out.println("We have: " + selectedObject.getQuantity() + " " + selectedObject.getName() + ". Market value is set at: " + selectedObject.getValue());
                    System.out.println("Total sale value: " + (selectedObject.getQuantity() * selectedObject.getValue()));

                    // Print information from the adapted CargoInfo instance
                    System.out.println("Adapted CargoInfo Description: " + cargoInfoAdapter.getDescription());
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (cargoChoice != 0);
        }
    }

    private static void addEntriesMenu(CelestialObjectRepo repositoryObj, CrewMemberRepo repositoryCrew, CargoRepo repositoryCarg, Scanner scanner) {
        int addChoice;
        do {
            clearConsole();
            System.out.println("==========================================");
            System.out.println("              Add Entries                  ");
            System.out.println("==========================================");
            System.out.println("| [1] Add a Celestial Object             |");
            System.out.println("| [2] Add a Crew Member                  |");
            System.out.println("| [3] Add Cargo                          |");
            System.out.println("| [0] Finish adding entries              |");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");
            addChoice = scanner.nextInt();

            switch (addChoice) {
                case 1:
                    addCelestialObject(repositoryObj, scanner);
                    break;
                case 2:
                    CrewMember.addCrewMember(repositoryCrew, scanner);
                    break;
                case 3:
                    addResourcesToCelestialObjectMenu(repositoryObj, repositoryCarg, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (addChoice != 0);
    }

    private static void addResourcesToCelestialObjectMenu(CelestialObjectRepo repositoryObj, CargoRepo repositoryCarg, Scanner scanner) {
        List<CelestialObject> celestialObjects = repositoryObj.getAllCelestialObjects();

        System.out.println("Select a celestial object: ");
        for (int i = 0; i < celestialObjects.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + celestialObjects.get(i).getName());
        }
        int objectChoice = scanner.nextInt();

        if (objectChoice >= 1 && objectChoice <= celestialObjects.size()) {
            CelestialObject selectedObject = celestialObjects.get(objectChoice - 1);
            addResourcesToCelestialObject(selectedObject, scanner, repositoryCarg);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addResourcesToCelestialObject(CelestialObject celestialObject, Scanner scanner, CargoRepo cargoRepo) {
        int resourceChoice;
        do {
            System.out.println("Select a resource to add to " + celestialObject.getName() + ":");
            List<Resource> availableResources = cargoRepo.getAllResources();

            for (int i = 0; i < availableResources.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + availableResources.get(i).getName());
            }

            System.out.println("[0] Done adding resources");
            resourceChoice = scanner.nextInt();

            if (resourceChoice == 0) {
                break; // Exit the resource adding loop
            } else if (resourceChoice >= 1 && resourceChoice <= availableResources.size()) {
                Resource selectedResource = availableResources.get(resourceChoice - 1);
                celestialObject.addResource(selectedResource);
                System.out.println(selectedResource.getName() + " added to " + celestialObject.getName());

                // Save the resource to the CargoRepo
                cargoRepo.addResource(selectedResource);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (resourceChoice != 0);
    }

    private static void addCelestialObject(CelestialObjectRepo repository, Scanner scanner) {
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

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
