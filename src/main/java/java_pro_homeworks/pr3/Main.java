package java_pro_homeworks.pr3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        StudentHandler studentHandler = new StudentHandler();
        StudentFactory factory = new StudentFactory(4, new StudentData().getNames());
        Student[] students = factory.createArray(10);

        studentHandler.showStudentsInfo(studentHandler.getSortedStudentsByName(students));
    }

    /*задание с КР
     * Пройти в обратном порядке массив
     * с использованием цикла while
     * */
    private void reverseCycleExample() {
        int[] array = new int[]{0, 1, 2, 3, 4};
        int i = array.length - 1;
        while (true) {
            System.out.println(array[i]);
            i--;
            if (i == -1) {
                break;
            }
        }
    }
}
