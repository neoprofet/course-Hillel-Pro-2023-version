package java_pro_homeworks.pr24;

import java_pro_homeworks.pr24.tasks.GetFactorialCallableTask;
import java_pro_homeworks.pr24.tasks.GetFibonacciLastPairCallableTask;
import java_pro_homeworks.pr24.tasks.StopwatchRunnableTask;

import java.util.concurrent.*;

/**
 * TASK 1
 * <p>
 * Реализовать подсчет факториала в отдельном классе с поддержкой отмены.
 * Подробно выводить каждый шаг программы.
 * <p>
 * TASK 2
 * <p>
 * Реализовать подсчет чисел Фибоначчи с сохранением последней пары
 * чисел в полях класса задачи (отдельный класс для задачи; поддержка отмены).
 * Подробно выводить каждый шаг программы.
 * <p>
 * TASK 3
 * <p>
 * Реализовать секундомер (отдельный класс для задачи; поддержка отмены).
 * Подробно выводить каждый шаг программы.
 */
public class Main {

    /**
     * TASK 1
     * <p>
     * Реализовать подсчет факториала в отдельном классе с поддержкой отмены.
     * Подробно выводить каждый шаг программы.
     */

    public static class Task1 {
        public static void main(String[] args) {
            GetFactorialCallableTask task = new GetFactorialCallableTask(5);
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> future = executor.submit(task);

            try {
                Integer result = future.get(5, TimeUnit.MILLISECONDS);
                System.out.println(result);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                future.cancel(true);
                System.out.println("Timeout. Task has been cancelled");
            } catch (InterruptedException e) {
                future.cancel(true);
                System.out.println("Task has been interrupted and cancelled");

            }
        }

        /**
         * TASK 2
         * <p>
         * Реализовать подсчет чисел Фибоначчи с сохранением последней пары
         * чисел в полях класса задачи (отдельный класс для задачи; поддержка отмены).
         * Подробно выводить каждый шаг программы.
         */
        public static class Task2 {
            public static void main(String[] args) {
                GetFibonacciLastPairCallableTask getFibonacciLastPairCallableTask = new GetFibonacciLastPairCallableTask(20);
                ExecutorService executor = Executors.newSingleThreadExecutor();
                Future<Pair<Integer>> future = executor.submit(getFibonacciLastPairCallableTask);
                try {
                    Pair<Integer> pair = future.get(1, TimeUnit.MICROSECONDS);
                    System.out.println(pair.getFirst());
                    System.out.println(pair.getSecond());

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    future.cancel(true);
                    System.out.println("Timeout. Task has been cancelled");
                } catch (InterruptedException e) {
                    future.cancel(true);
                    System.out.println("Task has been interrupted and cancelled");
                }
            }
        }

        /**
         * TASK 3
         * <p>
         * Реализовать секундомер (отдельный класс для задачи; поддержка отмены).
         * Подробно выводить каждый шаг программы.
         */
        public static class Task3 {
            public static void main(String[] args) {
                StopwatchRunnableTask task = new StopwatchRunnableTask();
                ExecutorService executor = Executors.newSingleThreadExecutor();
                Future<?> future = executor.submit(task);
                try {
                   future.get(3111, TimeUnit.MILLISECONDS);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    future.cancel(true);
                    System.out.println("Timeout. Task has been cancelled");
                } catch (InterruptedException e) {
                    future.cancel(true);
                    System.out.println("Task has been interrupted and cancelled");
                }
            }
        }
    }
}
