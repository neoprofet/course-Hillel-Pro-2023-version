package java_pro_homeworks.pr18;

public class Contact {

    private String name;
    private String surname;
    private String number;
    private int yearOfBirth;

    public Contact(String name, String surname, String number, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
