package java_pro_homeworks.pr13.services;
import java_pro_homeworks.pr13.models.CallLog;
import java_pro_homeworks.pr13.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class CallLogService {
    public void showCallLog(CallLog callLog){
        String info = "CallLog{" +
                "\nNumber: " + callLog.getNumber() +
                "\nStatus: " + callLog.getType() +
                "\nTime: " + callLog.getTime() +
                "\nDate: " + callLog.getDate() + "\n}";
        System.out.println(info);
    }

    public void showCallLogs(List<CallLog> callLogs){
        for (CallLog callLog : callLogs) {
            showCallLog(callLog);
        }
    }

    public List<CallLog> getByNumber(List<CallLog> allList, String number){
        List<CallLog> result = new ArrayList<>();
        for (CallLog callLog : allList) {
            if(callLog.getNumber().equals(number)) {
                result.add(callLog);
            }
        }
        return result;
    }
}

