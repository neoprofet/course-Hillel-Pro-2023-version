package java_pro_homeworks.pr2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.task4();
    }
    private void task1(){
        WhatIsBetweenTask whatIsBetweenTask = new WhatIsBetweenTask();
        System.out.println(Arrays.toString(whatIsBetweenTask.getResult(12, 19)));
    }

    private void task2(){
        ArrayFormatTask arrayFormatTask = new ArrayFormatTask();
        arrayFormatTask.getResult(10);
    }

    private void task3(){
      ExpressionMatter expressionMatter = new ExpressionMatter();
        System.out.println(expressionMatter.getResult(5, 6, 2));
    }
    private void task4(){
     MultiplicationTable multiplicationTable = new MultiplicationTable();
     multiplicationTable.getResult(5);

    }
}
