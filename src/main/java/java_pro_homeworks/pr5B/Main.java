package java_pro_homeworks.pr5B;

import java_pro_homeworks.pr5B.customer_module.CustomerData;
import java_pro_homeworks.pr5B.customer_module.CustomerFactory;
import java_pro_homeworks.pr5B.order_module.Order;
import java_pro_homeworks.pr5B.order_module.OrderFactory;
import java_pro_homeworks.pr5B.order_module.OrderService;
import java_pro_homeworks.pr5B.order_module.OrderStatus;
import java_pro_homeworks.pr5B.product_module.ProductFactory;
import java_pro_homeworks.pr5B.shipping_module.ShippingFactory;


/*Ќе реализована св€зь ордера с клиентами (как в бд), например нет возможности посмотреть сколько и каких заказов
* у конкретного кастомера, но можно посмотреть какому клиенту принадлежит ордер,
* ордер содержит клиента но не наоборот
*
* Ќе реализован вывод в табличном виде, так как печать реализована по своему
* */
public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        OrderFactory orderFactory = new OrderFactory(new ProductFactory(), new ShippingFactory(),
                new CustomerFactory(new CustomerData().getNamesPack1()));

      Order[] orders = orderFactory.getRandomOrders(4,5);

      LocalPrinter localPrinter = new LocalPrinter();
      localPrinter.showOrders(orders);

        System.out.println("++++++++++++++++++++AWAITS STATUS++++++++++++++++++++");
      Order[] awaitedOrders = orderService.getByPointedOrderStatus(OrderStatus.AWAITS,orders);
      localPrinter.showOrders(awaitedOrders);


    }
}
