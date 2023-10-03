package java_pro_homeworks.pr6;

import java_pro_homeworks.pr6.entities.non_people.Audience;
import java_pro_homeworks.pr6.entities.non_people.Department;
import java_pro_homeworks.pr6.entities.non_people.Faculty;
import java_pro_homeworks.pr6.entities.non_people.Group;
import java_pro_homeworks.pr6.entities.people.Student;
import java_pro_homeworks.pr6.entities.people.Tutor;
import java_pro_homeworks.pr6.timetable.Timetable;
import java_pro_homeworks.pr6.timetable.TimetablePrinter;
import java_pro_homeworks.pr6.timetable.data.Day;
import java_pro_homeworks.pr6.timetable.data.LessonStartTime;
import java_pro_homeworks.pr6.timetable.data.Subject;


public class Main {
    TimetablePrinter timetablePrinter;
    Timetable[] timetables;
    Faculty[] faculties;

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    {
        timetablePrinter = new TimetablePrinter();

        //тестовая инициализация студентов
        Student[] students1 = {
                new Student("Den", 20, 4, true),
                new Student("Pavel", 20, 4, false),
                new Student("Ihor", 21, 4, false),
        };
        Student[] students2 = {
                new Student("Ann", 21, 4, true),
                new Student("Ilya", 21, 4, false)
        };

        //тестовая инициализация групп
        Group[] groups = {
                new Group("CS42", students1),
                new Group("PL44", students2),
        };

        //тестовая инициализация преподавателей
        Tutor[] tutors = {
              new Tutor("TKACHUK NIKOLAY", new Subject[]{Subject.ERGONOMICS, Subject.ENGLISH}),
                new Tutor("BOGUCHAR SERGEY", new Subject[]{Subject.PARALLEL_COMPUTING}),
                new Tutor("SPOROV SERGEY", new Subject[]{Subject.OOP, Subject.DATA_BASES}),
                new Tutor("SVETLANA SHAUTDINOVA",new Subject[]{Subject.LITERATURE}),
                new Tutor("DEBCALUK LILY", new Subject[]{Subject.MUSIC}),
                new Tutor("BONDARENKO TANYA", new Subject[]{Subject.MATH}),
                new Tutor("MIRONOVA VALENTINA", new Subject[]{Subject.FRENCH}),
                new Tutor("DESNOV VITALIY", new Subject[]{Subject.PAINTING, Subject.DESIGN}),
        };

        //тестовая инициализация аудиторий
        Audience[] audiences = {
                new Audience("24A", 2),
                new Audience("14B", 1),
                new Audience("33", 3)
        };

        //тестовая инициализация кафедр
        Department[] departments = {
                new Department("MSIT", audiences, tutors)
        };

        //тестовая инициализация факультетов
        faculties = new Faculty[]{
                new Faculty("FKN",departments)
        };
        //тестовая инициализация расписания
        timetables = new Timetable[]{
                new Timetable(groups[0],tutors[0], Day.MONDAY, LessonStartTime.FIRST_LESSON,Subject.ENGLISH),
                new Timetable(groups[1],tutors[2], Day.TUESDAY, LessonStartTime.SECOND_LESSON,Subject.OOP),
                new Timetable(groups[1],tutors[7], Day.WEDNESDAY, LessonStartTime.FIFTH_LESSON,Subject.DESIGN),
                new Timetable(groups[0],tutors[3], Day.THURSDAY, LessonStartTime.SECOND_LESSON,Subject.LITERATURE),

        };
    }

    public void start() {
        timetablePrinter.printTimetables(timetables);
    }
}

