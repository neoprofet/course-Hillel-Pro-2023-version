package java_pro_homeworks.pr23.tasks;

import java.util.Collection;
import java.util.concurrent.Callable;

public class FindAvgElementFromIntegerCollectionCallableTask implements Callable<Double> {
    private final Collection<Integer> collection;

    public FindAvgElementFromIntegerCollectionCallableTask(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public Double call() throws Exception {
        return collection.stream().mapToDouble(x->x).average().orElse(0.0);
    }
}
