package java_pro_homeworks.pr30.repository;

import java_pro_homeworks.pr30.models.Author;
import java_pro_homeworks.pr30.models.Book;
import java_pro_homeworks.pr30.models.Customer;
import java_pro_homeworks.pr30.models.Review;

import java.util.Collection;

public interface ILibraryRepository {
    void saveAuthor(Author author);
    void saveBook(Book book, Author author);
    void saveCustomer(Customer customer);
    void saveReview(Review review, Customer customer, Book book, Author author);

    Collection<Author> getAllAuthors();
    Collection<Book> getAllBooks();
    Collection<Customer> getAllCustomers();
    Collection<Review> getAllReviews();

}
