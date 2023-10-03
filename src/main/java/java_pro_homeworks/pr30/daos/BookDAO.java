package java_pro_homeworks.pr30.daos;

import java_pro_homeworks.pr30.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAO {
    private final Connection CONNECTION;

    public BookDAO(Connection CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    /**
     * Creates table books if not exists
     * Using Sql
     * Fields: id (PK, autoincrement), name (varchar), pageCount (integer), authorId(integer, FK) ;
     */
    public void createTable() throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books (" +
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(100)," +
                    "pageCount INTEGER," +
                    "authorId INTEGER)");
        }
    }

    /**
     * Delete table books
     * Using Sql
     */
    public void deleteTable() throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS books");
        }
    }

    /**
     * Additional method
     * Creates book from result set
     */
    private Book createBookFromCursor(ResultSet cursor) throws SQLException {
        Book book = new Book();
        book.setId(cursor.getInt("id"));
        book.setName(cursor.getString("name"));
        book.setPageCount(cursor.getInt("pageCount"));
        book.setAuthorId(cursor.getInt("authorId"));
        return book;
    }

    /**
     * Get all values from table books
     * Using Sql query (SELECT*, select all)
     */
    public List<Book> getAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery("SELECT * FROM books");
            while (cursor.next()) {
                books.add(createBookFromCursor(cursor));
            }
            return books;
        }
    }

    /**
     * Get value by id from table books
     * Using Sql query (SELECT*, WHERE)
     */
    public Optional<Book> getById(int id) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery(String.format("SELECT * FROM books WHERE id = %d", id));
            if (cursor.next()) {
                return Optional.of(createBookFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Get value by name from table books
     * Using Sql query (SELECT*, WHERE, LIKE)
     */
    public Optional<Book> getByName(String name) throws SQLException {
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet cursor = statement.executeQuery
                    (String.format("SELECT * FROM books WHERE name LIKE '%%%s%%'", name));
            if (cursor.next()) {
                return Optional.of(createBookFromCursor(cursor));
            } else {
                return Optional.empty();
            }
        }
    }

    /**
     * Inserts java-entity to table books
     * Using Sql
     * Using PreparedStatement
     * Using GeneratedKeys
     */
    public void insert(Book book) throws SQLException, IllegalArgumentException {
        final String sql = "INSERT INTO books (name, pageCount, authorId) VALUES (?,?,?)";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, book.getName());
            statement.setInt(2, book.getPageCount());
            statement.setInt(3, book.getAuthorId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating book has failed. No rows affected");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getInt(1));
                } else throw new IllegalArgumentException("Creating book has failed. No Id obtained");
            }
        }
    }

    /**
     * Inserts java-entity to table books
     * Accepts an object from where it gets information for updating
     * Updates by id
     * <p>
     * Using Sql
     * Using PreparedStatement
     */
    public void update(Book book) throws SQLException, IllegalArgumentException {

        if (book.getId() == 0) {
            throw new IllegalArgumentException("Updating book has failed. No Id obtained");
        }
        final String sql = "UPDATE books SET name = ?, pageCount = ?, authorId = ?  WHERE id = ?";
        try (PreparedStatement statement = CONNECTION.prepareStatement(sql)) {
            statement.setString(1, book.getName());
            statement.setInt(2, book.getPageCount());
            statement.setInt(3, book.getAuthorId());
            statement.setInt(4, book.getId());
            statement.executeUpdate();
        }
    }

    /**
     * TESTING JOIN QUERY
     * books join authors
     * Join-query and printing results
     */
    public void printBooksJoinAuthors() throws SQLException {
        final String sqlQuery = "SELECT books.name, authors.name FROM books JOIN authors ON books.authorId = authors.id";
        try(Statement statement = CONNECTION.createStatement()){
           ResultSet cursor = statement.executeQuery(sqlQuery);
           while(cursor.next()){
               System.out.print("Book name: " + cursor.getString("name"));
               System.out.println(" Author name: " + cursor.getString(2));
           }
        }

    }
}
