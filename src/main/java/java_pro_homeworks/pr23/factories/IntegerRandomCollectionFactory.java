package java_pro_homeworks.pr23.factories;

import java.util.ArrayList;
import java.util.Collection;

public class IntegerRandomCollectionFactory {
    public static Collection<Integer> generate(int size){
        Collection<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add((int) (Math.random() * (1000 - 1 + 1)) + 1);
        }
       return result;
    }
}
