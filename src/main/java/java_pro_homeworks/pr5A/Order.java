package java_pro_homeworks.pr5A;

public class Order {
    private int id;
    private ShippingDetails shippingDetails;
    private Customer customer;
    private String date;
    private OrderStatus orderStatus;
    private Product[] products;

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Order(int id, ShippingDetails shippingDetails, Customer customer, String date, OrderStatus orderStatus, Product[] products) {
        this.id = id;
        this.shippingDetails = shippingDetails;
        this.customer = customer;
        this.date = date;
        this.orderStatus = orderStatus;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
