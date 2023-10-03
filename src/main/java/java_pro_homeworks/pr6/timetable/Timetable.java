package java_pro_homeworks.pr6.timetable;

import java_pro_homeworks.pr6.timetable.data.Day;
import java_pro_homeworks.pr6.timetable.data.LessonStartTime;
import java_pro_homeworks.pr6.entities.non_people.Group;
import java_pro_homeworks.pr6.entities.people.Tutor;
import java_pro_homeworks.pr6.timetable.data.Subject;

public class Timetable {
    private Group group;
    private Tutor tutor;
    private Day day;
    private LessonStartTime lessonStartTime;
    private Subject subject;

    public Timetable(Group group, Tutor tutor, Day day, LessonStartTime lessonStartTime, Subject subject) {
        this.group = group;
        this.tutor = tutor;
        this.day = day;
        this.lessonStartTime = lessonStartTime;
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LessonStartTime getLessonStartTime() {
        return lessonStartTime;
    }

    public void setLessonStartTime(LessonStartTime lessonStartTime) {
        this.lessonStartTime = lessonStartTime;
    }
}
