package java_pro_homeworks.pr14.services;

import java_pro_homeworks.pr14.models.Contact;

import java.util.*;
import java.util.function.Predicate;

public class ContactService {

    /**
     * ����� ��������� �� ������ ��������
     * <p>
     * ��������� � ��������� ��������� ���������
     * <p>
     * ���������� ����� ������� (CommonService.findByPredicate),
     * ������� ���������� ��������� ������������ �� ���������
     */
    public Collection<Contact> getByNumber(List<Contact> allList, String number) {
        Predicate<Contact> predicate = new Predicate<Contact>() {
            @Override
            public boolean test(Contact contact) {
                return contact.getNumber().equals(number);
            }
        };
        return new CommonService().findByPredicate(allList, predicate);
    }

    /**
     * ����� ��������� �� �����
     * <p>
     * ��������� � ��������� ��������� ���������
     * <p>
     * ���������� ����� ������� (CommonService.findByPredicate),
     * ������� ���������� ��������� ������������ �� ���������
     */
    public Collection<Contact> getByName(Collection<Contact> allList, String name) {
        Predicate<Contact> predicate = new Predicate<Contact>() {
            @Override
            public boolean test(Contact contact) {
                return contact.getName().equals(name);
            }
        };
        return new CommonService().findByPredicate(allList, predicate);
    }

    /**
     * �������� ���������� ��������
     * <p>
     * ��������� ��� � List
     * <p>
     * ��������� � Set ��������� ���������
     */
   /* public Set<Contact> getSetOfUniqueContacts(List<Contact> allList) {
        return new HashSet<>(allList);
    }*/

    /**
     * �������� ���������� ��������
     * <p>
     * ��������� ��� � List
     * <p>
     * ��������� � List ��������� ���������
     */
    /*public List<Contact> getListOfUniqueContacts(List<Contact> allList) {
        return new ArrayList<>(getSetOfUniqueContacts(allList));
    }*/

    /**
     * ����������� �������� ��� ����������� [��������������������� - ��������]
     * <p>
     * ��������� ��� � List
     * <p>
     * ��������� � Map
     */
    /*public Map<String, Contact> getMapOfSeparatedContactAndItsNumber(List<Contact> contactList) {
        Map<String, Contact> numberAndContactMap = new HashMap<>();
        for (Contact contact : contactList) {
            numberAndContactMap.put(contact.getNumber(), contact);
        }
        return numberAndContactMap;
    }*/

    /**
     * ������ ����� ������ ��������.
     * <p>
     * ��������� ���� (�����, ������������������������ � ������������)
     * <p>
     * ������ ������ ��� �������
     */
    public void showContact(Contact contact) {
        String info = "Contact{" +
                "\nName: " + contact.getName() +
                "\nNumber: " + contact.getNumber();
        if (contact.getAdditionalInfo() != null && !contact.getAdditionalInfo().isEmpty()) {
            info = info.concat("\nAdditionalInfo: " + contact.getAdditionalInfo());
        }
        if (contact.getAdditionalInfo() != null && !contact.getAddress().isEmpty()) {
            info = info.concat("\nAddress: " + contact.getAddress());
        }
        info = info.concat("\n}");

        System.out.println(info);
    }

    /**
     * ������ ����� ���������.
     * <p>
     * ������ ���� �����.
     */
    public void showContacts(Collection<Contact> contactList) {
        for (Contact contact : contactList) {
            showContact(contact);
        }
    }

    /**
     * ������ ����������� ���� [��������������������� - ��������]
     */
    /*public void showContactAndItsNumber(Map<String, Contact> map) {
        for (Map.Entry<String, Contact> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            showContact(entry.getValue());
        }
    }*/
}
