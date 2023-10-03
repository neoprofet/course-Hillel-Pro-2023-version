package java_pro_homeworks.pr23.tasks;

import java.util.Collection;

public class PrintCollectionRunnableTask<T> implements Runnable{

  final private Collection<T> collection;

    public PrintCollectionRunnableTask(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        for (T t : collection) {
            System.out.println(t);
        }
    }
}
