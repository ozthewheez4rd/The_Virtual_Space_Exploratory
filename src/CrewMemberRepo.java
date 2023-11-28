import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CrewMemberRepo {
    private List<CrewMember> crewMembers;
    public CrewMemberRepo() {
        crewMembers = loadCrewMembers();
    }

    public void addCrewMember(CrewMember crewMember, Scanner scanner) {
        if (!crewMembers.contains(crewMember)) {
            setBodyStatus(crewMember, scanner);
            crewMembers.add(crewMember);
            saveCrewMembers(crewMembers);
        }
    }
    public void setBodyStatus(CrewMember crewMember, Scanner scanner) {
        System.out.println("Enter Body Part Status for " + crewMember.getName() + ":");

        System.out.print("Torso (Healthy/Injured): ");
        crewMember.getBody().setTorso(scanner.next());

        System.out.print("Head (Healthy/Injured): ");
        crewMember.getBody().setHead(scanner.next());

        System.out.print("Left Arm (Healthy/Injured): ");
        crewMember.getBody().setLeftArm(scanner.next());

        System.out.print("Right Arm (Healthy/Injured): ");
        crewMember.getBody().setRightArm(scanner.next());

        System.out.print("Left Leg (Healthy/Injured): ");
        crewMember.getBody().setLeftLeg(scanner.next());

        System.out.print("Right Leg (Healthy/Injured): ");
        crewMember.getBody().setRightLeg(scanner.next());
    }


    public List<CrewMember> getAllCrewMembers() {
        return crewMembers;
    }

    // Load celestial objects from a file
    private List<CrewMember> loadCrewMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\crew_members.dat"))) {
            return (List<CrewMember>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Save crew members to a file
    private void saveCrewMembers(List<CrewMember> objects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\crew_members.dat"))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}