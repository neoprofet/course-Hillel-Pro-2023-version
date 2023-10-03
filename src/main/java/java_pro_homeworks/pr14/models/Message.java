package java_pro_homeworks.pr14.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private String number;
    private String text;
    private LocalDateTime time;
    private LocalDate date;

    public Message(String number, String text, LocalDateTime time, LocalDate date) {
        this.number = number;
        this.text = text;
        this.time = time;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(number, message.number) && Objects.equals(text, message.text) && Objects.equals(time, message.time) && Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, text, time, date);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
}
