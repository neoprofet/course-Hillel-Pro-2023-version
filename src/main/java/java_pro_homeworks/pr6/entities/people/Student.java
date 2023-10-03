package java_pro_homeworks.pr6.entities.people;

public class Student {

    private String name;
    private int age;
    private int course;
    private boolean isBudgetaryBasis;

    public Student(String name, int age, int course, boolean isBudgetaryBasis) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.isBudgetaryBasis = isBudgetaryBasis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isBudgetaryBasis() {
        return isBudgetaryBasis;
    }

    public void setBudgetaryBasis(boolean budgetaryBasis) {
        isBudgetaryBasis = budgetaryBasis;
    }

}
