package java_pro_homeworks.pr8.overriding_demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human(1,"Den", 22);
        Human human2 = new Human(1,"Den", 50);
        Human human3 = new Human(2,"Nick", 21);
        Human human4 = new Human(1,"Den", 22);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);

        System.out.println("human1 hashcode: " + human1.hashCode());
        System.out.println("human2 hashcode: " + human2.hashCode());
        System.out.println("human3 hashcode: " + human3.hashCode());
        System.out.println("human4 hashcode: " + human4.hashCode());

        System.out.println("human1 == human1: " + (human1 == human1));
        System.out.println("human1 == human2: " + (human1 == human2));
        System.out.println("human1 == human3: " + (human1 == human3));
        System.out.println("human1 == human4: " + (human1 == human4));

        System.out.println("human1 equals human1: " + (human1.equals(human1)));
        System.out.println("human1 equals human2: " + (human1.equals(human2)));
        System.out.println("human1 equals human3: " + (human1.equals(human3)));
        System.out.println("human1 equals human4: " + (human1.equals(human4)));

        System.out.println("=============");
        List<Human> all = new ArrayList<>();
        all.add(human1);
        all.add(human2);
        all.add(human3);
        all.add(human4);

        Set<Human> distinct = new HashSet<>();
        distinct.addAll(all);

        System.out.println(all.toString());
        System.out.println(distinct.toString());
    }
}
