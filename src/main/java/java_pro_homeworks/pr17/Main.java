package java_pro_homeworks.pr17;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TASK 1
 * <p>
 * Создать текстовый файл и записать в него “Hello, world!”
 * <p>
 * TASK 2
 * <p>
 * Создать текстовый файл и записать в него 1000 случайных целых чисел в диапазоне от -500 до 650, разделенных пробелами.
 * Использовать запятую в качестве разделителя между числами
 * <p>
 * TASK 3
 * <p>
 * Открыть текстовый файл и прочитать из него максимум 100 целых чисел. Найти среднее значение прочитанных положительных чисел
 * Использовать запятую в качестве разделителя между числами
 * <p>
 * TASK 4
 * <p>
 * Сохранить в текстовый файл список контактов (минимум 10, каждый с новой строки)
 * в заданном формате:Имя | Фамилия | Телефон | Год рождения
 * <p>
 * TASK 5
 * <p>
 * Прочитать из текстового файла список контактов в заданном формате,
 * сортировать по году рождения и вывести на экран максимум 5 контактов
 * <p>
 * REMARK
 * <p>
 * Создать 2 входные точки (функции main в разных классах) - в одну перенести задания с записью, а в другую - с чтением.
 */

public class Main {


    /**
     * Создать текстовый файл и записать в него “Hello, world!”
     */
    static class Task1 {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files" + File.separator + "task1.txt";
            try {
                FileHandler.writeTextToFile(FileHandler.getFile(path), "Hello, world!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Создать текстовый файл и записать в него 1000 случайных целых чисел в диапазоне от -500 до 650,
     * разделенных пробелами.
     */
    static class Task2 {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files" + File.separator + "task2.txt";
            try {
                FileHandler.writeTextToFile(FileHandler.getFile(path),
                        ArrayHandler.getArrayToString(
                                ArrayHandler.getRandomIntegerArray(-500, 650, 1000), " "));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Создать текстовый файл и записать в него 1000 случайных целых чисел в диапазоне от -500 до 650
     * Использовать запятую в качестве разделителя между числами
     */
    static class Task2a {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files" + File.separator + "task2a.txt";
            try {
                FileHandler.writeTextToFile(FileHandler.getFile(path),
                        ArrayHandler.getArrayToString(
                                ArrayHandler.getRandomIntegerArray(-500, 650, 1000), ","));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Открыть текстовый файл и прочитать из него максимум 100 целых чисел.
     * Найти среднее значение прочитанных положительных чисел
     */
    static class Task3 {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files" + File.separator + "task2.txt";
            List<Integer> integerList = new ArrayList<>();

            String data = FileHandler.getTextFromFile(FileHandler.getFile(path));
            String[] substrings = data.split(" ");

            for (String substring : substrings) {
                integerList.add(Integer.parseInt(substring));
            }

            double avg = integerList.stream().mapToDouble(Integer::doubleValue)
                    .limit(100).filter(x -> x > 0).average().orElse(0.0);
            System.out.println(avg);
        }
    }

    /**
     * Открыть текстовый файл и прочитать из него максимум 100 целых чисел.
     * Найти среднее значение прочитанных положительных чисел
     * Использовать запятую в качестве разделителя между числами
     */
    static class Task3a {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files" + File.separator + "task2a.txt";
            List<Integer> integerList = new ArrayList<>();

            String data = FileHandler.getTextFromFile(FileHandler.getFile(path));
            String[] substrings = data.split(",");

            for (String substring : substrings) {
                integerList.add(Integer.parseInt(substring));
            }

            double avg = integerList.stream().mapToDouble(Integer::doubleValue)
                    .limit(100).filter(x -> x > 0).average().orElse(0.0);
            System.out.println(avg);
        }
    }

    /**
     * Сохранить в текстовый файл список контактов (минимум 10, каждый с новой строки)
     * в заданном формате:Имя | Фамилия | Телефон | Год рождения
     */
    static class Task4 {
        public static void main(String[] args) {
            Contact[] contacts = new Contact[]{
                    new Contact("Den", "Yarovoy", "+380956987340", 2002),
                    new Contact("Ilya", "Safronov", "+380957937216", 2002),
                    new Contact("Maria", "Kovalevskaya", "+380957236551", 2004),
                    new Contact("Ihor", "Vanda", "+380953290652", 2002),
                    new Contact("Pavel", "Muzika", "+380501699727", 2002),
                    new Contact("Lesya", "Savvina", "+380956722453", 2003),
                    new Contact("Ludmila", "Yarovaya", "+380951862426", 1973),
                    new Contact("Nikolay", "Yarovoy", "+380951862532", 1968),
                    new Contact("Vanya", "Bondarenko", "+380951262501", 2000),
                    new Contact("Kirill", "Vaflev", "+380501722454", 2001),
            };
            String path = "src" + File.separator + "files" + File.separator + "task4.txt";
            try {
                FileHandler.writeTextToFile(FileHandler.getFile(path),
                        ContactHandler.getContactsToString(contacts, "|"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Прочитать из текстового файла список контактов в заданном формате,
     * сортировать по году рождения и вывести на экран максимум 5 контактов
     */
    static class Task5 {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files" + File.separator + "task4.txt";
            List<Contact> contacts = ContactHandler.getContactsFromFile(FileHandler.getFile(path), "\\|");

            contacts.stream()
                    .sorted((x, y) -> (x.getYearOfBirth() - y.getYearOfBirth()))
                    .limit(5)
                    .forEach(System.out::println);
        }
    }
}


