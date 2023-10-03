package java_pro_homeworks.pr26.tasks;

import java.util.concurrent.CountDownLatch;

public class PrintRandomNumberRunnableTask implements Runnable {

    private final CountDownLatch latch;

    public PrintRandomNumberRunnableTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        int random = (int) (Math.random() * (1000 - 1 + 1)) + 1;
        System.out.println("RandomNumberRunnableTask result: " + random);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        latch.countDown();
    }
}
