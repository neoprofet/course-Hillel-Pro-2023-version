package java_pro_homeworks.pr21;

import com.google.gson.Gson;
import java_pro_homeworks.pr21.handlers.BingImage;
import java_pro_homeworks.pr21.handlers.BingResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static class Task1a {
        public static void main(String[] args) {
            OkHttpClient client = new OkHttpClient();

            final long start = System.nanoTime();

            Request request = new Request.Builder()
                    .url("https://www.apple.com/")
                    .build();


            try (Response response = client.newCall(request).execute()) {

                String html = response.body().string();
                System.out.println(html);

            } catch (IOException e) {
                e.printStackTrace();
            }

            final long end = System.nanoTime();
            System.out.printf("Duration  %d ns", end - start);

        }
    }

    public static class Task1b {
        public static void main(String[] args) {

            final long start = System.nanoTime();
            OkHttpClient client = getClientWithLoggingInterceptor();

            Request request = new Request.Builder()
                    .url("https://www.apple.com/")
                    .build();


            try (Response response = client.newCall(request).execute()) {

                String html = response.body().string();
                System.out.println(html);

            } catch (IOException e) {
                e.printStackTrace();
            }

            final long end = System.nanoTime();
            System.out.printf("Duration  %d ns", end - start);

        }

        private static OkHttpClient getClientWithLoggingInterceptor() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(@NotNull String s) {
                    System.out.println(String.format("[%d]: %s", Thread.currentThread().getId(), s));
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            return client;
        }
    }

    public static class Task2 {
        public static void main(String[] args) {
            OkHttpClient client = getClient();
            Request request = new Request.Builder()
                    .url("https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=30&mkt=en-US")
                    .build();

            try (Response response = client.newCall(request).execute()) {

                String json = response.body().string();
                Gson gson = new Gson();
                BingResponse bingResponse = gson.fromJson(json, BingResponse.class);
                for (BingImage image : bingResponse.images) {
                    String fullUrl = "https://www.bing.com" + image.url;
                    downloadImage(client,fullUrl);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void downloadImage(OkHttpClient client, String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                final InputStream inputStream = response.body().byteStream();
                String fileName = request.url().queryParameter("id");
                try (OutputStream outputStream = new FileOutputStream(fileName)) {
                    byte[] buffer = new byte[4096];
                    while (true) {
                        int readCount = inputStream.read(buffer);
                        if (readCount < 0) {
                            break;
                        }
                        outputStream.write(buffer,0,readCount);
                    }
                }
            }
        }

        private static OkHttpClient getClient() {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .build();
            return okHttpClient;
        }
    }
}
