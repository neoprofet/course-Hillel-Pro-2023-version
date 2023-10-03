package java_pro_homeworks.pr17;

public class Contact {
    private String name;
    private String surname;
    private String phone;
    private int yearOfBirth;

    public Contact(String name, String surname, String phone, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
                ", phone='" + phone + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}

