package java_pro_homeworks.pr12;

import java.util.NoSuchElementException;
import java.util.Objects;


public class MyOptional<T> {
    private T item;

    private MyOptional(T item) {
        this.item = item;
    }

    public boolean isPresent() {
        return item != null;
    }

    public T get() throws NoSuchElementException {
        if (isPresent()) return item;
        else throw new NoSuchElementException();
    }

    public static <T> MyOptional<T> of(T item) {
        return new MyOptional<T>(item);
    }

    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    public static <T> MyOptional<T> ofNullable(T item) {
        if (item != null) return of(item);
        else return empty();
    }

    public T orElse(T other) {
        if (isPresent()) return get();
        else return other;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        return o instanceof MyOptional<?> other
                && Objects.equals(item, other.item);
    }

    @Override
    public int hashCode() {
        if (isPresent()) return Objects.hashCode(item);
        else return 0;
    }


}



