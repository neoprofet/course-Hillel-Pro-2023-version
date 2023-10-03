package java_pro_homeworks.pr5A;

public class ServicePrinter {
    public void showOrder(Order order){
        System.out.println("{ Id: "+ order.getId());
        showShippingDetails(order.getShippingDetails());
        showCustomer(order.getCustomer());
        System.out.println("Status: "+ order.getOrderStatus().toString());
        showProducts(order.getProducts());
        System.out.println("Date: "+ order.getDate());
        System.out.println(" }");
    }

    public void showShippingDetails(ShippingDetails shippingDetails){
        System.out.println("Shipping price: "+ shippingDetails.getPrice().toString()+
                "\nShipping address: "+ shippingDetails.getAddress());
    }

    public void showCustomer(Customer customer){
        System.out.println("Customer id: "+ customer.getId()+
                "\nCustomer name: "+ customer.getName());
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