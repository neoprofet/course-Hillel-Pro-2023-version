package java_pro_homeworks.pr25.tasks;

public class FibonacciThread extends Thread {

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

    public FibonacciThread(int sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    @Override
    public void run() {
        for (int i = 0; i < sequenceLength; i++) {
            sum = first + second;
            first = second;
            second = sum;
            if(Thread.currentThread().isInterrupted()){
                System.out.println("interrupted");
                break;
            }
        }
        result = second;
    }

    public int getResult() {
        return result;
    }

}
