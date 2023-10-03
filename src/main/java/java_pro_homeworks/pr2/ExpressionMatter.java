package java_pro_homeworks.pr2;

public class ExpressionMatter {

    public double getResult(int a, int b, int c){
        double var1 = a+b+c;
        double var2 = a*b*c;
        double var3 = a+b*c;
        double var4 = a*b+c;
        double var5 = (a+b)*c;
        double var6 = a*(b+c);
        double var7 = a*c+b;
        double var8 = b*(a+c);

        double max1 = Math.max(var1,var2);
        double max2 = Math.max(var3,var4);
        double max3 = Math.max(var5,var6);
        double max4 = Math.max(var7,var8);

        double max11 = Math.max(max1,max2);
        double max12 = Math.max(max3,max4);

       return Math.max(max11,max12);

    }
}
