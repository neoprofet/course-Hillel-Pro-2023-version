package java_pro_homeworks.pr30.repository;

import java_pro_homeworks.pr30.daos.AuthorDAO;
import java_pro_homeworks.pr30.daos.BookDAO;
import java_pro_homeworks.pr30.daos.CustomerDAO;
import java_pro_homeworks.pr30.daos.ReviewDAO;
import java_pro_homeworks.pr30.models.Author;
import java_pro_homeworks.pr30.models.Book;
import java_pro_homeworks.pr30.models.Customer;
import java_pro_homeworks.pr30.models.Review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class LibraryRepository implements ILibraryRepository {

    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;
    private final CustomerDAO customerDAO;
    private final ReviewDAO reviewDAO;

    public LibraryRepository(AuthorDAO authorDAO, BookDAO bookDAO, CustomerDAO customerDAO, ReviewDAO reviewDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
        this.customerDAO = customerDAO;
        this.reviewDAO = reviewDAO;
    }


    @Override
    public void saveAuthor(Author author) {
        if (author.getId() == 0) {
            try {
                authorDAO.insert(author);
            } catch (SQLException e) {
                System.out.println("Error inserting author");
            }
        } else {
            try {
                authorDAO.update(author);
            } catch (SQLException e) {
                System.out.println("Error updating author");
            }
        }
    }

    @Override
    public void saveBook(Book book, Author author) {
    saveAuthor(author);
    book.setAuthorId(author.getId());

        if (book.getId() == 0) {
            try {
                bookDAO.insert(book);
            } catch (SQLException e) {
                System.out.println("Error inserting book");
            }
        } else {
            try {
                bookDAO.update(book);
            } catch (SQLException e) {
                System.out.println("Error updating book");
            }
        }
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getId() == 0) {
            try {
                customerDAO.insert(customer);
            } catch (SQLException e) {
                System.out.println("Error inserting customer");
            }
        } else {
            try {
                customerDAO.update(customer);
            } catch (SQLException e) {
                System.out.println("Error updating customer");
            }
        }
    }

    @Override
    public void saveReview(Review review, Customer customer, Book book, Author author) {
        saveCustomer(customer);
        saveBook(book, author);

        review.setCustomerId(customer.getId());
        review.setBookId(book.getId());

        if (customer.getId() == 0) {
            try {
                customerDAO.insert(customer);
            } catch (SQLException e) {
                System.out.println("Error inserting customer");
            }
        } else {
            try {
                customerDAO.update(customer);
            } catch (SQLException e) {
                System.out.println("Error updating customer");
            }
        }
    }

    @Override
    public Collection<Author> getAllAuthors() {
        Collection<Author> authors = new ArrayList<>();
        try{
            authors = authorDAO.getAll();
        } catch (SQLException e) {
            System.out.println("Failed getting authors");
        }
        return authors;
    }

    @Override
    public Collection<Book> getAllBooks() {
        Collection<Book> books = new ArrayList<>();
        try{
            books = bookDAO.getAll();
        } catch (SQLException e) {
            System.out.println("Failed getting books");
        }
        return books;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        Collection<Customer> customers = new ArrayList<>();
        try{
            customers = customerDAO.getAll();
        } catch (SQLException e) {
            System.out.println("Failed getting customers");
        }
        return customers;
    }

    @Override
    public Collection<Review> getAllReviews() {
        Collection<Review> reviews = new ArrayList<>();
        try{
            reviews = reviewDAO.getAll();
        } catch (SQLException e) {
            System.out.println("Failed getting reviews");
        }
        return reviews;
    }

}
