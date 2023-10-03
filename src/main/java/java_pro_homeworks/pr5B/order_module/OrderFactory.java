package java_pro_homeworks.pr5B.order_module;

import java_pro_homeworks.pr5B.customer_module.Customer;
import java_pro_homeworks.pr5B.customer_module.CustomerFactory;
import java_pro_homeworks.pr5B.product_module.Product;
import java_pro_homeworks.pr5B.product_module.ProductFactory;
import java_pro_homeworks.pr5B.shipping_module.ShippingDetails;
import java_pro_homeworks.pr5B.shipping_module.ShippingFactory;

import java.util.Random;

public class OrderFactory {

    ProductFactory productFactory;
    ShippingFactory shippingFactory;
    CustomerFactory customerFactory;

    public OrderFactory(ProductFactory productFactory, ShippingFactory shippingFactory,
                        CustomerFactory customerFactory) {
        this.productFactory = productFactory;
        this.shippingFactory = shippingFactory;
        this.customerFactory = customerFactory;
    }

    /*TODO Change format of  String date = "06.07.2023";
     * */
    public Order getRandomOrder(int productsMaxCount) {
        int id = (int) ((Math.random() * (100000 - 1)) + 1);
        ShippingDetails shippingDetails = shippingFactory.getRandomShippingDetails();
        Customer customer = customerFactory.getRandomCustomer();
        String date = "06.07.2023";

        int randomStatusIndex = new Random().nextInt(OrderStatus.values().length);
        OrderStatus orderStatus = OrderStatus.values()[randomStatusIndex];

        Product[] products = productFactory.getRandomProducts(productsMaxCount);

        return new Order(id, shippingDetails, customer, date, orderStatus, products);
    }

    public Order[] getRandomOrders (int productsMaxCount, int ordersCount){
        Order[] pack = new Order[ordersCount];
        for (int i = 0; i < ordersCount; i++) {
            pack[i] = getRandomOrder(productsMaxCount);
        }
        return pack;
    }

    public void setProductFactory(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public void setShippingFactory(ShippingFactory shippingFactory) {
        this.shippingFactory = shippingFactory;
    }

    public void setCustomerFactory(CustomerFactory customerFactory) {
        this.customerFactory = customerFactory;
    }
}

