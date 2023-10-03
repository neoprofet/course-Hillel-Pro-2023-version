package java_pro_homeworks.pr30.daos;

import java_pro_homeworks.pr30.models.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDAO {
    private final Connection CONNECTION;

    public AuthorDAO(Connection CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    /**
     * Creates table authors if not exists
     * Using Sql
     * Fields: id (PK, autoincrement), name (varchar), birth_year(varchar)
     */
    public void createTable() throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS authors (" +
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
            statement.executeUpdate("DROP TABLE IF EXISTS authors");
        }
    }

    /**
     * Additional method
     * Creates author from result set
     */
    private Author createAuthorFromCursor(ResultSet cursor) throws SQLException {
        Author author = new Author();
        author.setId(cursor.getInt("id"));
        author.setName(cursor.getString("name"));
        author.setBirthYear(cursor.getInt("birth_year"));
        return author;
    }

    /**
     * Get all values from table authors
     * Using Sql query (SELECT*, select all)
     */
    public List<Author> getAll() throws SQLException {
        List<Author> authors = new ArrayList<>();
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM authors");
            while (cursor.next()) {
                authors.add(createAuthorFromCursor(cursor));
            }
            return authors;
        }
    }

    /**
     * Get value by id from table authors
     * Using Sql query (SELECT*, WHERE)
     */
    public Optional<Author> getById(int id) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery(String.format("SELECT * FROM authors WHERE id = %d", id));
            if (cursor.next()) {
                return Optional.of(createAuthorFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Get value by name from table authors
     * Using Sql query (SELECT*, WHERE, LIKE)
     */
    public Optional<Author> getByName(String name) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery
                    (String.format("SELECT * FROM authors WHERE name LIKE '%%%s%%'", name));
            if (cursor.next()) {
                return Optional.of(createAuthorFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Inserts java-entity to table authors
     * Using Sql
     * Using PreparedStatement
     * Using GeneratedKeys
     */
    public void insert(Author author) throws SQLException, IllegalArgumentException{
        final String sql = "INSERT INTO authors (name, birth_year) VALUES (?,?)";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, author.getName());
            statement.setInt(2, author.getBirthYear());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating author has failed. No rows affected");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    author.setId(generatedKeys.getInt(1));
                } else throw new IllegalArgumentException("Creating author has failed. No Id obtained");
            }
        }
    }

    /**
     * Inserts java-entity to table authors
     * Accepts an object from where it gets information for updating
     * Updates by id
     * <p>
     * Using Sql
     * Using PreparedStatement
     */
    public void update(Author author) throws SQLException,IllegalArgumentException {

        if (author.getId() == 0) {
            throw new IllegalArgumentException("Updating author has failed. No Id obtained");
        }
        final String sql = "UPDATE authors SET name = ?, birth_year = ? WHERE id = ?";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql)) {
            statement.setString(1, author.getName());
            statement.setInt(2, author.getBirthYear());
            statement.setInt(3, author.getId());
            statement.executeUpdate();
        }
    }
}
