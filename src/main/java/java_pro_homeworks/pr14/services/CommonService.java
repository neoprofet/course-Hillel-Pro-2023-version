package java_pro_homeworks.pr14.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class CommonService {
    /**
     * Найти елементы в коллекции по определенному Предикату
     * <p>
     * Входные параметры: Generic-Коллекция, Generic-Предикат
     * <p>
     * Выходные параметры: Generic-Коллекция
     */
    public <T> Collection<T> findByPredicate(Collection<T> items, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

}
