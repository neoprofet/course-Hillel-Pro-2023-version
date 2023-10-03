package java_pro_homeworks.pr2;

public class MultiplicationTable {
    public void getResult(int number){
        if(number<=10&&number>=0){
            for (int i = 1; i < 11; i++) {
                System.out.println(number+" * "+ i+ " = "+ number*i);
            }
        }else {
            System.err.println("Number is not valid");
        }
    }
}
