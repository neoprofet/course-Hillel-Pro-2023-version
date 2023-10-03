package java_pro_homeworks.pr30.models;

public class Review {
    private int id; //PK
    private String text;
    private int customerId; //FK
    private int bookId; //FK

    public Review(int id, String text, int customerId, int bookId) {
        this.id = id;
        this.text = text;
        this.customerId = customerId;
        this.bookId = bookId;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userId=" + customerId +
                ", bookId=" + bookId +
                '}';
    }
}
