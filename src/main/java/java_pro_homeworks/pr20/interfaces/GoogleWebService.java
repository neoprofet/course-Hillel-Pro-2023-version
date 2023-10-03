package java_pro_homeworks.pr20.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GoogleWebService {
    @GET("/")
    Call<String> index();
}
