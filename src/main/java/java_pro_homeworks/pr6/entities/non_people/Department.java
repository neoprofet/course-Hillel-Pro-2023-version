package java_pro_homeworks.pr6.entities.non_people;

import java_pro_homeworks.pr6.entities.people.Tutor;

public class Department {
    private String name;
    private Audience[] audiences;
    private Tutor[] tutors;

    public Department(String name, Audience[] audiences, Tutor[] tutors) {
        this.name = name;
        this.audiences = audiences;
        this.tutors = tutors;
    }

    public Audience[] getAudiences() {
        return audiences;
    }

    public void setAudiences(Audience[] audiences) {
        this.audiences = audiences;
    }

    public Tutor[] getTutors() {
        return tutors;
    }

    public void setTutors(Tutor[] tutors) {
        this.tutors = tutors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
