package java_pro_homeworks.pr16;

import java_pro_homeworks.pr16.exceptions.MyDomainException;

import java.io.IOException;

/**
 * TASK 1
 * <p>
 * �������� ����� Student. �������� ������� ��� �����.
 * ������� ���������� IllegalArgumentException � setAge(int), ���� ������� ��� �������.
 * ������� ���������� IllegalArgumentException � setName(String), ���� ��� ������ ��� null.
 * <p>
 * TASK 2
 * <p>
 * �������� ����� deserialize(String), ������� ����� ������������ ��� Student.
 * ���� ����� ������ �� ������ ����.
 * <p>
 * �������� ����� MyDomainException ����������� ������ Exception.
 * <p>
 * ������� ����������� (checked) ���������� MyDomainException �� ������ deserialize(String).
 * <p>
 * ������� ����� deserialize(String) � ��������� main � ����������� ���������� �
 * ������� ����� ������� � ������ ������� (������������ ������� ����� printStackTrace).
 * <p>
 * Task 3
 * <p>
 * �������� ����� ������ deserialize(String) � ������ �������,
 * ������� ���������� ����������, ��������� �������� throw.
 * ��������� ���������� ����� �������.
 * <p>
 * Task 4
 * <p>
 * �������� ����� ������ deserialize(String) � ������ �������, ������� ����������
 * ���������� � ������ ��� � ������������� (unchecked) ����������.
 * ��������� ���������� ����� �������.
 * <p>
 * Task 5
 * <p>
 * ������������������ �������� ������ ���������� � ������� ���������� ������ catch.
 * <p>
 * ������������������ ������������� ����� finally.
 */
public class Main {

    /**
     * �������� ����� Student. �������� ������� ��� �����.
     * ������� ���������� IllegalArgumentException � setAge(int), ���� ������� ��� �������.
     * ������� ���������� IllegalArgumentException � setName(String), ���� ��� ������ ��� null.
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
     * �������� ����� deserialize(String), ������� ����� ������������ ��� Student.
     * ���� ����� ������ �� ������ ����.
     * <p>
     * �������� ����� MyDomainException ����������� ������ Exception.
     * <p>
     * ������� ����������� (checked) ���������� MyDomainException �� ������ deserialize(String).
     * <p>
     * ������� ����� deserialize(String) � ��������� main � ����������� ���������� �
     * ������� ����� ������� � ������ ������� (������������ ������� ����� printStackTrace).
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
     * �������� ����� ������ deserialize(String) � ������ �������,
     * ������� ���������� ����������, ��������� �������� throw.
     * ��������� ���������� ����� �������.
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
         * �������� ����� ������ deserialize(String) � ������ �������, ������� ����������
         * ���������� � ������ ��� � ������������� (unchecked) ����������.
         * ��������� ���������� ����� �������.
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
         * ������������������ �������� ������ ���������� � ������� ���������� ������ catch.
         * <p>
         * ������������������ ������������� ����� finally.
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
