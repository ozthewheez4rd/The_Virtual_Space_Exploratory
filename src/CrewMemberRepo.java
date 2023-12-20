//import java.io.*;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class CrewMemberRepo {
//    private List<CrewMember> crewMembers;
//    public CrewMemberRepo() {
//        crewMembers = loadCrewMembers();
//    }
//
//    public void addCrewMember(CrewMember crewMember, Scanner scanner) {
//        if (!crewMembers.contains(crewMember)) {
//            setBodyStatus(crewMember, scanner);
//            crewMembers.add(crewMember);
//            saveCrewMembers(crewMembers);
//        }
//    }
//    public void setBodyStatus(CrewMember crewMember, Scanner scanner) {
//        System.out.println("Enter Body Part Status for " + crewMember.getName() + ":");
//
//        System.out.print("Torso (Healthy/Injured): ");
//        crewMember.getBody().setTorso(scanner.next());
//
//        System.out.print("Head (Healthy/Injured): ");
//        crewMember.getBody().setHead(scanner.next());
//
//        System.out.print("Left Arm (Healthy/Injured): ");
//        crewMember.getBody().setLeftArm(scanner.next());
//
//        System.out.print("Right Arm (Healthy/Injured): ");
//        crewMember.getBody().setRightArm(scanner.next());
//
//        System.out.print("Left Leg (Healthy/Injured): ");
//        crewMember.getBody().setLeftLeg(scanner.next());
//
//        System.out.print("Right Leg (Healthy/Injured): ");
//        crewMember.getBody().setRightLeg(scanner.next());
//    }
//
//
//    public List<CrewMember> getAllCrewMembers() {
//        return crewMembers;
//    }
//
//    // Load celestial objects from a file
//    private List<CrewMember> loadCrewMembers() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\crew_members.dat"))) {
//            return (List<CrewMember>) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            return new ArrayList<>();
//        }
//    }
//
//    // Save crew members to a file
//    private void saveCrewMembers(List<CrewMember> objects) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Oana\\IdeaProjects\\MAP\\crew_members.dat"))) {
//            oos.writeObject(objects);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewMemberRepo {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/spacecraft_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private List<CrewMember> crewMembers;

    public CrewMemberRepo() {
        crewMembers = loadCrewMembers();
    }

    public void addCrewMember(CrewMember crewMember, Scanner scanner) {
        if (!crewMembers.contains(crewMember)) {
            setBodyStatus(crewMember, scanner);
            crewMembers.add(crewMember);
            saveCrewMember(crewMember);
        }
    }

    public List<CrewMember> getAllCrewMembers() {
        return crewMembers;
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

    private List<CrewMember> loadCrewMembers() {
        List<CrewMember> members = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM CrewMembers");

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String position = resultSet.getString("Position");

                CrewMember crewMember = new CrewMember(name, position);
                crewMember.getBody().setTorso(resultSet.getString("TorsoStatus"));
                crewMember.getBody().setHead(resultSet.getString("HeadStatus"));
                crewMember.getBody().setLeftArm(resultSet.getString("LeftArmStatus"));
                crewMember.getBody().setRightArm(resultSet.getString("RightArmStatus"));
                crewMember.getBody().setLeftLeg(resultSet.getString("LeftLegStatus"));
                crewMember.getBody().setRightLeg(resultSet.getString("RightLegStatus"));

                members.add(crewMember);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;
    }

    private void saveCrewMember(CrewMember crewMember) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO CrewMembers (Name, Position, TorsoStatus, HeadStatus, LeftArmStatus, RightArmStatus, LeftLegStatus, RightLegStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, crewMember.getName());
            preparedStatement.setString(2, crewMember.getPosition());
            preparedStatement.setString(3, crewMember.getBody().getTorso());
            preparedStatement.setString(4, crewMember.getBody().getHead());
            preparedStatement.setString(5, crewMember.getBody().getLeftArm());
            preparedStatement.setString(6, crewMember.getBody().getRightArm());
            preparedStatement.setString(7, crewMember.getBody().getLeftLeg());
            preparedStatement.setString(8, crewMember.getBody().getRightLeg());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
