package java_pro_homeworks.pr14;

import java_pro_homeworks.pr14.data.CallType;
import java_pro_homeworks.pr14.models.CallLog;
import java_pro_homeworks.pr14.models.Contact;
import java_pro_homeworks.pr14.models.Message;
import java_pro_homeworks.pr14.services.*;
import java_pro_homeworks.pr14.structures.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * ������� 1:
 * <p>
 * ���������� ����� ���-5 ��������� � ���������� ����������� �������
 * (List[Pair[Contact, Integer]], Map[Contact, Integer]).
 * <p>
 * ������� ��� ������ ��� ������ �������� �� ����� ���������
 * <p>
 * ��������� �����-���� �������� � ���������� ������� ���
 * <p>
 * ��������� ����� ��� ������� �������� �� ���������
 * <p>
 * ��������� ��������� ���� � �������� ���������
 * <p>
 * ������������ ��������� �� �������� ���������� �������
 * <p>
 * �������� �������� 5 ��������� ��������������� ���������
 * <p>
 * ������� 2:
 * <p>
 * ���������� ����� ���-5 ��������� � ���������� ����������� ���������
 * ���������� ����������� �������
 * <p>
 * ������� 3:
 * <p>
 * �������� ������ ��� ���������� ��������� ���������, ������� � ���������
 * � �������������� ��������������� ���������� Predicate<>.
 * <p>
 * �������� ���������� ����� ������ ������ � �������������� ����� ������� ����������.
 * <p>
 * ������� 4:
 * <p>
 * �������� ������� ���������� � ��������� ������� ���������, ������� � ���������
 * � �������������� FIFO � LIFO �������.
 * <p>
 * ������������� � ��������, ����������� ��� Queue � Deque
 */

public class Main {
    static List<Contact> contactList;
    static List<Message> messageList;
    static List<CallLog> callLogList;

    /**
     * ����������� ��������� ������
     */
    static {
        //��������
        contactList = new ArrayList<>();
        contactList.add(new Contact("Denis", "+380954056200"));
        contactList.add(new Contact("Ludmila", "+380501872924"));
        contactList.add(new Contact("Nickolay", "+380503656269"));
        contactList.add(new Contact("Valentina", "+380958039390"));
        contactList.add(new Contact("Ilya", "+380952227279"));

        //���������
        messageList = new ArrayList<Message>();
        LocalDateTime now = LocalDateTime.now();
        messageList.add(new Message("+380954056200", "Hey, Den", now, LocalDate.now()));
        messageList.add(new Message("+380503656269", "Bye, Kolya", now, LocalDate.now()));
        messageList.add(new Message("+380958039390", "Hey, Valya", now, LocalDate.now()));
        messageList.add(new Message("+380501872924", "Hey, Luda", now, LocalDate.now()));
        messageList.add(new Message("+380501872924", "Bye, Luda", now, LocalDate.now()));
        messageList.add(new Message("+380958039390", "Bye, Valya ", now, LocalDate.now()));
        messageList.add(new Message("+380954056200", "Bye, Den", now, LocalDate.now()));
        messageList.add(new Message("+380952227279", "Hey, Ilya", now, LocalDate.now()));

        //������
        callLogList = new ArrayList<>();
        now = LocalDateTime.now();
        callLogList.add(new CallLog("+380501872924", now, LocalDate.now(), CallType.OUTGOING));
        callLogList.add(new CallLog("+380501872924", now, LocalDate.now(), CallType.INCOMING));
        callLogList.add(new CallLog("+380958039390", now, LocalDate.now(), CallType.MISSED));
        callLogList.add(new CallLog("+380954056200", now, LocalDate.now(), CallType.INCOMING));
        callLogList.add(new CallLog("+380503656269", now, LocalDate.now(), CallType.OUTGOING));
        callLogList.add(new CallLog("+380958039390", now, LocalDate.now(), CallType.OUTGOING));
        callLogList.add(new CallLog("+380952227279", now, LocalDate.now(), CallType.MISSED));
        callLogList.add(new CallLog("+380503656269", now, LocalDate.now(), CallType.INCOMING));
        callLogList.add(new CallLog("+380503656269", now, LocalDate.now(), CallType.MISSED));
        callLogList.add(new CallLog("+380954056200", now, LocalDate.now(), CallType.MISSED));
        callLogList.add(new CallLog("+380958039390", now, LocalDate.now(), CallType.INCOMING));
    }

