package java_pro_homeworks.pr23;

import java_pro_homeworks.pr23.factories.IntegerRandomCollectionFactory;
import java_pro_homeworks.pr23.tasks.*;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TASK 1
 * <p>
 * Выполните вывод коллекции целых чисел в отдельной задаче, используя интерфейс ExecutorService.
 * (A) Дождитесь выполнения операции в основном потоке.
 * <p>
 * TASK 2
 * <p>
 * Выполните подсчет минимального, максимального, среднего значения и суммы элементов коллекции.
 * <p>
 * (A) Дождитесь выполнения операций в основном потоке.
 * <p>
 * (B) Используйте несколько вариантов ExecutorService с разным количеством потоков внутри.
 * <p>
 * TASK 3
 * <p>
 * Исследуйте загрузку процессора при использовании Future.
 * Выполните Thread.sleep() в отдельной задаче и ожидайте завершения с использованием:
 * <p>
 * (A) Метода Future.get()
 * <p>
 * (B) Цикла while и метода Future.isDone()
 */
public class Main {
    /**
     * TASK 1
     */
    public static class Task1 {
        public static void main(String[] args) {
            Collection<Integer> integers = IntegerRandomCollectionFactory.generate(100);
            PrintCollectionRunnableTask<Integer> task = new PrintCollectionRunnableTask<>(integers);
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<?> res = executor.submit(task);
            try {
                res.get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * TASK 2A
     */
    public static class Task2A {
        public static void main(String[] args) {

            Collection<Integer> integers = IntegerRandomCollectionFactory.generate(100);
            FindAvgElementFromIntegerCollectionCallableTask taskAvg =
                    new FindAvgElementFromIntegerCollectionCallableTask(integers);
            FindMaxElementFromIntegerCollectionCallableTask taskMax =
                    new FindMaxElementFromIntegerCollectionCallableTask(integers);
            FindMinElementFromIntegerCollectionCallableTask taskMin =
                    new FindMinElementFromIntegerCollectionCallableTask(integers);

            ExecutorService executor = Executors.newSingleThreadExecutor();

            Future<Double> resAvg = executor.submit(taskAvg);
            Future<Integer> resMax = executor.submit(taskMax);
            Future<Integer> resMin = executor.submit(taskMin);

            Long start = System.currentTimeMillis();
            try {
                Integer min = resMin.get();
                System.out.println("MIN: " + min);
                Integer max = resMax.get();
                System.out.println("MAX: " + max);
                Double avg = resAvg.get();
                System.out.println("AVG: " + avg);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            Long end = System.currentTimeMillis();
            System.out.println("Time: " + (end - start));


        }
    }

    /**
     * TASK 2B
     */
    public static class Task2B {
        public static void main(String[] args) {

            Collection<Integer> integers = IntegerRandomCollectionFactory.generate(100);
            FindAvgElementFromIntegerCollectionCallableTask taskAvg =
                    new FindAvgElementFromIntegerCollectionCallableTask(integers);
            FindMaxElementFromIntegerCollectionCallableTask taskMax =
                    new FindMaxElementFromIntegerCollectionCallableTask(integers);
            FindMinElementFromIntegerCollectionCallableTask taskMin =
                    new FindMinElementFromIntegerCollectionCallableTask(integers);

            ExecutorService executor = Executors.newCachedThreadPool();

            Future<Double> resAvg = executor.submit(taskAvg);
            Future<Integer> resMax = executor.submit(taskMax);
            Future<Integer> resMin = executor.submit(taskMin);

            Long start = System.currentTimeMillis();

            try {
                Integer min = resMin.get();
                System.out.println("MIN: " + min);
                Integer max = resMax.get();
                System.out.println("MAX: " + max);
                Double avg = resAvg.get();
                System.out.println("AVG: " + avg);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            Long end = System.currentTimeMillis();
            System.out.println("Time: " + (end - start));
        }
    }

    /**
     * TASK 3A
     */
    public static class Task3A {
        public static void main(String[] args) {
            Collection<Integer> integers = IntegerRandomCollectionFactory.generate(100);
            GetEvenElementsCountFromIntegerCollectionCallableTask task =
                    new GetEvenElementsCountFromIntegerCollectionCallableTask(integers);
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<Integer> future = executorService.submit(task);

            try {
                Integer count = future.get();
                System.out.println("Even count:" + count);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * TASK 3B
     */
    public static class Task3B {
        public static void main(String[] args) {
            Collection<Integer> integers = IntegerRandomCollectionFactory.generate(100);
            GetEvenElementsCountFromIntegerCollectionCallableTask task =
                    new GetEvenElementsCountFromIntegerCollectionCallableTask(integers);
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<Integer> future = executorService.submit(task);

            try {
                int loopCount = 0;
                while (true) {
                    System.out.println(loopCount++);
                    if (future.isDone()) break;
                }
                Integer count = future.get();
                System.out.println("Even count:" + count);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
