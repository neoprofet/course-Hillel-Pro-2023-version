package own_practices.wait_notify;

public class Main2 {
    public static void main(String[] args) {
        Object mutex = new Object();

        ThreadSwitcher thread1 = new ThreadSwitcher(mutex,1,1);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        ThreadSwitcher thread2 = new ThreadSwitcher(mutex,1,2);
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        ThreadSwitcher thread3 = new ThreadSwitcher(mutex,1,3);
        thread3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        ThreadSwitcher thread4 = new ThreadSwitcher(mutex,2,4);
        thread4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        ThreadSwitcher thread5 = new ThreadSwitcher(mutex,1,5);
        thread5.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        ThreadSwitcher thread6 = new ThreadSwitcher(mutex,2,6);
        thread6.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

    }
}
