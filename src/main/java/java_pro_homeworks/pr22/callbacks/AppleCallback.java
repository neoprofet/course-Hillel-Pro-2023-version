package java_pro_homeworks.pr22.callbacks;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AppleCallback implements Callback {
    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        System.out.println("==================== Apple.com RESPONSE 1 ====================");
        String html = response.body().string();
        System.out.println(html);
    }
}
