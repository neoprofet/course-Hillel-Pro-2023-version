package java_pro_homeworks.pr14.factories;

import java_pro_homeworks.pr14.models.Message;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessagesFactory {
    public Message getRandomMessage() {

        String number = DataFactory.generateRandomNumber();
        String text = DataFactory.MessageData.getRandomMessage();
        LocalDate date = LocalDate.now();
        LocalDateTime time = LocalDateTime.now();
        return new Message(number,text,time,date);
    }

    public List<Message> getListOfRandomMessages(int size) {
        List<Message>  messageList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            messageList.add(getRandomMessage());
        }
        return messageList;
    }
}
