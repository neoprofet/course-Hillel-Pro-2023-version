package java_pro_homeworks.pr26.tasks;

import java_pro_homeworks.pr26.IntegerContainerSingleton;

import java.util.concurrent.CountDownLatch;

public class GetInstanceCounterFromSingletonInstanceRunnableTask implements Runnable {
    private final CountDownLatch latch;

    public GetInstanceCounterFromSingletonInstanceRunnableTask(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException ignored) {}
        IntegerContainerSingleton singleton = IntegerContainerSingleton.getInstance();
        System.out.println(singleton.getInstancesCounter().get());
    }
}
