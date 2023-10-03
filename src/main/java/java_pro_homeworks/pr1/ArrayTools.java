package java_pro_homeworks.pr1;

public class ArrayTools {
int[] array;

 public void fillArrayWithRandomInRangeOf(int a, int b) {
     if (a > b) {System.err.println("Введен недопустимый диапазон");}
     else {
         int[] array = new int[b - a + 1];
         for (int j = 0, i = a; j < array.length; j++, i++) {
             array[j] = i;
         }
         this.array = array;
     }
 }

 public void show(){
     for (Integer i: array) {
         System.out.print(i+" ");
     }
 }
}
