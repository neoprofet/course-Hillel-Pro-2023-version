package java_pro_homeworks.pr8.overriding_demo;


import java.util.Objects;

public class Human {
    private int id;
    private String name;
    private int age;


    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Human{Id: "+ id + ", name: " + name + ", age: "+ age +"}";
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name,age);
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Human)){
            return false;
        }

        Human other = (Human) o;
        return Objects.equals(this.id,other.id)&&
                Objects.equals(this.name, other.name)&&
                Objects.equals(this.age, other.age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
