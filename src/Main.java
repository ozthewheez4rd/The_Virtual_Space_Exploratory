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
            System.out.println("          Space Exploration Console                  Health: " + spacecraft.getHealth());
            System.out.println("                                                     Fuel:   " + spacecraft.getFuel());
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
                    // Explore Celestial Object
                    exploreCelestialObjects(repositoryObj, scanner);
                    break;
                case 2:
                    // View Spacecraft
                    break;
                case 3:
                    // Manage Crew
                    manageCrew(repositoryCrew, scanner);
                    break;
                case 4:
                    // Manage Cargo
                    manageCargo(repositoryCarg, scanner);
                    break;
                case 5:
                    // Spaceship Catalogue
                    // Implement spaceship catalog logic here
                    break;
                case 6:
                    // Add Entries
                    System.out.println("| [1] Add a Celestial Object             |");
                    System.out.println("| [2] Add a Crew Member                  |");
                    System.out.println("| [3] Add Cargo                          |");

                    int addChoice = scanner.nextInt();
                    switch (addChoice) {
                        case 1:
                            addCelestialObject(repositoryObj, scanner);
                            break;
                        case 2:
                            CrewMember.addCrewMember(repositoryCrew, scanner);
                        case 3:
                            Cargo.addCargo(repositoryCarg, scanner);
                    }

                    break;
                case 0:
                    System.out.println("Exiting Space Exploration Console.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void manageCargo(CargoRepo repository, Scanner scanner) {
        List <Cargo> cargoList = repository.getAllCargo();

        if (cargoList.isEmpty()) {
            System.out.println("Cargo is empty.");
        }else {
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
                System.out.println("We have: " + selectedObject.getQuantity() + " " + selectedObject.getName() + ". Market value is set at: " + selectedObject.getValue());
                System.out.println("Total sale value: " + (selectedObject.getQuantity() * selectedObject.getValue()));
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            } while (cargoChoice != 0);
        }
    }

    private static void exploreCelestialObjects(CelestialObjectRepo repository, Scanner scanner) {
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
    }

    private static void manageCrew(CrewMemberRepo repository, Scanner scanner) {
        List<CrewMember> crewMembers = repository.getAllCrewMembers();

        if(crewMembers.isEmpty()) {
            System.out.println("You have no crew. How though?? How did you kill all of them?!");
            CrewMember.addCrewMember(repository, scanner);
        }else{
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
                    System.out.println("Viewing " + selectedMember.getName() + ":");
                    selectedMember.explore();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (memberChoice != 0);
        }
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
