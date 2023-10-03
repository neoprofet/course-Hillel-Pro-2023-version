package java_pro_homeworks.pr30;

import java_pro_homeworks.pr30.daos.AuthorDAO;
import java_pro_homeworks.pr30.daos.BookDAO;
import java_pro_homeworks.pr30.daos.CustomerDAO;
import java_pro_homeworks.pr30.daos.ReviewDAO;
import java_pro_homeworks.pr30.models.Author;
import java_pro_homeworks.pr30.models.Book;
import java_pro_homeworks.pr30.models.Customer;
import java_pro_homeworks.pr30.models.Review;
import java_pro_homeworks.pr30.repository.LibraryRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    private static final String SQLITE_CONNECTION_STRING = "jdbc:sqlite:sample.db";
    static Collection<Author> authors;
    static Collection<Book> books;
    static Collection<Customer> customers;
    static Collection<Review> reviews;

    static {
        authors = new ArrayList<>();
        authors.add(new Author(1, "Jess Kidd", 1980));
        authors.add(new Author(2, "Martha McPhee", 1970));
        authors.add(new Author(3, "Megan Miranda", 1955));
        authors.add(new Author(4, "Helen Phillips", 1965));
        authors.add(new Author(5, "Kristin Harmel", 1995));

        books = new ArrayList<>();
        books.add(new Book(1, "Himself", 220, 1));
        books.add(new Book(2, "Things in Jars", 138, 1));
        books.add(new Book(3, "Gorgeous Lies", 114, 2));
        books.add(new Book(4, "An Elegant Woman", 156, 2));
        books.add(new Book(5, "All the Missing Girls", 431, 3));
        books.add(new Book(6, "The Last House Guest", 213, 3));
        books.add(new Book(7, "The Beautiful Bureaucrat", 418, 4));
        books.add(new Book(8, "The Beautiful Bureaucrat. Part 2", 136, 4));
        books.add(new Book(9, "The Winemaker’s Wife", 412, 5));
        books.add(new Book(10, "The Paris Daughter", 358, 5));

        customers = new ArrayList<>();
        customers.add(new Customer(1, "Den", 2002));
        customers.add(new Customer(2, "Nick", 2002));
        customers.add(new Customer(1, "Mary", 2005));

        reviews = new ArrayList<>();
        reviews.add(new Review(1, "text1", 1, 4));
        reviews.add(new Review(2, "text2", 1, 8));
        reviews.add(new Review(3, "text3", 1, 2));
        reviews.add(new Review(4, "text4", 2, 2));
        reviews.add(new Review(5, "text5", 2, 3));
        reviews.add(new Review(6, "text6", 2, 5));
        reviews.add(new Review(7, "text7", 3, 1));
        reviews.add(new Review(8, "text8", 3, 6));
    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(SQLITE_CONNECTION_STRING)) {
            daoTask(connection);
           // libraryTask(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void daoTask(Connection connection) {
        AuthorDAO authorDAO = new AuthorDAO(connection);
        BookDAO bookDAO = new BookDAO(connection);
        CustomerDAO customerDAO = new CustomerDAO(connection);
        ReviewDAO reviewDAO = new ReviewDAO(connection);

        System.out.println("Deleting tables if exists ...");

        try {
            authorDAO.deleteTable();
            bookDAO.deleteTable();
            customerDAO.deleteTable();
            reviewDAO.deleteTable();
        } catch (SQLException e) {
            System.out.println("Error of deleting tables");
        }

        System.out.println("Deleting tables if exists done +");
        System.out.println("Creating tables ...");

        try {
            authorDAO.createTable();
            bookDAO.createTable();
            customerDAO.createTable();
            reviewDAO.createTable();
        } catch (SQLException e) {
            System.out.println("Error of creating tables");
        }
        System.out.println("Creating tables done +");

        System.out.println("Inserting authors ...");
        for (Author author : authors) {
            try {
                authorDAO.insert(author);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Inserting authors done +");
        System.out.println("Inserting books ...");

        for (Book book : books) {
            try {
                bookDAO.insert(book);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Inserting books done +");
        System.out.println("Inserting customers ...");
        for (Customer customer : customers) {
            try {
                customerDAO.insert(customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Inserting customers done +");
        System.out.println("Inserting reviews ...");

        for (Review review : reviews) {
            try {
                reviewDAO.insert(review);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Inserting reviews done +");
        System.out.println("Getting all authors...");
        try {
            Collection<Author> result = authorDAO.getAll();
            System.out.println("------------------------------");
            for (Author author : result) {
                System.out.println(author);
            }
            System.out.println("------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Getting all authors done +");
        System.out.println("Getting all books...");
        try {
            Collection<Book> result = bookDAO.getAll();
            System.out.println("------------------------------");
            for (Book book : result) {
                System.out.println(book);
            }
            System.out.println("------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Getting all books done +");
        System.out.println("Getting all customers...");
        try {
            Collection<Customer> result = customerDAO.getAll();
            System.out.println("------------------------------");
            for (Customer customer : result) {
                System.out.println(customer);
            }
            System.out.println("------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Getting all customers done +");
        System.out.println("Getting all reviews...");
        try {
            Collection<Review> result = reviewDAO.getAll();
            System.out.println("------------------------------");
            for (Review review : result) {
                System.out.println(review);
            }
            System.out.println("------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Getting all reviews done +");
        System.out.println("Getting models by index 2...");
        System.out.println("------------------------------");
        try {
            // get() is Optional method
            System.out.println(authorDAO.getById(2).get());
            System.out.println(bookDAO.getById(2).get());
            System.out.println(customerDAO.getById(2).get());
            System.out.println(reviewDAO.getById(2).get());
        }catch (SQLException e){
            System.out.println("Error while getting by index");
        }
        System.out.println("------------------------------");
        System.out.println("Getting models by index 2 done +");

        System.out.println("Getting models by name ...");
        System.out.println("------------------------------");
        try {
            // get() is Optional method
            System.out.println(authorDAO.getByName("Helen Phillips").get());
            System.out.println(bookDAO.getByName("The Last House Guest").get());
            System.out.println(customerDAO.getByName("Mary").get());
            System.out.println(reviewDAO.getByText("text1").get());
        }catch (SQLException e){
            System.out.println("Error while getting by index");
        }
        System.out.println("------------------------------");
        System.out.println("Getting models by index 2 done +");
        System.out.println("Updating Customer model ...");
        System.out.println("------------------------------");
        try {
            // get() is Optional method
            System.out.println("OLD: " + customerDAO.getById(1).get());
        }catch (SQLException e){
            System.out.println("Error while getting by index");
        }
        try {
            customerDAO.update(new Customer(1, "Neoprofet", 2002));
        } catch (SQLException e) {
            System.out.println("Error while updating");
        }
        try {
            // get() is Optional method
            System.out.println("NEW: " + customerDAO.getById(1).get());
        }catch (SQLException e){
            System.out.println("Error while getting by index");
        }
        System.out.println("------------------------------");
        System.out.println("Updating Customer model done +");
        System.out.println("Testing JOIN-ON QUERY ...");
        System.out.println("------------------------------");
        try {
            bookDAO.printBooksJoinAuthors();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while executing join-on query");
        }
        System.out.println("Testing JOIN-ON QUERY done +");

    }

    public static void libraryTask(Connection connection) {
        AuthorDAO authorDAO = new AuthorDAO(connection);
        BookDAO bookDAO = new BookDAO(connection);
        CustomerDAO customerDAO = new CustomerDAO(connection);
        ReviewDAO reviewDAO = new ReviewDAO(connection);

        LibraryRepository libraryRepository = new LibraryRepository(authorDAO,bookDAO,customerDAO,reviewDAO);

        try {
            authorDAO.deleteTable();
            bookDAO.deleteTable();
            customerDAO.deleteTable();
            reviewDAO.deleteTable();
        } catch (SQLException e) {
            System.out.println("Error of deleting tables");
        }

        System.out.println("Deleting tables if exists done +");
        System.out.println("Creating tables ...");

        try {
            authorDAO.createTable();
            bookDAO.createTable();
            customerDAO.createTable();
            reviewDAO.createTable();
        } catch (SQLException e) {
            System.out.println("Error of creating tables");
        }
        System.out.println("Creating tables done +");

        libraryRepository.saveAuthor(new Author(0,"Author1", 1888 ));
        libraryRepository.saveBook(new Book(0, "Book1", 424, 2),
                new Author(0, "Author2", 2000));
        System.out.println(libraryRepository.getAllBooks());
        System.out.println(libraryRepository.getAllAuthors());
    }


}
