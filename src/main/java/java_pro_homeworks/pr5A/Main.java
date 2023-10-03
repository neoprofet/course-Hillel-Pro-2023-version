package java_pro_homeworks.pr5A;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Customer[] customers = {
                new Customer(1, "Mary"),
                new Customer(2, "Anastasiya"),
                new Customer(3, "Den"),
                new Customer(4, "Ilya"),
                new Customer(5, "Lena")};


    Product[] products = {
            new Product(1, "Cola", 25),
            new Product(2, "Fanta", 27),
            new Product(3, "Sprite", 30),
            new Product(4, "Pepsi", 45),
            new Product(5, "Juice", 55),
    };

    Order order = new Order(
            1,
            new ShippingDetails(new BigDecimal("123.1314"),"Nivki, 45"),
            customers[2],
            "14.04.2023",
            OrderStatus.AWAITS,
            products
    );


ServicePrinter servicePrinter = new ServicePrinter();
servicePrinter.showOrder(order);

}
}
