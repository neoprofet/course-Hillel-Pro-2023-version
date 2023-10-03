package java_pro_homeworks.pr3;

import java.util.Random;

public class StudentFactory {
    private int maxCourse;
    private String[] names;

    public StudentFactory(int maxCourse, String[] names) {
        this.maxCourse = maxCourse;
        this.names = names;
    }

    /*Создать одного случайного студента*/
    public Student create() {
        int randomNameIndex = (int) Math.floor(Math.random() * names.length);
        String name = names[randomNameIndex];
        int age = (int) ((Math.random() * (50 - 16)) + 16);
        int course = (int) ((Math.random() * (maxCourse + 1 - 1)) + 1);
        boolean isBudget = new Random().nextBoolean();

        return new Student(name, age, course, isBudget);
    }

    /*Создать массив случайных студентов*/
    public Student[] createArray(int size) {
        Student[] array = new Student[size];
        for (int i = 0; i < size; i++) {
            array[i] = create();
        }
        return array;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public int getMaxCourse() {
        return maxCourse;
    }

    public void setMaxCourse(int maxCourse) {
        this.maxCourse = maxCourse;
    }
}
