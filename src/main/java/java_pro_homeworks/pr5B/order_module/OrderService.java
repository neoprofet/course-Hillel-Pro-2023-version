package java_pro_homeworks.pr5B.order_module;

import java_pro_homeworks.pr5B.product_module.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public double calculateTotalPrice(Order order){
        double sum = 0.0;
        for (Product product : order.getProducts()) {
            sum += product.getPrice();
        }
        sum += order.getShippingDetails().getPrice().doubleValue();
        return sum;
    }

    public Order[] getByPointedOrderStatus(OrderStatus orderStatus, Order[] orders){
        List<Order> selectedOrders = new ArrayList<>();
        for (Order order : orders) {
            if(order.getOrderStatus()==orderStatus){
                selectedOrders.add(order);
            }
        }
        Order[] result = new Order[selectedOrders.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = selectedOrders.get(i);
        }
        return result;
        }

    }


