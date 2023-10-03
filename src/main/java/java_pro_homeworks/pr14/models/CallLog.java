package java_pro_homeworks.pr14.models;

import java_pro_homeworks.pr14.data.CallType;
import java_pro_homeworks.pr14.exceptions.UnreachableCallDurationException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CallLog {
    private String number;
    private LocalDateTime time;
    private LocalDate date;
    private CallType type;
    private int duration = 0; // seconds

    public CallLog(String number, LocalDateTime time, LocalDate date, CallType type) {
        this.number = number;
        this.time = time;
        this.date = date;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallLog callLog = (CallLog) o;
        return duration == callLog.duration && Objects.equals(number, callLog.number) && Objects.equals(time, callLog.time) && Objects.equals(date, callLog.date) && type == callLog.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, time, date, type, duration);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CallType getType() {
        return type;
    }

    public void setType(CallType type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws UnreachableCallDurationException {
        if (!type.equals(CallType.MISSED)) {
            this.duration = duration;
        }
        else throw new UnreachableCallDurationException("Missed calls cannot have duration. " +
                "It equals 0 seconds");
    }
}
