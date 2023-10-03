package pr31;

import java_pro_homeworks.pr31.Calculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public static void sumTest(){
        assertEquals(Calculator.sumOf(2.0, 3.0), 5.0);
        assertEquals(Calculator.sumOf(-2.0, 3.0), 1.0);
        assertEquals(Calculator.sumOf(1.0, 1.5), 2.5);
        assertEquals(Calculator.sumOf(-4.0, -3.0), -7.0);
    }

    @Test
    public static void subtractionTest(){
        assertEquals(Calculator.subtractionOf(7.0, 2.0), 5.0);
        assertEquals(Calculator.subtractionOf(2.0, 3.0), -1.0);
        assertEquals(Calculator.subtractionOf(4.0, 1.5), 2.5);
        assertEquals(Calculator.subtractionOf(-4.0, 3.0), -7.0);
    }

    @Test
    public static void multiplicationTest(){
        assertEquals(Calculator.multiplicationOf(7.0, 2.0), 14.0);
        assertEquals(Calculator.multiplicationOf(2.0, 3.0), 6.0);
        assertEquals(Calculator.multiplicationOf(4.0, 1.5), 6.0);
        assertEquals(Calculator.multiplicationOf(-4.0, 3.0), -12.0);
        assertEquals(Calculator.multiplicationOf(4.6, 3.2), 14.72, 14.72/(10^6));
    }

    @Test
    public static void divisionTest(){
        assertEquals(Calculator.divisionOf(7.0, 2.0), 3.5, 3.5/(10^6));
        assertEquals(Calculator.divisionOf(3.0, 3.0), 1);
        assertEquals(Calculator.divisionOf(2, 4), 0.5, 0.5/(10^6));
    }

    @Test
    public static void powerTest(){
        assertEquals(Calculator.powerOfNumberToDegree(2.0, 1), 2.0);
        assertEquals(Calculator.powerOfNumberToDegree(2.0, 2), 4.0);
        assertEquals(Calculator.powerOfNumberToDegree(2.0, 3), 8.0);
        assertEquals(Calculator.powerOfNumberToDegree(2.0, 4), 16.0);
        assertEquals(Calculator.powerOfNumberToDegree(2.0, 5), 32.0);
        assertEquals(Calculator.powerOfNumberToDegree(2.0, 9), 512.0);
        assertEquals(Calculator.powerOfNumberToDegree(2.0, 10), 1024.0);

    }

    @Test
    public static void by3Test(){
        assertEquals(true, Calculator.byThreeOrNotBy(9));
        assertEquals(true, Calculator.byThreeOrNotBy(12));
        assertEquals(false, Calculator.byThreeOrNotBy(14));
        assertEquals(false, Calculator.byThreeOrNotBy(1));
    }
}
