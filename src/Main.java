import java.util.Scanner;

public class SpaceExplorationApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Space Exploration Console");
            System.out.println("1. Explore Celestial Object");
            System.out.println("2. View Spacecraft");
            System.out.println("3. Manage Crew");
            System.out.println("0. Exit");
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
    }
}