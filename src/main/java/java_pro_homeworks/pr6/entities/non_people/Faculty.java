package java_pro_homeworks.pr6.entities.non_people;

public class Faculty {
    private String name;
    private Department[] departments;

    public Faculty(String name, Department[] departments) {
        this.name = name;
        this.departments = departments;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
