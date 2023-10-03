package java_pro_homeworks.pr13.services;

import java_pro_homeworks.pr13.models.CallLog;
import java_pro_homeworks.pr13.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    public void showContact(Contact contact){
        String info = "Contact{" +
                "\nName: " + contact.getName() +
                "\nNumber: " + contact.getNumber();
        if(contact.getAdditionalInfo()!=null&&!contact.getAdditionalInfo().isEmpty()){
           info = info.concat("\nAdditionalInfo: "+contact.getAdditionalInfo());
        }
        if(contact.getAdditionalInfo()!=null&&!contact.getAddress().isEmpty()){
            info = info.concat("\nAddress: "+contact.getAddress());
        }
        info = info.concat("\n}");

        System.out.println(info);
    }

    public void showContacts(List<Contact> contactList){
        for (Contact contact : contactList) {
            showContact(contact);
        }
    }

    public List<Contact> getByNumber(List<Contact> allList, String number){
        List<Contact> result = new ArrayList<>();
        for (Contact contact : allList) {
            if(contact.getNumber().equals(number)) {
                result.add(contact);
            }
        }
        return result;
    }
}
