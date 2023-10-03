package java_pro_homeworks.pr5B;

import java_pro_homeworks.pr5B.customer_module.Customer;
import java_pro_homeworks.pr5B.order_module.Order;
import java_pro_homeworks.pr5B.order_module.OrderService;
import java_pro_homeworks.pr5B.product_module.Product;
import java_pro_homeworks.pr5B.shipping_module.ShippingDetails;

public class LocalPrinter {
    OrderService orderService = new OrderService();
    public void showOrder(Order order){
        System.out.println("{ Id: "+ order.getId());
        showShippingDetails(order.getShippingDetails());
        showCustomer(order.getCustomer());
        System.out.println("Status: "+ order.getOrderStatus().toString());
        showProducts(order.getProducts());
        System.out.println("Date: "+ order.getDate());
        System.out.println("Total price: "+ orderService.calculateTotalPrice(order));
        System.out.println(" }");
    }

    public void showOrders(Order[] orders){

        for (Order order : orders) {
            System.out.println("=====================================");
            showOrder(order);
        }
    }

    public void showShippingDetails(ShippingDetails shippingDetails){
        System.out.println("Shipping price: "+ shippingDetails.getPrice().toString()+
                "\nShipping address: "+ shippingDetails.getAddress());
    }

    public void showCustomer(Customer customer){
        System.out.println("Customer id: "+ customer.getId()+
                "\nCustomer name: "+ customer.getName() +
                "\nCustomer age: "+ customer.getAge());
    }

    public void showProduct(Product product){
        System.out.print("Product id: "+ product.getId()+
                ", Product name: "+ product.getName()+
                ", Product price: "+ product.getPrice());
    }

    public void showProducts(Product[] products){
        System.out.println("Products: [ ");
        for (Product product : products) {
            showProduct(product);
            System.out.println();
        }
        System.out.println(" ]");
    }



}
