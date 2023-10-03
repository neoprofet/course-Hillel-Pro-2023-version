package java_pro_homeworks.pr1;

public class MaxOfThreeValues {

    public double getResult(double a, double b, double c){
        MaxOfTwoValues maxOfTwoValues = new MaxOfTwoValues();
        double maxPair1 = maxOfTwoValues.getResult(a,b);
        double max = maxOfTwoValues.getResult(maxPair1,c);
        return max;

    }


}
