package own_practices.wait_notify;

public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();

        WaitingThread waitingThread = new WaitingThread(monitor);
        waitingThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Before notify");

        synchronized (monitor) {
            monitor.notifyAll();
        }
    }

}
