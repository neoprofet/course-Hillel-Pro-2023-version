package java_pro_homeworks.pr25.tasks;

public class FibonacciRunnableTask implements Runnable {

    final private int sequenceLength;

    /**
     * Result of Runnable task here
     * Getter included
     */
    private int result;

    /**
     * Fields for Fibonacci algorithm
     */
    private int first = 0;
    private int second = 1;
    private int sum;

    public FibonacciRunnableTask(int sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    @Override
    public void run() {
        for (int i = 0; i < sequenceLength; i++) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("interrupted");
                break;
            }
            sum = first + second;
            first = second;
            second = sum;

        }
        result = second;
    }

    public int getResult() {
        return result;
    }

}
