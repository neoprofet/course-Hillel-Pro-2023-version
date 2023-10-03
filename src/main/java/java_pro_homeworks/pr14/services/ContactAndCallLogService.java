package java_pro_homeworks.pr14.services;

import java_pro_homeworks.pr14.models.CallLog;
import java_pro_homeworks.pr14.models.Contact;
import java_pro_homeworks.pr14.structures.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ContactAndCallLogService {

    /**
     * Получить звонки по контакту
     */
    public List<CallLog> getAllCallLogsByContact(Contact contact, List<CallLog> callLogList) {
        List<CallLog> result = new ArrayList<>();

        for (CallLog callLog : callLogList) {
            if (contact.getNumber().equals(callLog.getNumber())) {
                result.add(callLog);
            }
        }
        return result;
    }

    /**
     * Получить Количество звонков по контакту
     */
    public int getCallLogsNumberByContact(Contact contact, List<CallLog> callLogList) {
        return getAllCallLogsByContact(contact, callLogList).size();
    }

    /**
     * Получить Пару типа [Контакт – Количество звонков по контакту]
     */
    public Pair<Contact, Integer> getPairOfContactAndItsCallLogsNumber(Contact contact, List<CallLog> callLogList) {
        return new Pair<Contact, Integer>(contact, getCallLogsNumberByContact(contact, callLogList));
    }

    /**
     * Получить Коллекцию Пар типа [Контакт – Количество звонков по контакту]
     */
    public Collection<Pair<Contact, Integer>> getPairsCollectionOfContactAndItsCallLogsNumber
    (Collection<Contact> contacts, List<CallLog> callLogList) {

        Collection<Pair<Contact, Integer>> pairs = new ArrayList<>();
        for (Contact contact : contacts) {
            pairs.add(getPairOfContactAndItsCallLogsNumber(contact, callLogList));
        }
        return pairs;
    }

    /**
     * Получить сортированную Коллекцию Пар типа [Контакт – Количество звонков по контакту]
     * <p>
     * Сортировать по количеству звонков
     * <p>
     * Убывающая сортировка
     */
    public Collection<Pair<Contact, Integer>> getPairsCollectionOfContactAndItsCallLogsNumberSortedByDesc
    (Collection<Contact> contacts, List<CallLog> callLogList) {

        Collection<Pair<Contact, Integer>> pairs =
                getPairsCollectionOfContactAndItsCallLogsNumber(contacts, callLogList);

        return pairs.stream()
                .sorted((o1, o2) -> o2.getSecond() - o1.getSecond())
                .collect(Collectors.toCollection(ArrayList<Pair<Contact, Integer>>::new));
    }

    /**
     * Печать отображения вида [Контакт - Количество Звонков]
     */

    public void showPairsCollectionOfContactAndItsCallLogsNumber(Collection<Pair<Contact, Integer>> pairs) {
        ContactService contactService = new ContactService();
        for (Pair<Contact, Integer> pair : pairs) {
            contactService.showContact(pair.getFirst());
            System.out.println("It's callLogs number: " + pair.getSecond());
        }
    }

    /**
     * Печать отображения вида [Контакт - Количество Звонков]
     * <p>
     * Перегруженный метод с аргументом для ограничения елементов вывода
     */
    public void showPairsCollectionOfContactAndItsCallLogsNumber(Collection<Pair<Contact, Integer>> pairs, int limit) {
        ContactService contactService = new ContactService();
        int step = 0;
        for (Pair<Contact, Integer> pair : pairs) {
            if (step >= limit) {
                break;
            }
            contactService.showContact(pair.getFirst());
            System.out.println("It's callLogs number: " + pair.getSecond());
            step++;
        }
    }

    /**
     * Получить отображение вида [Контакт - Лист Звонков]
     */
    /*public Map<Contact, List<CallLog>> getContactAndItsCallLogsMap(List<Contact> contactList,
                                                                   List<CallLog> callLogList) {
        Map<Contact, List<CallLog>> result = new HashMap<>();

        for (Contact contact : contactList) {
            List<CallLog> callLogsOfThisContact = getAllCallLogsByContact(contact, callLogList);
            result.put(contact, callLogsOfThisContact);
        }
        return result;
    }*/

    /**
     * Печать отображения вида [Контакт - Лист Звонков]
     */
    /*public void showContactAndItsCallLogs(Map<Contact, List<CallLog>> map){
        ContactService contactService = new ContactService();
        CallLogService callLogService = new CallLogService();
        for (Map.Entry<Contact, List<CallLog>> entry : map.entrySet()) {

            contactService.showContact(entry.getKey());
            System.out.println("It's callLogs list: ");
            callLogService.showCallLogs(entry.getValue());
            System.out.println("********************************************************");
        }
    }*/
}
