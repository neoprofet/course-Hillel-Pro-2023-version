package java_pro_homeworks.pr10.handlers;

public class RandomFromArray {

    public static String getRandomStringFromArray(String[] array){

        int randomIndex = (int) (Math.random() * array.length);
        return array[randomIndex];
    }
}
