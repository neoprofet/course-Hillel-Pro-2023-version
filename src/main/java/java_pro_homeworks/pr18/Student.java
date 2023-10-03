package java_pro_homeworks.pr18;

import java.io.Serializable;


public class Student implements Serializable {
    private String name;
    private int speciality;
    private boolean isFeePaying;
    private int course;
    private transient boolean isHasPhoto;

    public Student(String name, int speciality, boolean isFeePaying, int course, boolean isHasPhoto) {
        this.name = name;
        this.speciality = speciality;
        this.isFeePaying = isFeePaying;
        this.course = course;
        this.isHasPhoto = isHasPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    public boolean isFeePaying() {
        return isFeePaying;
    }

    public void setFeePaying(boolean feePaying) {
        isFeePaying = feePaying;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public boolean isHasPhoto() {
        return isHasPhoto;
    }

    public void setHasPhoto(boolean hasPhoto) {
        isHasPhoto = hasPhoto;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", speciality=" + speciality +
                ", isFeePaying=" + isFeePaying +
                ", course=" + course +
                ", isHasPhoto=" + isHasPhoto +
                '}';
    }
}
