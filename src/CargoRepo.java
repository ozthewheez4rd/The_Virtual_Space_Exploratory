import java.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CargoRepo {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/spacecraft_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private List<Cargo> cargoList;
    private List<Resource> resourceList;

    public CargoRepo() {
        cargoList = loadCargoData();
    }

    public void addCargo(Cargo cargo) {
        if (!cargoList.contains(cargo)) {
            cargoList.add(cargo);
            saveCargoData(cargoList);
        }
    }

    public void addResource(Resource resource) {
        if (!resourceList.contains(resource)) {
            resourceList.add(resource);

        }
    }

    public List<Resource> getAllResources() {
        return resourceList;
    }

    public List<Cargo> getAllCargo() {
        return cargoList;
    }

    private List<Cargo> loadCargoData() {
        List<Cargo> cargos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cargo");

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int quantity = resultSet.getInt("Quantity");
                double value = resultSet.getDouble("Value");

                // Retrieve the comma-separated string of resources from the database
                String resourcesAsString = resultSet.getString("Resources");

                // Split the string into individual resource values
                String[] resourceValues = resourcesAsString.split(",");

                // Create a List<Resource> from the split values
                List<Resource> resources = new ArrayList<>();

                Cargo cargo = new Cargo(name, quantity, value, resources);
                cargos.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cargos;
    }

    private void saveCargoData(List<Cargo> cargos) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO cargo(name, quantity, value, resource_id) VALUES (?, ?, ?, ?)")) {

            for (Cargo cargo : cargos) {
                preparedStatement.setString(1, cargo.getName());
                preparedStatement.setInt(2, cargo.getQuantity());
                preparedStatement.setDouble(3, cargo.getValue());

                // Convert List<Resource> to a comma-separated string
                String resourcesAsString = cargo.getResources().stream()
                        .map(Resource::getName)
                        .collect(Collectors.joining(","));

                preparedStatement.setString(4, resourcesAsString);

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
