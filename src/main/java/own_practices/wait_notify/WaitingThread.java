package own_practices.wait_notify;

public class WaitingThread extends Thread {

    private final Object mutex;

    public WaitingThread(Object mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        synchronized (mutex){
            System.out.println("Before wait");
            try {
                mutex.wait();
            } catch (InterruptedException ignored) {}
            System.out.println("after wait");
        }
    }
}
