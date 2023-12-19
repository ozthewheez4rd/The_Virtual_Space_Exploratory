import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CelestialObjectRepo {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/spacecraft_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private List<CelestialObject> celestialObjects;

    public CelestialObjectRepo() {
        celestialObjects = loadCelestialObjects();
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        if (!celestialObjects.contains(celestialObject)) {
            celestialObjects.add(celestialObject);
            saveCelestialObject(celestialObject);
        }
    }

    public List<CelestialObject> getAllCelestialObjects() {
        return celestialObjects;
    }

    public List<CelestialObject> loadCelestialObjects() {
        List<CelestialObject> objects = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM CelestialObjects");

            while (resultSet.next()) {

                String type = resultSet.getString("Type");
                String name = resultSet.getString("Name");
                String mass = resultSet.getString("Mass");
                String specs = resultSet.getString("Specs");



                double size = resultSet.getDouble("Size");
                String composition = resultSet.getString("Composition");
                double temperature = resultSet.getDouble("Temperature");
                double luminosity = resultSet.getDouble("Luminosity");
                double criticalMass = resultSet.getDouble("criticalMass");



                // Retrieve the comma-separated string of resources from the database
                String resourcesAsString = resultSet.getString("Resources");

                // Split the string into individual resource values
                String[] resourceValues = resourcesAsString.split(",");

                // Create a HashSet<Resource> from the split values
                HashSet<Resource> resources = new HashSet<>();
                for (String resourceValue : resourceValues) {
                    resources.add(new Resource(resourceValue));
                }

                CelestialObjectProxy proxy = new CelestialObjectProxy(type, name, mass, specs, resources, size, composition, temperature, luminosity, criticalMass);



                objects.add(proxy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objects;
    }

    private int getNextAvailableID() {
        int nextID = 1;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT MAX(ID) FROM CelestialObjects");

            if (resultSet.next()) {
                nextID = resultSet.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nextID;
    }

//    private void saveCelestialObject(CelestialObject celestialObject) {
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CelestialObjects (ID, Type, Name, Mass, Specs, Size, ) VALUES (?, ?, ?, ?)")) {
//
//            preparedStatement.setInt(1, getNextAvailableID());  // Provide a unique value for 'ID'
//            preparedStatement.setString(2, celestialObject.getName());
//            preparedStatement.setString(3, celestialObject.getMass()); // Mass is a string
//            preparedStatement.setDouble(4, celestialObject.getSize());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    private void saveCelestialObject(CelestialObject celestialObject) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO CelestialObjects (ID, Type, Name, Mass, Specs, Resources, Size, Composition, Temperature, Luminosity, CriticalMass) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, getNextAvailableID());  // Provide a unique value for 'ID'
            preparedStatement.setString(2, celestialObject.getType());
            preparedStatement.setString(3, celestialObject.getName());
            preparedStatement.setString(4, celestialObject.getMass());
            preparedStatement.setString(5, celestialObject.getSpecs());

            // Convert HashSet<Resource> to a List<String>

            List<String> resourceValues = celestialObject.getResources()
                    .stream()
                    .map(Resource::toString) // Assuming Resource has a toString method
                    .collect(Collectors.toList());

            // Join the list of resource values with commas
            String resourcesAsString = String.join(",", resourceValues);

            preparedStatement.setString(6, resourcesAsString);

            preparedStatement.setDouble(7, celestialObject.getSize());
            preparedStatement.setString(8, celestialObject.getComposition());
            preparedStatement.setDouble(9, celestialObject.getTemperature());
            preparedStatement.setDouble(10, celestialObject.getLuminosity());
            preparedStatement.setDouble(11, celestialObject.getCriticalMass());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
