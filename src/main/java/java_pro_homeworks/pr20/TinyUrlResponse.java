package java_pro_homeworks.pr20;

import com.google.gson.annotations.SerializedName;

public class TinyUrlResponse {
    public String state;

    @SerializedName("longurl")
    public String longUrl;

    @SerializedName("shorturl")
    public String shortUrl;
}