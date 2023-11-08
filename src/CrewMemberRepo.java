import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class CrewMemberRepo {
    private List<CrewMember> crewMembers;
    public CrewMemberRepo() {
        crewMembers = loadCrewMembers();
    }

    public void addCrewMember(CrewMember crewMember) {
        if (!crewMembers.contains(crewMember)) {
            crewMembers.add(crewMember);
            saveCrewMembers(crewMembers);
        }
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