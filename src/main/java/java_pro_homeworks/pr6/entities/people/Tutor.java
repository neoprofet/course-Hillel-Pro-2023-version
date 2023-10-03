package java_pro_homeworks.pr6.entities.people;

import java_pro_homeworks.pr6.timetable.data.Subject;

public class Tutor {

    private String name;
    private Subject[] subjects;

    public Tutor(String name, Subject[] subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
}
