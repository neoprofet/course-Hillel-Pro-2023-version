package java_pro_homeworks.pr30.daos;

import java_pro_homeworks.pr30.models.Author;
import java_pro_homeworks.pr30.models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO {
    private final Connection CONNECTION;

    public CustomerDAO(Connection CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    /**
     * Creates table customers if not exists
     * Using Sql
     * Fields: id (PK, autoincrement), name (varchar), birth_year(varchar)
     */
    public void createTable() throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS customers (" +
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(100)," +
                    "birth_year INTEGER )");
        }
    }

    /**
     * Delete table authors
     * Using Sql
     */
    public void deleteTable() throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS customers");
        }
    }

    /**
     * Additional method
     * Creates customer from result set
     */
    private Customer createCustomerFromCursor(ResultSet cursor) throws SQLException {
        Customer customer = new Customer();
        customer.setId(cursor.getInt("id"));
        customer.setName(cursor.getString("name"));
        customer.setBirthYear(cursor.getInt("birth_year"));
        return customer;
    }

    /**
     * Get all values from table customers
     * Using Sql query (SELECT*, select all)
     */
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM customers");
            while (cursor.next()) {
                customers.add(createCustomerFromCursor(cursor));
            }
            return customers;
        }
    }

    /**
     * Get value by id from table customers
     * Using Sql query (SELECT*, WHERE)
     */
    public Optional<Customer> getById(int id) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery(String.format("SELECT * FROM customers WHERE id = %d", id));
            if (cursor.next()) {
                return Optional.of(createCustomerFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Get value by name from table customer
     * Using Sql query (SELECT*, WHERE, LIKE)
     */
    public Optional<Customer> getByName(String name) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery
                    (String.format("SELECT * FROM customers WHERE name LIKE '%%%s%%'", name));
            if (cursor.next()) {
                return Optional.of(createCustomerFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Inserts java-entity to table customers
     * Using Sql
     * Using PreparedStatement
     * Using GeneratedKeys
     */
    public void insert(Customer customer) throws SQLException, IllegalArgumentException{
        final String sql = "INSERT INTO customers (name, birth_year) VALUES (?,?)";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getBirthYear());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer has failed. No rows affected");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getInt(1));
                } else throw new IllegalArgumentException("Creating customer has failed. No Id obtained");
            }
        }
    }

    /**
     * Inserts java-entity to table customers
     * Accepts an object from where it gets information for updating
     * Updates by id
     * <p>
     * Using Sql
     * Using PreparedStatement
     */
    public void update(Customer customer) throws SQLException,IllegalArgumentException {

        if (customer.getId() == 0) {
            throw new IllegalArgumentException("Updating customer has failed. No Id obtained");
        }
        final String sql = "UPDATE customers SET name = ?, birth_year = ? WHERE id = ?";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql)) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getBirthYear());
            statement.setInt(3, customer.getId());
            statement.executeUpdate();
        }
    }
}
