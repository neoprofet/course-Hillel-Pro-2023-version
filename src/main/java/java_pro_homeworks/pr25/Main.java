package java_pro_homeworks.pr25;

import java_pro_homeworks.pr25.point.Point;
import java_pro_homeworks.pr25.point_tasks.*;
import java_pro_homeworks.pr25.tasks.FibonacciRunnableTask;
import java_pro_homeworks.pr25.tasks.FibonacciThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * TASK 1
 * <p>
 * Создать 2000 одновременных задач в Executor, которые двигают единственную двухмерную точку (Point)
 * в одном направлении.
 * Подтвердить проблему атомарности и решить ее
 * с помощью ключевого слова synchronized (все варианты мониторов).
 * <p>
 * TASK 2
 * <p>
 * Создать и запустить поток для вычисления N-го числа Фибоначчи, наследуя класс Thread.
 * <p>
 * TASK 3
 * <p>
 * Создать и запустить поток для вычисления N-го числа Фибоначчи, используя класс Runnable.
 * <p>
 * TASK 4
 * <p>
 * Реализовать прерывание потоков из заданий выше через 3 секунды.
 * Вывести результаты после завершения всех потоков с отметкой прерванных вычислений.
 */
public class Main {
    /**
     * TASK 1A
     * <p>
     * Создать 2000 одновременных задач в Executor, которые двигают единственную двухмерную точку (Point)
     * в одном направлении.
     * <p>
     * A: Подтвердить проблему атомарности
     * Используется непотокозащищенный метод
     */
    public static class Task1 {
        public static void main(String[] args) {
            Point point = new Point(0, 0);
            ExecutorService executor = Executors.newCachedThreadPool();
            // stack all futures
            List<Future<?>> futuresToRunList = new ArrayList<>();

            try {
                for (int i = 0; i < 2000; i++) {
                    futuresToRunList.add(executor.submit(
                            // method that confirms race condition problem
                            new PointMovingNonThreadSafeRunnableTask(point, 1, 1)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // execute all futures (concurrency)
            for (Future<?> future : futuresToRunList) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(point);
        }
    }

    /**
     * TASK 1B
     * <p>
     * Создать 2000 одновременных задач в Executor, которые двигают единственную двухмерную точку (Point)
     * в одном направлении.
     * <p>
     * B: Решить проблему атомарности
     * Используется нестатический синхронизированный метод
     */
    public static class Task1B {
        public static void main(String[] args) {
            Point point = new Point(0, 0);
            ExecutorService executor = Executors.newCachedThreadPool();
            // stack all futures
            List<Future<?>> futuresToRunList = new ArrayList<>();

            try {
                for (int i = 0; i < 2000; i++) {
                    futuresToRunList.add(executor.submit(
                            // method#1 of solving race condition problem
                            new PointMovingSynchronizedMethodRunnableTask(point, 1, 1)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // execute all futures (concurrency)
            for (Future<?> future : futuresToRunList) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(point);
        }
    }

    /**
     * TASK 1C
     * <p>
     * Создать 2000 одновременных задач в Executor, которые двигают единственную двухмерную точку (Point)
     * в одном направлении.
     * <p>
     * B: Решить проблему атомарности
     * Используется статический синхронизированный метод
     */
    public static class Task1C {
        public static void main(String[] args) {
            Point point = new Point(0, 0);
            ExecutorService executor = Executors.newCachedThreadPool();
            // stack all futures
            List<Future<?>> futuresToRunList = new ArrayList<>();

            try {
                for (int i = 0; i < 2000; i++) {
                    futuresToRunList.add(executor.submit(
                            // method#2 of solving race condition problem
                            new PointMovingStaticSynchronizedMethodRunnableTask(point, 1, 1)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // execute all futures (concurrency)
            for (Future<?> future : futuresToRunList) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(point);
        }
    }

    /**
     * TASK 1D
     * <p>
     * Создать 2000 одновременных задач в Executor, которые двигают единственную двухмерную точку (Point)
     * в одном направлении.
     * <p>
     * B: Решить проблему атомарности
     * Используется нестатический метод с блоком синхронизации
     */
    public static class Task1D {
        public static void main(String[] args) {
            Point point = new Point(0, 0);
            ExecutorService executor = Executors.newCachedThreadPool();
            // stack all futures
            List<Future<?>> futuresToRunList = new ArrayList<>();

            try {
                for (int i = 0; i < 2000; i++) {
                    futuresToRunList.add(executor.submit(
                            // method#3 of solving race condition problem
                            new PointMovingSynchronizedBlockRunnableTask(point, 1, 1)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // execute all futures (concurrency)
            for (Future<?> future : futuresToRunList) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(point);
        }
    }

    /**
     * TASK 1E
     * <p>
     * Создать 2000 одновременных задач в Executor, которые двигают единственную двухмерную точку (Point)
     * в одном направлении.
     * <p>
     * B: Решить проблему атомарности
     * Используется статический метод с блоком синхронизации
     */
    public static class Task1E {
        public static void main(String[] args) {
            Point point = new Point(0, 0);
            ExecutorService executor = Executors.newCachedThreadPool();
            // stack all futures
            List<Future<?>> futuresToRunList = new ArrayList<>();

            try {
                for (int i = 0; i < 2000; i++) {
                    futuresToRunList.add(executor.submit(
                            // method#4 of solving race condition problem
                            new PointMovingStaticSynchronizedBlockRunnableTask(point, 1, 1)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // execute all futures (concurrency)
            for (Future<?> future : futuresToRunList) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(point);
        }
    }

    /**
     * TASK 2
     * <p>
     * Создать и запустить поток для вычисления N-го числа Фибоначчи,
     * наследуя класс Thread.
     */
    public static class Task2 {
        public static void main(String[] args) {
            FibonacciThread thread = new FibonacciThread(5);
            thread.start();
            try {
                // блокирует текущий поток пока не выполнится
                thread.join();

                int result = thread.getResult();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * TASK 3
     * <p>
     * Создать и запустить поток для вычисления N-го числа Фибоначчи,
     * используя класс Runnable.
     */
    public static class Task3 {
        public static void main(String[] args) {
            FibonacciRunnableTask runnableTask = new FibonacciRunnableTask(10);
            Thread thread = new Thread(runnableTask);
            thread.start();
            try {
                // блокирует текущий поток пока не выполнится
                thread.join();

                int result = runnableTask.getResult();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * TASK 4
     * <p>
     * Реализовать прерывание потоков из заданий выше через 3 секунды.
     * Вывести результаты после завершения всех потоков с отметкой прерванных вычислений.
     */
    public static class Task4 {
        public static void main(String[] args) {

            //поток 1
            FibonacciThread fibonacciThread1 = new FibonacciThread(10);
            fibonacciThread1.start();
            try {
                fibonacciThread1.join(5);

                System.out.println("(thread 1)Last number is " + fibonacciThread1.getResult());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //поток 2
            FibonacciRunnableTask fibonacciRunnable = new FibonacciRunnableTask(10);
            Thread fibonacciThread2 = new Thread(fibonacciRunnable);
            fibonacciThread2.start();
            try{
                fibonacciThread2.join(10);
                fibonacciThread2.interrupt();
                System.out.println("(thread 2)Last number is " + fibonacciRunnable.getResult());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
