package java_pro_homeworks.pr16;

public class Student {
    private int age;
    private String name;
    private int speciality;
    private int course;
    private boolean isBudget;

    public Student(int age, String name, int speciality, int course, boolean isBudget) {
        setAge(age);
        setName(name);
        this.speciality = speciality;
        this.course = course;
        this.isBudget = isBudget;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", speciality=" + speciality +
                ", course=" + course +
                ", isBudget=" + isBudget +
                '}';
    }

    public void setAge(int age) {
        if (age<0|| age>100) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null|| name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
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
}
