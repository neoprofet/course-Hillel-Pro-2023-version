package java_pro_homeworks.pr2;

public class ArrayFormatTask {
    double[] array;

    private void fillArrayWithRandom(int count) {
        //( Math.random() * (b-a) ) + a
        array = new double[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Math.random() * (1000 - 1)) + 1;
        }
    }

    public void getResult(int length) {
        fillArrayWithRandom(length);
        if (array.length == 0) {
            System.out.println("Array is empty");
        } else {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%.2f ", array[i]);
            }
        }
    }
}
