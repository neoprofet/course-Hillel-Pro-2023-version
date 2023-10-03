package java_pro_homeworks.pr16;

import java_pro_homeworks.pr16.exceptions.MyDomainException;

import java.io.IOException;

/**
 * TASK 1
 * <p>
 * Объявить класс Student. Объявить сеттеры для полей.
 * Бросить исключение IllegalArgumentException в setAge(int), если возраст дан неверно.
 * Бросить исключение IllegalArgumentException в setName(String), если имя пустое или null.
 * <p>
 * TASK 2
 * <p>
 * Объявить метод deserialize(String), который имеет возвращаемый тип Student.
 * Этот метод ничего не делает пока.
 * <p>
 * Объявить класс MyDomainException наследником класса Exception.
 * <p>
 * Бросить проверяемое (checked) исключение MyDomainException из метода deserialize(String).
 * <p>
 * Вызвать метод deserialize(String) в контексте main и перехватить исключение с
 * выводом стека вызовов и других деталей (недостаточно вызвать метод printStackTrace).
 * <p>
 * Task 3
 * <p>
 * Обернуть вызов метода deserialize(String) в другую функцию,
 * которая перебросит исключение, используя оператор throw.
 * Проверить сохранение стека вызовов.
 * <p>
 * Task 4
 * <p>
 * Обернуть вызов метода deserialize(String) в другую функцию, которая перехватит
 * исключение и обернёт его в непроверяемое (unchecked) исключение.
 * Проверить сохранение стека вызовов.
 * <p>
 * Task 5
 * <p>
 * Продемонстрировать перехват разных исключений с помощью нескольких блоков catch.
 * <p>
 * Продемонстрировать использование блока finally.
 */
public class Main {

    /**
     * Объявить класс Student. Объявить сеттеры для полей.
     * Бросить исключение IllegalArgumentException в setAge(int), если возраст дан неверно.
     * Бросить исключение IllegalArgumentException в setName(String), если имя пустое или null.
     */
    public static class Task1 {
        public static void main(String[] args) {
            try {
                Student student = new Student(-2, "", 122, 5, false);
            } catch (IllegalArgumentException e) {
                System.out.println("Arguments are not valid");
            }
        }
    }

    /**
     * Объявить метод deserialize(String), который имеет возвращаемый тип Student.
     * Этот метод ничего не делает пока.
     * <p>
     * Объявить класс MyDomainException наследником класса Exception.
     * <p>
     * Бросить проверяемое (checked) исключение MyDomainException из метода deserialize(String).
     * <p>
     * Вызвать метод deserialize(String) в контексте main и перехватить исключение с
     * выводом стека вызовов и других деталей (недостаточно вызвать метод printStackTrace).
     */
    public static class Task2 {
        public static void main(String[] args) {
            String studentStr = new Student(21, "Den", 122, 4, true).toString();
            Deserializer deserializer = new Deserializer();
            try {
                deserializer.deserialize(studentStr);
            } catch (MyDomainException e) {
                System.out.println("Cannot be serialized. Incorrect representation of String");
                e.printStackTrace();
            }
        }
    }

    /**
     * Обернуть вызов метода deserialize(String) в другую функцию,
     * которая перебросит исключение, используя оператор throw.
     * Проверить сохранение стека вызовов.
     */
    public static class Task3 {
        public static void main(String[] args) {
            System.out.println("Program starts");
            try {
                rethrowExceptionMethod();
            } catch (MyDomainException e) {
                System.out.println("STACK TRACE 2");
                e.printStackTrace(System.out);
            }
        }

        static void rethrowExceptionMethod() throws MyDomainException {
            String studentStr = new Student(21, "Den", 122, 4, true).toString();
            Deserializer deserializer = new Deserializer();
            try {
                deserializer.deserialize(studentStr);
            } catch (MyDomainException e) {
                System.out.println("STACK TRACE 1");
                e.printStackTrace(System.out);
                throw e;
            }
        }

        /**
         * Обернуть вызов метода deserialize(String) в другую функцию, которая перехватит
         * исключение и обернёт его в непроверяемое (unchecked) исключение.
         * Проверить сохранение стека вызовов.
         */

        public static class Task4 {
            public static void main(String[] args) {
                System.out.println("Program starts");
                try {
                    rethrowExceptionMethod();
                } catch (Exception e) {
                    System.out.println("STACK TRACE 2");
                    e.printStackTrace(System.out);
                }
            }

            static void rethrowExceptionMethod() {
                String studentStr = new Student(21, "Den", 122, 4, true).toString();
                Deserializer deserializer = new Deserializer();
                try {
                    deserializer.deserialize(studentStr);
                } catch (MyDomainException e) {
                    System.out.println("STACK TRACE 1");
                    e.printStackTrace(System.out);
                    throw new RuntimeException("Inner unchecked exception", e);
                }
            }

        }

        /**
         * Продемонстрировать перехват разных исключений с помощью нескольких блоков catch.
         * <p>
         * Продемонстрировать использование блока finally.
         */
        public static class Task5 {

            public static void main(String[] args) {
                String studentStr = new Student(21, "Den", 122, 4, true).toString();
                Deserializer deserializer = new Deserializer();
                try {
                    if (Math.random() < 0.3) {
                        deserializer.deserialize(studentStr);
                    }  else if (Math.random() > 0.3 && Math.random() < 0.6){
                        throw new IOException();
                    }
                } catch (MyDomainException e) {
                    System.out.println("MY DOMAIN EXCEPTION");
                    e.printStackTrace(System.out);
                } catch (IOException e) {
                    System.out.println("IO EXCEPTION");
                    e.printStackTrace(System.out);
                } finally {
                    System.out.println("FINALLY");
                }

                System.out.println("PROGRAM FINISHED WITHOUT ANY PROBLEM");
            }

        }
    }
}
