package java_pro_homeworks.pr17;

public class ArrayHandler {

    /**
     * ������ ������� ������ ����
     */
    public static <T> void readArray(T[] array) {
        for (T item : array) {
            System.out.println(item + " ");
        }
    }

    /**
     * ������� ������ ��������� �����
     */
    public static Integer[] getRandomIntegerArray(int from, int to, int count) {
        if (from > to) {
            System.out.println("Range is incorrect. FROM and TO indexes have swapped");
            int temp = from;
            from = to;
            to = temp;
        }
        Integer[] result = new Integer[count];
        for (int i = 0; i < count; i++) {
            result[i] = (int) (Math.random() * (to - from)) + from;
        }
        return result;
    }

    /**
     * ������� ������ ��������� ����� � ���� ������ � �������������� �����������
     * ���� ���� ��������� ������� -> �������� �����������
     */
    public static <T> String getArrayToString(T[] array, String regex) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
            if (array.length - i != 1) result = result + regex;
        }
        return result;
    }

}
