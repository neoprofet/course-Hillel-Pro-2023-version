package java_pro_homeworks.pr6.timetable;

public class TimetablePrinter {
    public void printTimetables(Timetable[] timetables) {
        System.out.printf("%2s %30s %22s %22s %22s", "GROUP", "TUTOR", "DAY", "SUBJECT", "TIME\n");
        for (Timetable timetable : timetables) {
            System.out.printf("%2s %30s %22s %22s %22s", timetable.getGroup().getName(),
                    timetable.getTutor().getName(),
                    timetable.getDay(), timetable.getSubject().toString(), timetable.getLessonStartTime().getTime() + "\n");

        }
    }

}
