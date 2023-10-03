package java_pro_homeworks.pr26.tasks;

import java.util.concurrent.CountDownLatch;

public class SleepingRunnableTask implements Runnable{
    private final CountDownLatch latch;

    public SleepingRunnableTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            // waiting for start signal
            latch.await();
        } catch (InterruptedException ignored) {}

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
        System.out.println("task completed");
    }
}
