package java_pro_homeworks.pr14.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class CommonService {
    /**
     * ����� �������� � ��������� �� ������������� ���������
     * <p>
     * ������� ���������: Generic-���������, Generic-��������
     * <p>
     * �������� ���������: Generic-���������
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
