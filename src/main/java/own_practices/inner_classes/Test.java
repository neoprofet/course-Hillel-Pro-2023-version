package own_practices.inner_classes;

public class Test {

    public static void main(String[] args) {
        Phone phone = new Phone("IPhone 7", "Apple", 2200, 100);
        phone.getBattery().charge();

        Phone.PhoneSoldCounter.setCounter(10);
        System.out.println(Phone.PhoneSoldCounter.getCounter());
    }
}
