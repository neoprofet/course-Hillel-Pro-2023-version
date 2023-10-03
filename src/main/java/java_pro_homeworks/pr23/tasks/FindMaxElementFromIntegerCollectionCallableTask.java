package java_pro_homeworks.pr23.tasks;

import java.util.Collection;
import java.util.concurrent.Callable;


public class FindMaxElementFromIntegerCollectionCallableTask implements Callable<Integer> {

        private final Collection<Integer> collection;

        public FindMaxElementFromIntegerCollectionCallableTask(Collection<Integer> collection) {
            this.collection = collection;
        }


        @Override
        public Integer call() throws Exception {
            return collection.stream().max(Integer::compareTo).orElse(0);
        }
    }


