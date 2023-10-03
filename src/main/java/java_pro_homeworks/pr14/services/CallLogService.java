package java_pro_homeworks.pr14.services;

import java_pro_homeworks.pr14.data.CallType;
import java_pro_homeworks.pr14.models.CallLog;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class CallLogService {


    /**
     * ����� ������� �� ������ ��������
     * <p>
     * ��������� � ��������� ��������� �������
     * <p>
     * ���������� ����� ������� (CommonService.findByPredicate),
     * ������� ���������� ��������� ������������ �� ���������
     */
    public Collection<CallLog> getByNumber(List<CallLog> allList, String number) {

        Predicate<CallLog> predicate = new Predicate<CallLog>() {
            @Override
            public boolean test(CallLog callLog) {
                return callLog.getNumber().equals(number);
            }
        };
        return new CommonService().findByPredicate(allList, predicate);
    }

    /**
     * ����� ������� �� ���� (Missed, Ingoing, Outgoing)
     * <p>
     * ��������� � ��������� ��������� �������
     * <p>
     * ���������� ����� ������� (CommonService.findByPredicate),
     * ������� ���������� ��������� ������������ �� ���������
     */
    public Collection<CallLog> getByType(List<CallLog> allList, CallType type) {

        Predicate<CallLog> predicate = new Predicate<CallLog>() {
            @Override
            public boolean test(CallLog callLog) {
                return callLog.getType().equals(type);
            }
        };
        return new CommonService().findByPredicate(allList, predicate);
    }

    /**
     * �������� ���������� ������
     * <p>
     * ��������� ��� � List
     * <p>
     * ��������� � Set ��������� �������
     */

    /*public Set<CallLog> getSetOfUniqueCallLogs(List<CallLog> allList) {
        return new HashSet<>(allList);
    }*/

    /**
     * �������� ���������� ������
     * <p>
     * ��������� ��� � List
     * <p>
     * ��������� � List ��������� �������
     */

    /*public List<CallLog> getListOfUniqueCallLogs(List<CallLog> allList) {
        return new ArrayList<>(getSetOfUniqueCallLogs(allList));
    }*/

    /**
     * ����������� �������� ��� ����������� [��������������������� - ��������]
     * ��������� ��� � List
     * ��������� � Map
     */
   /* public Map<String, CallLog> getMapOfSeparatedCallLogAndItsNumber(List<CallLog> callLogList) {
        Map<String, CallLog> numberAndCallLogMap = new HashMap<>();
        for (CallLog callLog : callLogList) {
            numberAndCallLogMap.put(callLog.getNumber(), callLog);
        }
        return numberAndCallLogMap;
    }*/

    /**
     * ������ ���� ����� ������ ������
     */
    public void showCallLog(CallLog callLog) {
        String info = "CallLog{" +
                "\nNumber: " + callLog.getNumber() +
                "\nStatus: " + callLog.getType() +
                "\nTime: " + callLog.getTime() +
                "\nDate: " + callLog.getDate() + "\n}";
        System.out.println(info);
    }

    /**
     * ������ ����� �������.
     * <p>
     * ������ ���� �����.
     */
    public void showCallLogs(Collection<CallLog> callLogs) {
        for (CallLog callLog : callLogs) {
            showCallLog(callLog);
        }
    }


    /**
     * ������ ����������� ���� [��������������������� - ��������]
     */
    /*public void showCallLogAndItsNumber(Map<String, CallLog> map) {
        for (Map.Entry<String, CallLog> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            showCallLog(entry.getValue());
        }
    }*/
}

