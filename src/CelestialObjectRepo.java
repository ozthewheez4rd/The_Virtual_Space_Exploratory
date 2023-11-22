import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CelestialObjectRepo {
    private static final String JDBC_URL = "jdbc:mysql://Localhost:3306/spacecraft_db";
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
                String name = resultSet.getString("Name");
                double mass = resultSet.getDouble("Mass");
                double size = resultSet.getDouble("Size");

                // Example: CelestialObject object = new CelestialObject(name, mass, size);
                // objects.add(object);
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

    private void saveCelestialObject(CelestialObject celestialObject) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CelestialObjects (ID, Name, Mass, Size) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setInt(1, getNextAvailableID());  // Provide a unique value for 'ID'
            preparedStatement.setString(2, celestialObject.getName());
            preparedStatement.setDouble(3, celestialObject.getMass());
            preparedStatement.setDouble(4, celestialObject.getSize());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
