package java_pro_homeworks.pr26;

import java_pro_homeworks.pr26.tasks.GetInstanceCounterFromSingletonInstanceRunnableTask;
import java_pro_homeworks.pr26.tasks.PrintRandomNumberRunnableTask;
import java_pro_homeworks.pr26.tasks.SleepingRunnableTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TASK 1
 * <p>
 * Создать 2000 одновременных задач, которые увеличивают целочисленный счетчик на 1.
 * Подтвердить проблему атомарности.
 * Проверить ее решение с помощью volatile или Atomic классов.
 * <p>
 * TASK 2
 * <p>
 * Выполнить ожидание завершения задач с помощью CountDownLatch.
 * <p>
 * TASK 3
 * <p>
 * Получить доступ к singleton-объекту с “ленивой” (lazy) инициализацией из множества потоков
 * с использованием барьера инициализации при помощи класса CountDownLatch.
 * Подтвердить проблему атомарности. Решить ее одним из известных способов.
 * <p>
 * TASK 4
 * <p>
 * Воспроизвести проблему dead lock любым способом.
 */
public class Main {

    /**
     * TASK 1
     * <p>
     * Создать 2000 одновременных задач, которые увеличивают целочисленный счетчик на 1.
     * Подтвердить проблему атомарности.
     * Проверить ее решение с помощью volatile или Atomic классов.
     * <p>
     * Есть глобальная переменная класса, которая инкрементят внутренние локальные статические
     * классы (Runnable tasks). Идет инкрементация примитива и атомика по 2000 раз на каждую переменную
     * В итоге примитив столкнулся с Race condition, атомик нет.
     */
    public static class Task1 {
        static int nonAtomicInteger = 0;
        static AtomicInteger atomicInteger = new AtomicInteger(0);

        public static void main(String[] args) {

            ExecutorService service = Executors.newCachedThreadPool();
            List<Future<?>> futureList1 = new ArrayList<>();
            List<Future<?>> futureList2 = new ArrayList<>();

            // creating all tasks (2000 tasks1, 2000 tasks2)
            for (int i = 0; i < 2000; i++) {
                futureList1.add(service.submit(new NonAtomicIncrementingRunnableTask()));
                futureList2.add(service.submit(new AtomicIncrementingRunnableTask()));
            }

            // execute all tasks (2000 tasks1, 2000 tasks2)
            try {
                for (Future<?> future1 : futureList1) {
                    future1.get();
                }
                for (Future<?> future2 : futureList2) {
                    future2.get();
                }

            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Non-atomic integer: " + nonAtomicInteger);
            System.out.println("Atomic integer: " + atomicInteger.get());

        }

        //Runnable class task. Increments simple integer
        static class NonAtomicIncrementingRunnableTask implements Runnable {
            @Override
            public void run() {
                nonAtomicInteger++;
            }
        }

        //Runnable class task. Increments Atomic integer
        static class AtomicIncrementingRunnableTask implements Runnable {
            @Override
            public void run() {
                atomicInteger.incrementAndGet();
            }
        }

    }

    /**
     * TASK 2
     * <p>
     * Выполнить ожидание завершения задач с помощью CountDownLatch.
     */
    public static class Task2 {
        public static void main(String[] args) {
            CountDownLatch latch = new CountDownLatch(5);
            Executor executor = Executors.newCachedThreadPool();
            try {
                for (int i = 0; i < 5; i++) {
                    executor.execute(new PrintRandomNumberRunnableTask(latch));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                latch.await();
            } catch (InterruptedException ignored) {
            }

            System.out.println("Latch was unlocked");
            System.out.println("Something after that tasks");
        }

    }

    /**
     * TASK 2A
     * <p>
     * Выполнить ожидание завершения задач с помощью CountDownLatch.
     * <p>
     * A: Используется CountDownLatch для одновременного старта всех потоков
     * (additional custom task)
     */
    public static class Task2A {
        public static void main(String[] args) {
            CountDownLatch latch = new CountDownLatch(1);
            Executor executor = Executors.newCachedThreadPool();
            try {
                for (int i = 0; i < 50; i++) {
                    executor.execute(new SleepingRunnableTask(latch));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("now we unlocks that tasks");
            latch.countDown();
        }

    }

    /**
     * TASK 3
     * <p>
     * Получить доступ к singleton-объекту с “ленивой” (lazy) инициализацией из множества потоков
     * с использованием барьера инициализации при помощи класса CountDownLatch.
     * Подтвердить проблему атомарности.
     * Решить ее одним из известных способов.
     */

    public static class Task3 {
        public static void main(String[] args) {

            IntegerContainerSingleton singletonRefer2 = IntegerContainerSingleton.getInstance();
            System.out.println(singletonRefer2.getInstancesCounter());

            Executor executor = Executors.newCachedThreadPool();
            CountDownLatch latch = new CountDownLatch(1);
            for (int i = 0; i < 1000; i++) {
               executor.execute(new GetInstanceCounterFromSingletonInstanceRunnableTask(latch));
            }
            latch.countDown();
        }
    }
    /**
     * TASK 4
     * <p>
     * Воспроизвести проблему dead lock любым способом.
     */
    public static class Task4 {
        private static String sharedStr = "";
        private static Object lock1 = new Object();
        private static Object lock2 = new Object();

        public static void main(String[] args) {
            ExecutorService executor = Executors.newCachedThreadPool();
            Thread thread1 = new Thread(new StringWriterRunnableTask1());
            Thread thread2 = new Thread(new StringWriterRunnableTask2());

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        static class StringWriterRunnableTask1 implements Runnable {

            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("thread 1 start");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sharedStr = sharedStr.concat("string A");
                    synchronized (lock2) {
                        System.out.println("Not reachable statement");
                    }
                }

            }
        }

        static class StringWriterRunnableTask2 implements Runnable {

            @Override
            public void run() {
                System.out.println("thread 2 start");
                synchronized (lock2) {
                    sharedStr = sharedStr.concat("string B");
                    synchronized (lock1) {
                        System.out.println("Not reachable statement");
                    }
                }
            }
        }
    }
}
