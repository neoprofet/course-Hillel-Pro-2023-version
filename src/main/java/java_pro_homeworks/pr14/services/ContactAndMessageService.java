package java_pro_homeworks.pr14.services;

import java_pro_homeworks.pr14.models.CallLog;
import java_pro_homeworks.pr14.models.Contact;
import java_pro_homeworks.pr14.models.Message;
import java_pro_homeworks.pr14.structures.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ContactAndMessageService {


    /**
     * Получить сообщения по контакту
     */
    public List<Message> getAllMessagesByContact(Contact contact, List<Message> messageList) {
        List<Message> result = new ArrayList<>();

        for (Message message : messageList) {
            if (contact.getNumber().equals(message.getNumber())) {
                result.add(message);
            }
        }
        return result;
    }

    /**
     * Получить Количество сообщений по контакту
     */
    public int getMessagesNumberByContact(Contact contact, List<Message> messageList) {
        return getAllMessagesByContact(contact, messageList).size();
    }

    /**
     * Получить Пару типа [Контакт – Количество сообщений по контакту]
     */
    public Pair<Contact, Integer> getPairOfContactAndItsMessagesNumber(Contact contact, List<Message> messageList) {
        return new Pair<Contact, Integer>(contact, getMessagesNumberByContact(contact, messageList));
    }

    /**
     * Получить Коллекцию Пар типа [Контакт – Количество сообщений по контакту]
     */
    public Collection<Pair<Contact, Integer>> getPairsCollectionOfContactAndItsMessagesNumber
    (Collection<Contact> contacts, List<Message> messageList) {

        Collection<Pair<Contact, Integer>> pairs = new ArrayList<>();
        for (Contact contact : contacts) {
            pairs.add(getPairOfContactAndItsMessagesNumber(contact, messageList));
        }
        return pairs;
    }
    /**
     * Получить сортированную Коллекцию Пар типа [Контакт – Количество сообщений по контакту]
     * <p>
     * Сортировать по количеству сообщений
     * <p>
     * Убывающая сортировка
     */
    public Collection<Pair<Contact, Integer>> getPairsCollectionOfContactAndItsMessagesNumberSortedByDesc
    (Collection<Contact> contacts, List<Message> messageList) {

        Collection<Pair<Contact, Integer>> pairs =
                getPairsCollectionOfContactAndItsMessagesNumber(contacts, messageList);

        return pairs.stream()
                .sorted((o1, o2) -> o2.getSecond() - o1.getSecond())
                .collect(Collectors.toCollection(ArrayList<Pair<Contact, Integer>>::new));
    }

    /**
     * Печать отображения вида [Контакт - Количество Сообщений]
     */

    public void showPairsCollectionOfContactAndItsMessagesNumber(Collection<Pair<Contact, Integer>> pairs) {
        ContactService contactService = new ContactService();
        for (Pair<Contact, Integer> pair : pairs) {
            contactService.showContact(pair.getFirst());
            System.out.println("It's messages number: " + pair.getSecond());
        }
    }

    /**
     * Печать отображения вида [Контакт - Количество Сообщений]
     * <p>
     * Перегруженный метод с аргументом для ограничения елементов вывода
     */
    public void showPairsCollectionOfContactAndItsMessagesNumber(Collection<Pair<Contact, Integer>> pairs, int limit) {
        ContactService contactService = new ContactService();
        int step = 0;
        for (Pair<Contact, Integer> pair : pairs) {
            if (step >= limit) {
                break;
            }
            contactService.showContact(pair.getFirst());
            System.out.println("It's messages number: " + pair.getSecond());
            step++;
        }
    }

    /**
     * Получить отображение вида [Контакт - Лист Сообщений]
     */
    /*public Map<Contact, List<Message>> getContactAndItsMessagesMap(List<Contact> contactList,
                                                                   List<Message> messageList ) {
        Map<Contact, List<Message>> result = new HashMap<>();

        for (Contact contact : contactList) {
            List<Message> messagesOfThisContact = getAllMessagesByContact(contact, messageList);
            result.put(contact, messagesOfThisContact);
        }
        return result;
    }*/
    /**
     * Печать отображения вида [Контакт - Лист Сообщений]
     */
    /*public void showContactAndItsMessages(Map<Contact, List<Message>> map){
        ContactService contactService = new ContactService();
        MessageService messageService = new MessageService();
        for (Map.Entry<Contact, List<Message>> entry : map.entrySet()) {

            contactService.showContact(entry.getKey());
            System.out.println("It's messages list: ");
            messageService.showMessages(entry.getValue());
            System.out.println("********************************************************");
        }
    }*/
}
