package java_pro_homeworks.pr1;

public class CenturyRecognizer {
    public int getResult(int year){
int result = (year/100)+1;
if (year%100==0) {result--;}

        return result;
    }
}
