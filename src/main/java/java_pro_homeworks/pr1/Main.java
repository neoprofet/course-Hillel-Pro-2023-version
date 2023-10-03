package java_pro_homeworks.pr1;

public class Main {
    public static void main(String[] args) {
    Main main = new Main();
    main.task4();

    }

    private void task1(){
        double a = 1;
        double b = 2;
        double c = 2;

        MaxOfThreeValues maxOfThreeValues = new MaxOfThreeValues();
        double max = maxOfThreeValues.getResult(a,b,c);
        System.out.println(max);
    }

    private void task2(){
        CenturyRecognizer centuryRecognizer = new CenturyRecognizer();
        System.out.println(centuryRecognizer.getResult(2020));
    }

    private void task3(){
        LeapYearRecognizer leapYearRecognizer = new LeapYearRecognizer();
        System.out.println(leapYearRecognizer.getResult(2005));
    }

    private void task4(){
        ArrayTools arrayTools = new ArrayTools();
        arrayTools.fillArrayWithRandomInRangeOf(2,11);
        arrayTools.show();
    }
}
