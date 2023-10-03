package java_pro_homeworks.pr14.services;

import java_pro_homeworks.pr14.data.CallType;
import java_pro_homeworks.pr14.models.CallLog;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class CallLogService {


    /**
     * Поиск звонков по номеру телефона
     * <p>
     * Результат – Коллекция найденных звонков
     * <p>
     * Использует общую функцию (CommonService.findByPredicate),
     * которая возвращает найденную субколлекцию по предикату
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
     * Поиск звонков по типу (Missed, Ingoing, Outgoing)
     * <p>
     * Результат – Коллекция найденных звонков
     * <p>
     * Использует общую функцию (CommonService.findByPredicate),
     * которая возвращает найденную субколлекцию по предикату
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
     * Получить уникальные звонки
     * <p>
     * Исходящий тип – List
     * <p>
     * Результат – Set найденных звонков
     */

    /*public Set<CallLog> getSetOfUniqueCallLogs(List<CallLog> allList) {
        return new HashSet<>(allList);
    }*/

    /**
     * Получить уникальные звонки
     * <p>
     * Исходящий тип – List
     * <p>
     * Результат – List найденных звонков
     */

    /*public List<CallLog> getListOfUniqueCallLogs(List<CallLog> allList) {
        return new ArrayList<>(getSetOfUniqueCallLogs(allList));
    }*/

    /**
     * Представить Сущность как отображение [НомерТелефонаСущности - Сущность]
     * Исходящий тип – List
     * Результат – Map
     */
   /* public Map<String, CallLog> getMapOfSeparatedCallLogAndItsNumber(List<CallLog> callLogList) {
        Map<String, CallLog> numberAndCallLogMap = new HashMap<>();
        for (CallLog callLog : callLogList) {
            numberAndCallLogMap.put(callLog.getNumber(), callLog);
        }
        return numberAndCallLogMap;
    }*/

    /**
     * Печать всех полей одного звонка
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
     * Печать Листа Звонков.
     * <p>
     * Печать всех полей.
     */
    public void showCallLogs(Collection<CallLog> callLogs) {
        for (CallLog callLog : callLogs) {
            showCallLog(callLog);
        }
    }


    /**
     * Печать отображения вида [НомерТелефонаСущности - Сущность]
     */
    /*public void showCallLogAndItsNumber(Map<String, CallLog> map) {
        for (Map.Entry<String, CallLog> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            showCallLog(entry.getValue());
        }
    }*/
}

