package java_pro_homeworks.pr19;

import com.google.gson.Gson;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.map.LinkedMap;

import java.util.List;

/**
 * REMARK
 * <p>
 * ������� ������, ��������� Maven ��� ������� ������
 * <p>
 * TASK 1
 * <p>
 * ���������� ���������� �org.apache.commons:commons-collections4� � ������.
 * ������������ 2-3 ������ �� ���� ����������, ��������, BidiMap.
 * <p>
 * TASK 2
 * <p>
 * ���������� ���������� �com.google.code.gson:gson� � ������.
 * ������������ ��� ��� �������������� ����������� CallLog � JSON � �������.
 * <p>
 * TASK 3
 * <p>
 * ������� JAR ����� � ������������������ ��� ���������� �� ��������� ������.
 * <p>
 * ����������� ����� �������� ���������� CallLog �� ���������� �������.
 * <p>
 * ������� Collection<CallLog> � ��������� �� ���������� ������������ �� ������������� �������,
 * ����������� � �������� ������������� ��������� ��������� ������.
 * <p>
 * ���������� ���������� ���������� � ������� �������� �� ���������.
 * <p>
 * ��������� gson, ������������� ��������� Collection<CallLog> � JSON � �������.
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * TASK 1
     * <p>
     * ���������� ���������� �org.apache.commons:commons-collections4� � ������.
     * ������������ 2-3 ������ �� ���� ����������, ��������, BidiMap.
     */
    public static class Task1 {
        public static void main(String[] args) {

            //BIDIRECTIONAL MAP. ���� �������� �� �������� � ��������. ����� �������� �������.
            System.out.println("=======BIDI MAP=======");
            BidiMap<String, String> bidiMap = new DualHashBidiMap<>();
            bidiMap.put("Denis", "+380954056300");
            bidiMap.put("Luda", "+380501852428");

            System.out.println(bidiMap.get("Denis"));
            System.out.println(bidiMap.getKey("+380954056300"));

            bidiMap = bidiMap.inverseBidiMap();

            System.out.println(bidiMap.get("+380954056300"));
            System.out.println(bidiMap.getKey("Denis"));

            // ORDERED MAP. ����� ����������� � ���������� ����� ���� ������.

            System.out.println("=======ORDERED MAP=======");
            OrderedMap<String, String> orderedMap = new LinkedMap<>();
            orderedMap.put("Denis", "+380954056300");
            orderedMap.put("Luda", "+380501852428");

            System.out.println(orderedMap.nextKey("Denis"));
            System.out.println(orderedMap.firstKey());

            // BAG. ������ ������� � ��� �����
            System.out.println("=======BAG=======");
            Bag bag = new HashBag();
            bag.add("Diploma", 22);
            bag.remove("Diploma", 2);
            System.out.println(bag.getCount("Diploma"));
        }
    }

    /**
     * TASK 2
     * <p>
     * ���������� ���������� �com.google.code.gson:gson� � ������.
     * ������������ ��� ��� �������������� ����������� CallLog � JSON � �������.
     */
    public static class Task2 {
        public static void main(String[] args) {
            CallLog callLog1 = new CallLog("Den", "+380954056300");

            Gson gson = new Gson();
            String callLogJson1 = gson.toJson(callLog1);
            CallLog callLogFromGson = gson.fromJson(callLogJson1, CallLog.class);
            System.out.println(callLogJson1);
            System.out.println(callLogFromGson.toString());
        }
    }

    /**
     * TASK 3
     * ������� JAR ����� � ������������������ ��� ���������� �� ��������� ������.
     *  <p>
     *  ����������� ����� �������� ���������� CallLog �� ���������� �������.
     *  <p>
     *  ������� Collection<CallLog> � ��������� �� ���������� ������������ �� ������������� �������,
     *  ����������� � �������� ������������� ��������� ��������� ������.
     *  <p>
     *  ���������� ���������� ���������� � ������� �������� �� ���������.
     *  <p>
     *  ��������� gson, ������������� ��������� Collection<CallLog> � JSON � �������.
     */

    public static class Task3 {
        public static void main(String[] args) {
            CallLogFabric callLogFabric = new CallLogFabric(new CallLogData().getNames());
            if (args.length == 1) {
                try {
                    List<CallLog> list = callLogFabric.getRandomCallLogs(Integer.parseInt(args[0]));
                    for (CallLog callLog : list) {
                        System.out.println(callLog);
                    }
                } catch (Exception e) {
                    System.out.println("Integer argument required");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Arguments count is incorrect. One integer argument required. Used default value (size = 1)");
                List<CallLog> list = callLogFabric.getRandomCallLogs(1);
                for (CallLog callLog : list) {
                    System.out.println(callLog);
                }
            }
        }


    }

}
