package java_pro_homeworks.pr5B.product_module;

public class ProductFactory {
    private Product[] productsPack1 = {
          new Product(1, "Cola", 30),
            new Product(2, "Pepsi", 30),
            new Product(3, "Fanta", 30),
            new Product(4, "Apple Juice", 35),
            new Product(5, "Cherry Juice", 35),
            new Product(6, "Milkshake", 40),
            new Product(7, "Ice Latte", 40),
            new Product(8, "Bubble Tea", 90),
            new Product(9, "Mokka", 40),
            new Product(10, "Ice Cream Cherry", 60),
            new Product(11, "Ice Cream Strawberry", 60),
            new Product(12, "Ice Cream Chocolate", 60),
            new Product(13, "Ice Cream Vanilla", 50),
            new Product(14, "Chicken burger", 75),
            new Product(15, "Junior burger", 70),
            new Product(16, "Big burger", 100),
            new Product(17, "Royal Burger", 130),
            new Product(18, "Fried Potato", 55)
    };

    public Product getRandomProduct(){
        int randomProductIndex = (int) Math.floor(Math.random() * productsPack1.length);
        return productsPack1[randomProductIndex];
    }

    /*
    * Вернуть набор продуктов (несколько)
    * Продукт выбирается случайно (рандом)
    *
    * Количество продуктов также выбирается случайно, входной параметр maxCount
    * определяет максимально возможное количество продуктов в наборе, но если это число больше, чем
    * количество продуктов в меню, то maxCount = количество продуктов в меню.
    * */
    public Product[] getRandomProducts(int maxCount){
        if (maxCount>= productsPack1.length){
            maxCount = productsPack1.length;
        }
        if (maxCount<= 0){
            maxCount = 2;
        }
        int definedCount = (int) ((Math.random() * (maxCount - 1)) + 1);
        Product[] pack = new Product[definedCount];
        for (int i = 0; i < definedCount; i++) {
            pack[i] = getRandomProduct();
        }
        return pack;
    }

    public Product[] getProductsPack1() {
        return productsPack1;
    }
}
