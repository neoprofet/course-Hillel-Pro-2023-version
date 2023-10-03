package java_pro_homeworks.pr13.services;

import java_pro_homeworks.pr13.models.Contact;
import java_pro_homeworks.pr13.models.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    public void showMessage(Message message){
        String info = "Message{" +
                "\nName: " + message.getNumber() +
                "\nText: " + message.getText() +
                "\nTime: " + message.getTime() +
                "\nDate: " + message.getDate() + "\n}";

        System.out.println(info);
    }

    public void showMessages(List<Message> messageList){
        for (Message message : messageList) {
            showMessage(message);
        }
    }

    public List<Message> getByNumber(List<Message> allList, String number){
        List<Message> result = new ArrayList<>();
        for (Message message : allList) {
            if(message.getNumber().equals(number)) {
                result.add(message);
            }
        }
        return result;
    }

}
