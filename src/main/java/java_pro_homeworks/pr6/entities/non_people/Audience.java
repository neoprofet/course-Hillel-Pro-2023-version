package java_pro_homeworks.pr6.entities.non_people;

public class Audience {
    private String name;
    private int floor;

    public Audience(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

