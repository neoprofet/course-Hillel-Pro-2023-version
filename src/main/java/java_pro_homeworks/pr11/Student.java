package java_pro_homeworks.pr11;

import java.util.Comparator;
import java.util.Objects;

public class Student {
    private String name;
    private int course;
    private int age;
    private boolean isFeePaying;
    private int speciality;

    public Student(String name, int course, int age, boolean isFeePaying, int speciality) {
        this.name = name;
        this.course = course;
        this.age = age;
        this.isFeePaying = isFeePaying;
        this.speciality = speciality;
    }

    public static Comparator<Student> getStudentComparatorByName() {
        return new StudentComparatorByName();
    }

    public static Comparator<Student> getStudentComparatorByAge() {
        return new StudentComparatorByAge();
    }

    public static Comparator<Student> getStudentComparatorByNameAndAge() {
        return new StudentComparatorByNameAndAge();
    }

    private static class StudentComparatorByName implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.name.equals(o2.name)) return 0;
            else if (o1.name.compareTo(o2.name) > 0) return 1;
            else return -1;
        }
    }

    private static class StudentComparatorByAge implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age == o2.age) return 0;
            else if (o1.age > o2.age) return 1;
            else return -1;
        }
    }

    private static class StudentComparatorByNameAndAge implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.name.equals(o2.name)) return (o1.age - o2.age);
            else if (o1.name.compareTo(o2.name) > 0) return 1;
            else return -1;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", age=" + age +
                ", isFeePaying=" + isFeePaying +
                ", speciality=" + speciality +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFeePaying() {
        return isFeePaying;
    }

    public void setFeePaying(boolean feePaying) {
        isFeePaying = feePaying;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && age == student.age &&
                isFeePaying == student.isFeePaying &&
                speciality == student.speciality &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course, age, isFeePaying, speciality);
    }
}
