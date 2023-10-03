package java_pro_homeworks.pr19;

import java.util.ArrayList;
import java.util.List;

public class CallLogFabric {

    private String[] names;

    public CallLogFabric(String[] names) {
        this.names = names;
    }


    public CallLog getRandomCallLog() {
        int randomNameIndex = (int) Math.floor(Math.random() * names.length);
        return new CallLog(names[randomNameIndex], CallLogData.generateRandomNumber());
    }

    public List<CallLog> getRandomCallLogs(int count) {
        List<CallLog> callLogs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            callLogs.add(getRandomCallLog());
        }
        return callLogs;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}
