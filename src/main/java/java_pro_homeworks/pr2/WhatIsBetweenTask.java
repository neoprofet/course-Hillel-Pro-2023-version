package java_pro_homeworks.pr2;

public class WhatIsBetweenTask {
    public int[] getResult(int a, int b){
        if (a>b) throw new ArithmeticException();
        else {
            int[] result = new int[b-a+1];
            for (int i = a, j = 0; j< result.length; i++,j++ ){
                result[j] = i;
            }
         return result;
        }
    }
}
