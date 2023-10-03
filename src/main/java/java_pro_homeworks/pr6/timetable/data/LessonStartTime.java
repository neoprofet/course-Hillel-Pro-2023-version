package java_pro_homeworks.pr6.timetable.data;

public enum LessonStartTime {
    FIRST_LESSON("8:30"), SECOND_LESSON("10:10"), THIRD_LESSON("12:00"),
    FOURTH_LESSON("13:40"), FIFTH_LESSON("15:20"), SIXTH_LESSON("17:00");

    public final String time;

    LessonStartTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
