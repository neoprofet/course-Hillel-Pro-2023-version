package java_pro_homeworks.pr24.tasks;
import java.util.concurrent.Callable;

public class GetFactorialCallableTask implements Callable<Integer> {
    private final int number;

    public GetFactorialCallableTask(int number) {
        this.number = number;
    }


    @Override
    public Integer call() throws Exception {
        int result = 1;
        for (int i = 1; i <= number ; i++) {
            result = result*i;
            System.out.println("Iteration: " + result);

            // CANCELLATION SUPPORT HERE
            if(Thread.currentThread().isInterrupted()){
                break;

            }
        }

        return result;
    }
}
