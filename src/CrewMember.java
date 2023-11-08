import java.io.Serializable;
import java.util.Scanner;

public class CrewMember implements Serializable {
    private String name;
    private String position;
    private Body body;

    public CrewMember(String name, String position) {
        this.name = name;
        this.position = position;
        this.body = new Body();
    }

    public static void addCrewMember(CrewMemberRepo repository, Scanner scanner) {
        System.out.print("Enter Crew Member's Name: ");
        String name = scanner.next();
        System.out.print("Enter Crew Member's Position: ");
        String position = scanner.next();

        repository.addCrewMember(new CrewMember(name, position));
    }
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getStatus() {
        boolean isHealthy = body.isHealthy();
        return isHealthy ? "Healthy" : "Injured";
    }

    public String getTreatmentMessage() {
        if (!body.isHealthy()) {
            return name + " needs treatment";
        }
        return null;
    }

    public Body getBody() {
        return body;
    }

    public void explore(){
            System.out.println(getName() + "'s Status: " + getStatus());
            System.out.println("Body Parts Status:");
            System.out.println("Torso: " + getBody().getTorso());
            System.out.println("Head: " + getBody().getHead());
            System.out.println("Left Arm: " + getBody().getLeftArm());
            System.out.println("Right Arm: " + getBody().getRightArm());
            System.out.println("Left Leg: " + getBody().getLeftLeg());
            System.out.println("Right Leg: " + getBody().getRightLeg());
            String treatmentMessage = getTreatmentMessage();
            if (treatmentMessage != null) {
                System.out.println(treatmentMessage);

        }
    }
}