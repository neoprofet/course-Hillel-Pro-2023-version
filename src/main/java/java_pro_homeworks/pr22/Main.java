package java_pro_homeworks.pr22;

import java_pro_homeworks.pr22.callbacks.AppleCallback;
import java_pro_homeworks.pr22.callbacks.BingCallback;
import java_pro_homeworks.pr22.callbacks.GoogleCallback;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Main {

    /**
     * MY CUSTOM TASK 1A
     * <p>
     * Получить ассинхронно html с 3 страниц и проследить ассинхронность выполнения
     * <p>
     * Использовать анонимный класс Callback
     */
    public static class Task1a {
        public static void main(String[] args) {
            OkHttpClient client = new OkHttpClient();

            Request request1 = new Request.Builder()
                    .url("https://www.apple.com/")
                    .build();

            Request request2 = new Request.Builder()
                    .url("https://www.google.com/")
                    .build();

            Request request3 = new Request.Builder()
                    .url("https://www.bing.com/")
                    .build();

            // ==================== Apple.com RESPONSE ====================
            client.newCall(request1).enqueue(new Callback() {
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
            });

            // ==================== Google.com RESPONSE ====================
            client.newCall(request2).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    System.out.println("==================== Google.com RESPONSE 2 ====================");
                    String html = response.body().string();
                    System.out.println(html);
                }
            });

            // ==================== Bing.com RESPONSE ====================
            client.newCall(request3).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    System.out.println("==================== Bing.com RESPONSE 3 ====================");
                    String html = response.body().string();
                    System.out.println(html);
                }
            });

            System.out.println("END OF THE MAIN()");

        }


    }

    /**
     * MY CUSTOM TASK 1B
     * <p>
     * Получить ассинхронно html с 3 страниц и проследить ассинхронность выполнения
     * <p>
     * Использовать внешний класс Callback для каждой задачи
     */
    public static class Task1b {
        public static void main(String[] args) {
            OkHttpClient client = new OkHttpClient();

            Request request1 = new Request.Builder()
                    .url("https://www.apple.com/")
                    .build();

            Request request2 = new Request.Builder()
                    .url("https://www.google.com/")
                    .build();

            Request request3 = new Request.Builder()
                    .url("https://www.bing.com/")
                    .build();

            // ==================== Apple.com RESPONSE ====================
            client.newCall(request1).enqueue(new AppleCallback());

            // ==================== Google.com RESPONSE ====================
            client.newCall(request2).enqueue(new GoogleCallback());

            // ==================== Bing.com RESPONSE ====================
            client.newCall(request3).enqueue(new BingCallback());

            System.out.println("END OF THE MAIN()");

        }

    }
}
