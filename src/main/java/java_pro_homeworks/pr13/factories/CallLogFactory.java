package java_pro_homeworks.pr13.factories;

import java_pro_homeworks.pr13.data.CallType;
import java_pro_homeworks.pr13.models.CallLog;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CallLogFactory {
    public CallLog getRandomCallLogWithoutDuration() {


        String number = DataFactory.generateRandomNumber();
        LocalDateTime time = LocalDateTime.now();
        LocalDate date = LocalDate.now();

        CallType[] types = CallType.values();
        CallType type = types[new Random().nextInt(types.length)];

        return new CallLog(number, time, date, type);
    }

    public List<CallLog> getListOfRandomCallLogWithoutDuration(int size) {
        List<CallLog> callLogs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            callLogs.add(getRandomCallLogWithoutDuration());
        }
        return callLogs;
    }
}
