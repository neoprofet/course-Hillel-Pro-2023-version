package java_pro_homeworks.pr23.tasks;

import java.util.Collection;
import java.util.concurrent.Callable;

public class CalculateElementsSumFromIntegerCollectionCallableTask implements Callable<Integer> {

   private final Collection<Integer> collection;

    public CalculateElementsSumFromIntegerCollectionCallableTask(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public Integer call() throws Exception {
        return collection.stream().mapToInt(x->x).sum();
    }
}
