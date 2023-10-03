package java_pro_homeworks.pr20.interfaces;

import java_pro_homeworks.pr20.TinyUrlResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TinyUrlService {

    @POST("random")
    @FormUrlEncoded
    Call<TinyUrlResponse> compressUrl(@Field("format") String format,
                                      @Field("url") String originalUrl);

    @POST("random")
    @FormUrlEncoded
    Call<String> compressUrlToStringResponse(@Field("format") String format,
                                             @Field("url") String originalUrl);

}
