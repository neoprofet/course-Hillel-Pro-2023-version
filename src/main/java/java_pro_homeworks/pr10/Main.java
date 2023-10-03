package java_pro_homeworks.pr10;

import java_pro_homeworks.pr10.observers.Father;
import java_pro_homeworks.pr10.observers.Neighbour;



public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.setObserver(new IHumanObserver[]{
                new Father(), new Neighbour()
        });
human.runAllLifecycles();

    }
}
