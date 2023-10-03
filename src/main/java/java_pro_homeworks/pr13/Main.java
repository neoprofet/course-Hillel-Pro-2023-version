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
 * Практика
 * <p>
 * Реализуйте классы, описывающие контакт в телефонной книге,
 * запись в журнале звонков и одно сообщение (Contact, CallLog, Message).
 * <p>
 * Определите тестовый набор контактов, звонков и сообщений,
 * используя коллекции (List<Contact>, List<CallLog>, List<Message>).
 * <p>
 * Реализуйте функции текстового поиска по коллекциям с контактами, звонками и
 * сообщениями (Collection<Contact> find(Collection<Contact>, String)).
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
