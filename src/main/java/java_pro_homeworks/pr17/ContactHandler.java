package java_pro_homeworks.pr17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactHandler {
    public static String getContactToString(Contact contact, String regex) {
        return new StringBuilder()
                .append(contact.getName())
                .append(regex)
                .append(contact.getSurname())
                .append(regex)
                .append(contact.getPhone())
                .append(regex)
                .append(contact.getYearOfBirth())
                .toString();
    }

    public static String getContactsToString(Contact[] contacts, String regex) {
        String result = "";
        for (int i = 0; i < contacts.length; i++) {
            result = result + getContactToString(contacts[i], regex);
            if (contacts.length - i != 1) result = result + "\n";
        }
        return result;
    }


    public static Contact getContactFromString(String data, String regex) {

        String[] substrings = data.split(regex);


        return new Contact(substrings[0],substrings[1],substrings[2], Integer.parseInt(substrings[3]));
    }

    public static List<Contact> getContactsFromFile(File file, String regex) {
        List<Contact> list = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            while (bufferedReader.ready()){
                String str = bufferedReader.readLine();
                list.add(getContactFromString(str,regex));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }
}