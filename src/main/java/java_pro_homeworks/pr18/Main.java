package java_pro_homeworks.pr18;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TASK 1
 * <p>
 * Записать в бинарный файл несколько разнотипных значений, используя DataOutputStream.
 * <p>
 * Прочитать записанные данные из предыдущего задания, используя DataInputStream.
 * <p>
 * TASK2
 * <p>
 * Записать в бинарный файл коллекцию строк (String) и прочитать ее обратно, используя DataOutputStream и DataInputStream.
 * <p>
 * Записать в бинарный файл коллекцию контактов (Contact) и прочитать ее обратно, используя DataOutputStream и DataInputStream.
 * <p>
 * TASK 3
 * <p>
 * Записать в бинарный файл коллекцию контактов (Contact) и прочитать ее обратно, используя Serializable, ObjectOutputStream и ObjectInputStream.
 * <p>
 * TASK4
 * <p>
 * Посчитать количество файлов в директории и во всех вложенных папках.
 */
public class Main {
    /**
     * TASK 1
     * <p>
     * Записать в бинарный файл несколько разнотипных значений, используя DataOutputStream.
     * <p>
     * Прочитать записанные данные из предыдущего задания, используя DataInputStream.
     * <p>
     * Записать в бинарный файл коллекцию строк (String) и прочитать ее обратно, используя DataOutputStream и DataInputStream.
     * <p>
     * Записать в бинарный файл коллекцию контактов (Contact) и прочитать ее обратно, используя DataOutputStream и DataInputStream.
     */
    public static class Task1 {
        public static void main(String[] args) {
            writeData();
            readData();
        }

        private static void writeData() {
            String path = "src" + File.separator + "files" + File.separator + "pr18" + File.separator + "task1.bin";
            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(path)))) {
                out.writeInt(123);
                out.writeFloat(123.0f);
                out.writeDouble(123.0);
                out.writeLong(123);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void readData() {
            String path = "src" + File.separator + "files" + File.separator + "pr18" + File.separator + "task1.bin";
            try (DataInputStream in = new DataInputStream(new FileInputStream(path))) {
                System.out.println(in.readInt());
                System.out.println(in.readFloat());
                System.out.println(in.readDouble());
                System.out.println(in.readLong());

                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * TASK 2
     * <p>
     * Записать в бинарный файл несколько разнотипных значений, используя DataOutputStream.
     * <p>
     * Прочитать записанные данные из предыдущего задания, используя DataInputStream.
     * <p>
     * Записать в бинарный файл коллекцию строк (String) и прочитать ее обратно, используя DataOutputStream и DataInputStream.
     * <p>
     * Записать в бинарный файл коллекцию контактов (Contact) и прочитать ее обратно, используя DataOutputStream и DataInputStream.
     */
    public static class Task2 {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files" + File.separator + "pr18" + File.separator + "task2.bin";

            List<String> strings = new ArrayList<>();
            strings.add("String 1");
            strings.add("String 2");
            strings.add("String 3");

            List<Contact> contacts = new ArrayList<>();
            contacts.add(new Contact("Den", "Yarovoy", "+38095876430", 2002));
            contacts.add(new Contact("Ilya", "Safronov", "+38050777727", 2002));
            contacts.add(new Contact("Maria", "Kovalevska", "+380984645111", 2000));

            try {
                writeContacts(contacts, path);
                System.out.println(readContacts(path));
                writeStrings(strings, path);
                readStrings(path);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        private static void writeStrings(List<String> strings, String filePath) throws IOException {
            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath))) {
                out.writeInt(strings.size());
                for (String s : strings) {
                    out.writeUTF(s);
                }
            }
        }

        private static void readStrings(String filePath) throws IOException {
            try (DataInputStream in = new DataInputStream(new FileInputStream(filePath))) {
                int size = in.readInt();
                for (int i = 0; i < size; i++) {
                    System.out.println(in.readUTF());
                }
            }
        }

        private static void writeContacts(List<Contact> contacts, String filePath) throws IOException {
            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath))) {
                out.writeInt(contacts.size());
                for (Contact contact : contacts) {
                    out.writeUTF(contact.getName());
                    out.writeUTF(contact.getSurname());
                    out.writeUTF(contact.getNumber());
                    out.writeInt(contact.getYearOfBirth());
                }
            }
        }

        private static List<Contact> readContacts(String filePath) throws IOException {
            List<Contact> contacts = null;
            try (DataInputStream in = new DataInputStream(new FileInputStream(filePath))) {
                contacts = new ArrayList<>();
                int size = in.readInt();
                for (int i = 0; i < size; i++) {
                    contacts.add(new Contact(in.readUTF(), in.readUTF(), in.readUTF(), in.readInt()));
                }
            }
            return contacts;
        }
    }

    /**
     * TASK 3
     * <p>
     * Записать в бинарный файл коллекцию контактов (Contact) и прочитать ее обратно,
     * используя Serializable, ObjectOutputStream
     */
    public static class Task3 {
        public static void main(String[] args) {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Den", 122, false, 4, false));
            students.add(new Student("Ilya", 122, true, 4, true));
            students.add(new Student("Pavel", 123, true, 2, true));
            students.add(new Student("Ihor", 122, false, 1, false));
            students.add(new Student("Maria", 124, false, 4, true));

            String path1 = "src" + File.separator + "files" + File.separator + "pr18" + File.separator + "task3a.bin";
            String path2 = "src" + File.separator + "files" + File.separator + "pr18" + File.separator + "task3b.bin";

            try {
                serializeStudents(students, path1);
                serializeStudentList(students, path2);
                System.out.println(deserializeEachStudentToList(path1));
                System.out.println(deserializeStudentsList(path2));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

        // serialize each student from list
        private static void serializeStudents(List<Student> students, String filePath) throws IOException {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
                out.writeInt(students.size());
                for (Student student : students) {
                    out.writeObject(student);
                }

            }
        }

        // serialize list as object
        private static void serializeStudentList(List<Student> students, String filePath) throws IOException {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
                out.writeObject(students);
            }
        }

        // deserialize each student from students in file
        private static List<Student> deserializeEachStudentToList(String filePath) throws IOException, ClassNotFoundException {
            List<Student> result = new ArrayList<>();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
                int size = in.readInt();
                for (int i = 0; i < size; i++) {
                    result.add((Student) in.readObject());
                }
            }
            return result;
        }

        // deserialize list object
        private static List<Student> deserializeStudentsList(String filePath) throws IOException, ClassNotFoundException {
            List<Student> result;
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
                result = (ArrayList<Student>) in.readObject();
            }
            return result;
        }
    }

    /**
     * TASK4
     * <p>
     * Посчитать количество файлов в директории и во всех вложенных папках.
     */
    public static class Task4 {
        public static void main(String[] args) {
            String path = "src" + File.separator + "files";
            System.out.println(getFilesCount(new File(path)));
        }

        private static int getFilesCount(File file) {
            File[] files = file.listFiles();
            int result = 0;
            for (File f : files) {
                if (f.isDirectory()) {
                    result += getFilesCount(f);
                } else result++;
            }
            return result;
        }
    }

}
