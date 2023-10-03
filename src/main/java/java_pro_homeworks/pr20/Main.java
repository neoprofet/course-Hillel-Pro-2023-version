package java_pro_homeworks.pr20;

import java_pro_homeworks.pr20.interfaces.GitHubWebService;
import java_pro_homeworks.pr20.interfaces.GoogleWebService;
import java_pro_homeworks.pr20.interfaces.TinyUrlService;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

/**
 * 1.Получить текстовый HTML ответ от Google.
 * <p>
 * 2.Получить текстовый JSON ответ от GitHub.
 * <p>
 * 3.Получить и распарсить JSON ответ от tiny-url.info.
 */
public class Main {
    /**
     * Task 1
     * <p>
     * Получить текстовый HTML ответ от Google.
     */
    public static class Task1 {
        public static void main(String[] args) {
            GoogleWebService service = new Retrofit.Builder()
                    .baseUrl("https://www.google.com")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
                    .create(GoogleWebService.class);

            Response<String> response = null;
            try {
                response = service.index().execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (response != null && response.isSuccessful()) {
                System.out.println(response.body());
            } else if (response != null) {
                try {
                    System.out.println(response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Task 2
     * <p>
     * Получить текстовый JSON ответ от GitHub
     */
    public static class Task2 {
        public static void main(String[] args) {
            GitHubWebService service = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
                    .create(GitHubWebService.class);

            Response<String> response = null;
            try {
                response = service.getRepositories("neoprofet").execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (response != null && response.isSuccessful()) {
                System.out.println(response.body());
            } else if (response != null) {
                try {
                    System.out.println(response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Task 3
     * <p>
     * Получить и распарсить JSON ответ от tiny-url.info.
     */

    public static class Task3 {
        public static void main(String[] args) {
            TinyUrlService service = new Retrofit.Builder()
                    .baseUrl("http://tiny-url.info/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(TinyUrlService.class);
            Response<TinyUrlResponse> response = null;
            try {
                response = service.compressUrl("json",
                                "https://www.google.com.ua/maps/place/River+Mall/@50.4042792,30.6094055,15z/data=!4m6!3m5!1s0x40d4c5a3243230d7:0x8364f99720502f97!8m2!3d50.4051284!4d30.6122497!16s%2Fg%2F11c70hkhbq?entry=ttu")
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response != null && response.isSuccessful()) {
                System.out.println(response.body().shortUrl);
            } else if (response != null) {
                try {
                    System.out.println(response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * Task 3a (custom)
     * <p>
     * Получить JSON ответ от tiny-url.info. (String)
     */

    public static class Task3a {
        public static void main(String[] args) {
            TinyUrlService service = new Retrofit.Builder()
                    .baseUrl("http://tiny-url.info/api/v1/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
                    .create(TinyUrlService.class);
            Response<String> response = null;
            try {
                response = service.compressUrlToStringResponse("json",
                                "https://www.google.com.ua/maps/place/River+Mall/@50.4042792,30.6094055,15z/data=!4m6!3m5!1s0x40d4c5a3243230d7:0x8364f99720502f97!8m2!3d50.4051284!4d30.6122497!16s%2Fg%2F11c70hkhbq?entry=ttu")
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response != null && response.isSuccessful()) {
                System.out.println(response.body());
            } else if (response != null) {
                try {
                    System.out.println(response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
