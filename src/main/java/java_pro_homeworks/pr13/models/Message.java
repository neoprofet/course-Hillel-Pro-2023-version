package java_pro_homeworks.pr13.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
