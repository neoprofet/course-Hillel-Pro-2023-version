package pr31;

import java_pro_homeworks.pr31.ArraySorter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArraySorterTest {
    @Test
    public void testArrayBubbleSorting(){
        int[] array = {-2, 5, -4, 0, 6, 10};
        int[] expected = {-4, -2, 0, 5, 6, 10};
        assertEquals(expected, ArraySorter.arrayBubbleSorter(array));
    }

    @Test
    public void testArrayInsertionSorting(){
        int[] array = {-2, 5, -4, 0, 6, 10};
        int[] expected = {-4, -2, 0, 5, 6, 10};
        assertEquals(expected, ArraySorter.arrayInsertionSort(array));
    }
}
