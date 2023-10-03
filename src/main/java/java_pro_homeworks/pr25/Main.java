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
 * ������� 2000 ������������� ����� � Executor, ������� ������� ������������ ���������� ����� (Point)
 * � ����� �����������.
 * ����������� �������� ����������� � ������ ��
 * � ������� ��������� ����� synchronized (��� �������� ���������).
 * <p>
 * TASK 2
 * <p>
 * ������� � ��������� ����� ��� ���������� N-�� ����� ���������, �������� ����� Thread.
 * <p>
 * TASK 3
 * <p>
 * ������� � ��������� ����� ��� ���������� N-�� ����� ���������, ��������� ����� Runnable.
 * <p>
 * TASK 4
 * <p>
 * ����������� ���������� ������� �� ������� ���� ����� 3 �������.
 * ������� ���������� ����� ���������� ���� ������� � �������� ���������� ����������.
 */
public class Main {
    /**
     * TASK 1A
     * <p>
     * ������� 2000 ������������� ����� � Executor, ������� ������� ������������ ���������� ����� (Point)
     * � ����� �����������.
     * <p>
     * A: ����������� �������� �����������
     * ������������ ������������������ �����
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
     * ������� 2000 ������������� ����� � Executor, ������� ������� ������������ ���������� ����� (Point)
     * � ����� �����������.
     * <p>
     * B: ������ �������� �����������
     * ������������ ������������� ������������������ �����
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
     * ������� 2000 ������������� ����� � Executor, ������� ������� ������������ ���������� ����� (Point)
     * � ����� �����������.
     * <p>
     * B: ������ �������� �����������
     * ������������ ����������� ������������������ �����
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
     * ������� 2000 ������������� ����� � Executor, ������� ������� ������������ ���������� ����� (Point)
     * � ����� �����������.
     * <p>
     * B: ������ �������� �����������
     * ������������ ������������� ����� � ������ �������������
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
     * ������� 2000 ������������� ����� � Executor, ������� ������� ������������ ���������� ����� (Point)
     * � ����� �����������.
     * <p>
     * B: ������ �������� �����������
     * ������������ ����������� ����� � ������ �������������
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
     * ������� � ��������� ����� ��� ���������� N-�� ����� ���������,
     * �������� ����� Thread.
     */
    public static class Task2 {
        public static void main(String[] args) {
            FibonacciThread thread = new FibonacciThread(5);
            thread.start();
            try {
                // ��������� ������� ����� ���� �� ����������
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
     * ������� � ��������� ����� ��� ���������� N-�� ����� ���������,
     * ��������� ����� Runnable.
     */
    public static class Task3 {
        public static void main(String[] args) {
            FibonacciRunnableTask runnableTask = new FibonacciRunnableTask(10);
            Thread thread = new Thread(runnableTask);
            thread.start();
            try {
                // ��������� ������� ����� ���� �� ����������
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
     * ����������� ���������� ������� �� ������� ���� ����� 3 �������.
     * ������� ���������� ����� ���������� ���� ������� � �������� ���������� ����������.
     */
    public static class Task4 {
        public static void main(String[] args) {

            //����� 1
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

            //����� 2
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
