package java_pro_homeworks.pr14.services;

import java_pro_homeworks.pr14.models.Message;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;


public class MessageService {

    /**
     * ����� ��������� �� ������ ��������
     * <p>
     * ��������� � ��������� ��������� ���������
     * <p>
     * ���������� ����� ������� (CommonService.findByPredicate),
     * ������� ���������� ��������� ������������ �� ���������
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
     * ����� ��������� �� ������
     * <p>
     * ��������� � ��������� ��������� ���������
     * <p>
     * ���������� ����� ������� (CommonService.findByPredicate),
     * ������� ���������� ��������� ������������ �� ���������
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
     * �������� ���������� ���������
     * ��������� ��� � List
     * ��������� � Set ��������� ���������
     */
    /*public Set<Message> getSetOfUniqueMessages(List<Message> allList) {
        return new HashSet<>(allList);
    }*/

    /**
     * �������� ���������� ���������
     * ��������� ��� � List
     * ��������� � List ��������� ���������
     */
    /*public List<Message> getListOfUniqueMessages(List<Message> allList) {
        return new ArrayList<>(getSetOfUniqueMessages(allList));
    }*/

    /**
     * ����������� �������� ��� ����������� [��������������������� - ��������]
     * ��������� ��� � List
     * ��������� � Map
     */
    /*public Map<String, Message> getMapOfSeparatedMessageAndIstNumber(List<Message> messageList) {
        Map<String, Message> numberAndMessageMap = new HashMap<>();
        for (Message message : messageList) {
            numberAndMessageMap.put(message.getNumber(), message);
        }
        return numberAndMessageMap;
    }*/

    /**
     * ������ ���� ����� ������ ���������.
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
     * ������ ����� ���������.
     * <p>
     * ������ ���� �����.
     */
    public void showMessages(Collection<Message> messageList) {
        for (Message message : messageList) {
            showMessage(message);
        }
    }

    /**
     * ������ ����������� ���� [��������������������� - ��������]
     */
    /*public void showMessageAndItsNumber(Map<String, Message> map) {
        for (Map.Entry<String, Message> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            showMessage(entry.getValue());
        }
    }*/

}
