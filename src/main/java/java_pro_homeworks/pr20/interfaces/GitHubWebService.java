package java_pro_homeworks.pr20.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubWebService {
    @GET("users/{user}/repos")
    Call<String> getRepositories(@Path("user") String username);
}
