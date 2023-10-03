package java_pro_homeworks.pr11;

import java.util.Collection;

public class Handler {
    public static void showCollection(Collection<?> collection){
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
