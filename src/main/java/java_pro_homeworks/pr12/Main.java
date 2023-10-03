package java_pro_homeworks.pr12;

import java.util.Optional;

/**
 * ����������� ���������� ������ java.util.Optional<T>
 * �������� ����� � ��������� ����� ���� T.
 * ����������� ��������� �����������, ����������� ��������� ���� T.
 * ����������� ����� isPresent(), ������������ true, ���� ������������ ��������� �� null.
 * ����������� ����� get(), ������������ ������������ ���������, ��� ��������� ���������� NoSuchElementException, ���� ���� null.
 * ����������� ����������� ������ ������ empty(), ofNullable() � of() �������� ������������.
 * ����������� ����� orElse() �������� ������������.
 * ����������� ������ equals() � hashCode() �������� ������������.
 * <p>
 * TODO
 * <p>
 * ����������� ����� ifPresent() �������� ������������.
 * ����������� ������ orElseGet() � orElseThrow() �������� ������������.
 * ����������� ����� filter() �������� ������������.
 * ����������� ������ map() � flatMap() �������� ������������.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("========================== OPTIONAL ==========================");
        Optional<Human> optional = Optional.of(new Human(10, "Den"));
        Human human1 = optional.get();
        System.out.println(human1);
        // Optional<?> emp = Optional.empty();
        // System.out.println(emp.get());
        System.out.println("======================== MY OPTIONAL =========================");
        MyOptional<Human> myOptional = MyOptional.of(new Human(11, "Ilya"));
        System.out.println("Is present: " + myOptional.isPresent());
        MyOptional<Human> myOptional1 = MyOptional.of(null);
        System.out.println(myOptional1.orElse(new Human(12, "Other human")));
    }

    static class Human {
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
