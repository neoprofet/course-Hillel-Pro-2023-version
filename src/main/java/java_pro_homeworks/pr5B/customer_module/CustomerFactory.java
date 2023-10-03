package java_pro_homeworks.pr5B.customer_module;

public class CustomerFactory {
    private String[] namesPack;

    public CustomerFactory(String[] namesPack) {
        this.namesPack = namesPack;
    }

    public Customer getRandomCustomer(){
        int randomNameIndex = (int) Math.floor(Math.random() * namesPack.length);
        String name = namesPack[randomNameIndex];
        int id = (int) ((Math.random() * (100000 - 1)) + 1);
        int age = (int) ((Math.random() * (100 - 14)) + 14);
        return new Customer(id, name, age);
    }

    public String[] getNamesPack() {
        return namesPack;
    }

    public void setNamesPack(String[] namesPack) {
        this.namesPack = namesPack;
    }
}
