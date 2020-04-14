package kedia.pk.kakcho;

import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.unsplash.com/";
    String ACCESS_KEY = "12crTwn2h6STA9FaDtS9sGQkP_LevQQjwsC_EZ7suZU";
    @GET("photos/?client_id=12crTwn2h6STA9FaDtS9sGQkP_LevQQjwsC_EZ7suZU")
    Call<List<UnsplashPhoto>> getPhoto();
}
