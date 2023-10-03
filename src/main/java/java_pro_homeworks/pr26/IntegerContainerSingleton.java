package java_pro_homeworks.pr26;

/*
* Singleton Object
*
* Via this instance you can set or get integer contained value
* */

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerContainerSingleton {
    AtomicInteger instancesCounter = new AtomicInteger(0);
    private static IntegerContainerSingleton instance;

    private IntegerContainerSingleton(){
        instancesCounter.incrementAndGet();
    }

    public static IntegerContainerSingleton  getInstance(){
        if (instance==null){
            instance = new IntegerContainerSingleton();
        }
        return instance;
    }

    public AtomicInteger getInstancesCounter(){
        return instancesCounter;
    }
}
