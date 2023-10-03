package java_pro_homeworks.pr30.daos;

import java_pro_homeworks.pr30.models.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewDAO {

    private final Connection CONNECTION;

    public ReviewDAO(Connection CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    /**
     * Creates table reviews if not exists
     * Using Sql
     * Fields: id (PK, autoincrement), text (varchar), customerID (integer, FK), bookId(integer, FK) ;
     */
    public void createTable() throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS reviews (" +
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "text VARCHAR(100)," +
                    "customerID INTEGER," +
                    "bookId INTEGER)");
        }
    }

    /**
     * Delete table reviews
     * Using Sql
     */
    public void deleteTable() throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS reviews");
        }
    }

    /**
     * Additional method
     * Creates review from result set
     */
    private Review createReviewFromCursor(ResultSet cursor) throws SQLException {
        Review review = new Review();
        review.setId(cursor.getInt("id"));
        review.setText(cursor.getString("text"));
        review.setCustomerId(cursor.getInt("customerId"));
        review.setBookId(cursor.getInt("bookId"));
        return review;
    }

    /**
     * Get all values from table reviews
     * Using Sql query (SELECT*, select all)
     */
    public List<Review> getAll() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM reviews");
            while (cursor.next()) {
                reviews.add(createReviewFromCursor(cursor));
            }
            return reviews;
        }
    }

    /**
     * Get value by id from table reviews
     * Using Sql query (SELECT*, WHERE)
     */
    public Optional<Review> getById(int id) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery(String.format("SELECT * FROM reviews WHERE id = %d", id));
            if (cursor.next()) {
                return Optional.of(createReviewFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Get value by name from table reviews
     * Using Sql query (SELECT*, WHERE, LIKE)
     */
    public Optional<Review> getByText(String text) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery
                    (String.format("SELECT * FROM reviews WHERE text LIKE '%%%s%%'", text));
            if (cursor.next()) {
                return Optional.of(createReviewFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Inserts java-entity to table reviews
     * Using Sql
     * Using PreparedStatement
     * Using GeneratedKeys
     */
    public void insert(Review review) throws SQLException, IllegalArgumentException{
        final String sql = "INSERT INTO reviews (text, customerId, bookId) VALUES (?,?,?)";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, review.getText());
            statement.setInt(2, review.getCustomerId());
            statement.setInt(3, review.getBookId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating review has failed. No rows affected");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    review.setId(generatedKeys.getInt(1));
                } else throw new IllegalArgumentException("Creating review has failed. No Id obtained");
            }
        }
    }

    /**
     * Inserts java-entity to table reviews
     * Accepts an object from where it gets information for updating
     * Updates by id
     * <p>
     * Using Sql
     * Using PreparedStatement
     */
    public void update(Review review) throws SQLException,IllegalArgumentException {

        if (review.getId() == 0) {
            throw new IllegalArgumentException("Updating review has failed. No Id obtained");
        }
        final String sql = "UPDATE reviews SET text = ?, customerId = ?, bookId = ? WHERE id = ?";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql)) {
            statement.setString(1, review.getText());
            statement.setInt(2, review.getCustomerId());
            statement.setInt(3, review.getBookId());
            statement.setInt(4, review.getId());
            statement.executeUpdate();
        }
    }
}
