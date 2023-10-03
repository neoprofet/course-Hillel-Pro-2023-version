package java_pro_homeworks.pr14.services;

import java_pro_homeworks.pr14.models.Message;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;


public class MessageService {

    /**
     * Поиск Сообщений по номеру телефона
     * <p>
     * Результат – Коллекция найденных сообщений
     * <p>
     * Использует общую функцию (CommonService.findByPredicate),
     * которая возвращает найденную субколлекцию по предикату
     */
    public Collection<Message> getByNumber(Collection<Message> allList, String number) {
        Predicate<Message> predicate = new Predicate<Message>() {
            @Override
            public boolean test(Message message) {
                return message.getNumber().equals(number);
            }
        };
        return new CommonService().findByPredicate(allList, predicate);
    }

    /**
     * Поиск Сообщений по тексту
     * <p>
     * Результат – Коллекция найденных сообщений
     * <p>
     * Использует общую функцию (CommonService.findByPredicate),
     * которая возвращает найденную субколлекцию по предикату
     */
    public Collection<Message> getByText(List<Message> allList, String text) {
        Predicate<Message> predicate = new Predicate<Message>() {
            @Override
            public boolean test(Message message) {
                return message.getText().equals(text);
            }
        };
        return new CommonService().findByPredicate(allList, predicate);
    }

    /**
     * Получить уникальные Сообщения
     * Исходящий тип – List
     * Результат – Set найденных сообщений
     */
    /*public Set<Message> getSetOfUniqueMessages(List<Message> allList) {
        return new HashSet<>(allList);
    }*/

    /**
     * Получить уникальные Сообщения
     * Исходящий тип – List
     * Результат – List найденных сообщений
     */
    /*public List<Message> getListOfUniqueMessages(List<Message> allList) {
        return new ArrayList<>(getSetOfUniqueMessages(allList));
    }*/

    /**
     * представить Сущность как отображение [НомерТелефонаСущности - Сущность]
     * Исходящий тип – List
     * Результат – Map
     */
    /*public Map<String, Message> getMapOfSeparatedMessageAndIstNumber(List<Message> messageList) {
        Map<String, Message> numberAndMessageMap = new HashMap<>();
        for (Message message : messageList) {
            numberAndMessageMap.put(message.getNumber(), message);
        }
        return numberAndMessageMap;
    }*/

    /**
     * Печать всех полей одного Сообщения.
     */
    public void showMessage(Message message) {
        String info = "Message{" +
                "\nName: " + message.getNumber() +
                "\nText: " + message.getText() +
                "\nTime: " + message.getTime() +
                "\nDate: " + message.getDate() + "\n}";

        System.out.println(info);
    }

    /**
     * Печать Листа Сообщений.
     * <p>
     * Печать всех полей.
     */
    public void showMessages(Collection<Message> messageList) {
        for (Message message : messageList) {
            showMessage(message);
        }
    }

    /**
     * Печать отображения вида [НомерТелефонаСущности - Сущность]
     */
    /*public void showMessageAndItsNumber(Map<String, Message> map) {
        for (Map.Entry<String, Message> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            showMessage(entry.getValue());
        }
    }*/

}
