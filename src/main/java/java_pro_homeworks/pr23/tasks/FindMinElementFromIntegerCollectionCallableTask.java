package java_pro_homeworks.pr23.tasks;


import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class FindMinElementFromIntegerCollectionCallableTask implements Callable<Integer> {
    private final Collection<Integer> collection;

    public FindMinElementFromIntegerCollectionCallableTask(Collection<Integer> collection) {
        this.collection = collection;
    }


    @Override
    public Integer call() throws Exception {
        return collection.stream().min(Integer::compareTo).orElse(0);
    }
}
