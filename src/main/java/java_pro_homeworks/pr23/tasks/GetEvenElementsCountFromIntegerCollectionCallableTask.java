package java_pro_homeworks.pr23.tasks;

import java.util.Collection;
import java.util.concurrent.Callable;

public class GetEvenElementsCountFromIntegerCollectionCallableTask implements Callable<Integer> {
private final Collection<Integer> collection;

    public GetEvenElementsCountFromIntegerCollectionCallableTask(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        return (int) collection.stream().filter(x->x%2==0).count();
    }

}
