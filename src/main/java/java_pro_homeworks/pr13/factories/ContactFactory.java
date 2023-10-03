package java_pro_homeworks.pr13.factories;

import java_pro_homeworks.pr13.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactFactory {
    public Contact getRandomContactWithoutAdditionalInfo() {

        String name = DataFactory.ContactData.getRandomName();
        String number = DataFactory.generateRandomNumber();
        return new Contact(name, number);
    }

    public List<Contact> getListOfRandomContactWithoutAdditionalInfo(int size) {
        List<Contact> contactList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            contactList.add(getRandomContactWithoutAdditionalInfo());
        }
        return contactList;
    }
}
