package own_practices.wait_notify;

public class ThreadSwitcher extends Thread {
    private final Object lock;
    private final int mode;
    private final int threadCustomNumberName;

    public ThreadSwitcher(Object lock, int mode, int threadCustomNumberName) {
        this.lock = lock;
        this.mode = mode;
        this.threadCustomNumberName = threadCustomNumberName;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (mode == 1) {
                try {
                    System.out.println("Thread " + threadCustomNumberName + " before waiting");
                    lock.wait();
                    System.out.println("Thread " + threadCustomNumberName + " after waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Thread " + threadCustomNumberName + " before notify others");
                lock.notifyAll();
                System.out.println("Thread " + threadCustomNumberName + " after notify others");
            }


        }
    }
}
