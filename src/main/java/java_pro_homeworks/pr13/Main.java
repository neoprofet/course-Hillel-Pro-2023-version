package java_pro_homeworks.pr13;

import java_pro_homeworks.pr13.factories.CallLogFactory;
import java_pro_homeworks.pr13.factories.ContactFactory;
import java_pro_homeworks.pr13.factories.MessagesFactory;
import java_pro_homeworks.pr13.models.CallLog;
import java_pro_homeworks.pr13.models.Contact;
import java_pro_homeworks.pr13.models.Message;
import java_pro_homeworks.pr13.services.CallLogService;
import java_pro_homeworks.pr13.services.ContactService;
import java_pro_homeworks.pr13.services.MessageService;

import java.util.List;

/**
 * ��������
 * <p>
 * ���������� ������, ����������� ������� � ���������� �����,
 * ������ � ������� ������� � ���� ��������� (Contact, CallLog, Message).
 * <p>
 * ���������� �������� ����� ���������, ������� � ���������,
 * ��������� ��������� (List<Contact>, List<CallLog>, List<Message>).
 * <p>
 * ���������� ������� ���������� ������ �� ���������� � ����������, �������� �
 * ����������� (Collection<Contact> find(Collection<Contact>, String)).
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("========================== CONTACTS ==========================");
        ContactService contactService = new ContactService();
        ContactFactory factory = new ContactFactory();
        List<Contact> contactList = factory.getListOfRandomContactWithoutAdditionalInfo(10);
        contactService.showContacts(contactList);

        System.out.println("========================== MESSAGES ==========================");
        MessageService messageService = new MessageService();
        MessagesFactory messagesFactory = new MessagesFactory();
        List<Message> messageList = messagesFactory.getListOfRandomMessages(10);
        messageService.showMessages(messageList);

        System.out.println("========================== CALL LOGS ==========================");
        CallLogService callLogService = new CallLogService();
        CallLogFactory callLogFactory = new CallLogFactory();
        List<CallLog> callLogs = callLogFactory.getListOfRandomCallLogWithoutDuration(10);
        callLogService.showCallLogs(callLogs);

        System.out.println("========================== FIND CONTACT BY NUMBER ==========================");

    }
}
