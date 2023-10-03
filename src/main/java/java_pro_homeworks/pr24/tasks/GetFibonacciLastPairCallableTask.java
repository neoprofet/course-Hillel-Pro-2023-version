package java_pro_homeworks.pr24.tasks;

import java_pro_homeworks.pr24.Pair;

import java.util.concurrent.Callable;

public class GetFibonacciLastPairCallableTask implements Callable<Pair<Integer>> {
    private final int lengthOfSequence;

    public GetFibonacciLastPairCallableTask(int lengthOfSequence) {
        this.lengthOfSequence = lengthOfSequence;
    }

    @Override
    public Pair<Integer> call() throws Exception {
        int first = 0;
        int second = 1;
        int sum;
        Pair<Integer> result = new Pair<>(first, second);
        for (int i = 1; i < lengthOfSequence; i++) {
            sum = first + second;
            first = second;
            second = sum;

            result.setFirst(first);
            result.setSecond(second);

            // CANCELLATION SUPPORT HERE
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Last pair before cancellation: ");
                System.out.println(result.getFirst());
                System.out.println(result.getSecond());
                break;
            }

        }
        return result;
    }
}
