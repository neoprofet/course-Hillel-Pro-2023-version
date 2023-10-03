package java_pro_homeworks.pr9.models;

public class Student {
    private int age;
    private String name;
    private int course;
    private boolean isBudget;
    private int specialityCode;

    public Student(int age, String name, int course, boolean isBudget, int specialityCode) {
        this.age = age;
        this.name = name;
        this.course = course;
        this.isBudget = isBudget;
        this.specialityCode = specialityCode;
    }

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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isBudget() {
        return isBudget;
    }

    public void setBudget(boolean budget) {
        isBudget = budget;
    }

    public int getSpecialityCode() {
        return specialityCode;
    }

    public void setSpecialityCode(int specialityCode) {
        this.specialityCode = specialityCode;
    }
}
