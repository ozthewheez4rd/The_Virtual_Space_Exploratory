import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            clearConsole(); //To clear the console screen between menu iterations

            System.out.println("==========================================");
            System.out.println("          Space Exploration Console       ");
            System.out.println("==========================================");
            System.out.println("| [1] Explore Celestial Object           |");
            System.out.println("| [2] View Spacecraft                    |");
            System.out.println("| [3] Manage Crew                        |");
            System.out.println("| [4] Manage Cargo                       |");
            System.out.println("| [4] Spaceship Catalogue                |");
            System.out.println("| [0] Exit                               |");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    //Celestial Object
                case 2:
                    //View Spacecraft
                case 3:
                    //Manage Crew
                case 4:
                    //Manage Cargo
                case 5:
                    //Spaceship Catalogue
                case 0:
                    System.out.println("Exiting Space Exploration Console.");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        //Create a polymorphic collection of CelestialObjects
        List<CelestialObject> celestialObjects = new ArrayList<>();
        celestialObjects.add(new Star("Sun", 1392684, 1989000, 5778, 1.989e30, 3.828e26));
        celestialObjects.add(new Star("Alpha Centauri A", 1431684, 1.767e30, 5790, 2.22e31, 1.519e26));
        celestialObjects.add(new Star("Sirius", 194843, 2.02e30, 9940, 2.37e31, 2.02e28));
        celestialObjects.add(new Star("Vega", 26000, 2.34e30, 9602, 2.45e31, 5.4e27));
        celestialObjects.add(new Star("Betelgeuse", 955140, 8.6e31, 3500, 1.74e32, 9.68e29));

    }
    private static void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}