    /**
     * ������� 1
     * <p>
     * ���������� ����� ���-5 ��������� � ���������� ����������� �������
     */
    public static class TopContactsWithTheHighestNumberOfCallsTest {
        public static void main(String[] args) {

            ContactAndCallLogService service = new ContactAndCallLogService();
            Collection<Pair<Contact, Integer>> pairs =
                    service.getPairsCollectionOfContactAndItsCallLogsNumberSortedByDesc(
                            contactList, callLogList);
            service.showPairsCollectionOfContactAndItsCallLogsNumber(pairs, 5);

        }
    }

    /**
     * ������� 2
     * <p>
     * ���������� ����� ���-5 ��������� � ���������� ����������� ���������
     */
    public static class TopContactsWithTheHighestNumberOfMessagesTest {
        public static void main(String[] args) {

            ContactAndMessageService service = new ContactAndMessageService();
            Collection<Pair<Contact, Integer>> pairs =
                    service.getPairsCollectionOfContactAndItsMessagesNumberSortedByDesc(
                            contactList, messageList);
            service.showPairsCollectionOfContactAndItsMessagesNumber(pairs, 5);

        }
    }

    /**
     * ������� 3
     * <p>
     * �������� ������ ��� ���������� ��������� ���������, ������� � ���������
     * � �������������� ��������������� ���������� Predicate<>.
     */
    public static class PredicateSearchingMethodsTest {
        public static void main(String[] args) {
            ContactService contactService = new ContactService();
            MessageService messageService = new MessageService();
            CallLogService callLogService = new CallLogService();

            System.out.println("========= CALL LOGS BY NUMBER =========");
            callLogService.showCallLogs(callLogService.getByNumber(callLogList, "+380501872924"));
            System.out.println("========= CALL LOGS BY TYPE=========");
            callLogService.showCallLogs(callLogService.getByType(callLogList, CallType.OUTGOING));
            System.out.println("========= CONTACTS BY NUMBER =========");
            contactService.showContacts(contactService.getByNumber(contactList, "+380501872924" ));
            System.out.println("========= CONTACTS BY NAME  =========");
            contactService.showContacts(contactService.getByName(contactList, "Ludmila"));
            System.out.println("========= MESSAGES BY NUMBER =========");
            messageService.showMessages(messageService.getByNumber(messageList, "+380501872924" ));
            System.out.println("========= MESSAGES BY TEXT =========");
            messageService.showMessages(messageService.getByText(messageList, "Hey, Luda"));

        }
    }
    /**
     * ������� 4
     * <p>
     * �������� ������� ���������� � ��������� ������� ���������,
     * ������� � ��������� � �������������� FIFO � LIFO �������.
     *
     * ������������� � ��������, ����������� ��� Queue � Deque
     */
    public static class DataStructuresTest{
        public static void main(String[] args) {

            System.out.println("========= STACK TEST =========");
            Stack<Contact> stack = new Stack<>();
            stack.addAll(contactList);
            stack.add(new Contact("Bohdan", "+380501894571")); //��������
            System.out.println(stack.push(new Contact("Maria", "+380956753190")));//�������� � �������
            System.out.println(stack.peek().getName());//������ �������
            System.out.println(stack.peek().getName());// ������� � ������� (n)
            System.out.println(stack.peek().getName());// ������� � ������� (n-1)

            System.out.println("========= QUEUE TEST =========");
            Queue<Contact> queue = new LinkedList<>();
            queue.addAll(contactList);
            System.out.println(queue.peek().getName());
            queue.add(new Contact("Galya", "+380665843222"));
            System.out.println(queue.peek().getName()); // only return
            System.out.println(queue.poll().getName()); // return and delete
            System.out.println(queue.poll().getName());
            System.out.println(queue.poll().getName());
            System.out.println(queue.poll().getName());
            System.out.println(queue.poll().getName());
            System.out.println(queue.poll().getName());   //do not throws exception if queue is empty
            //System.out.println(queue.remove().getName()); //like a poll but throws exception if queue is empty

            System.out.println("========= DEQUEUE TEST =========");
            Deque<Contact> deque = new LinkedList<>();
            deque.addAll(contactList);
            System.out.println(deque.peekFirst().getName()); // only return First element
            deque.addFirst(new Contact("Galya", "+380665843222")); // add to head
            System.out.println(deque.peekLast().getName()); // only return Last element

            System.out.println(deque.pollFirst().getName()); // return and delete First element
            System.out.println(deque.pollLast().getName()); // return and delete Last element
        }
    }


}
