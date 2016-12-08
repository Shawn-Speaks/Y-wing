package shawn.c4q.nyc.retrofit_practice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shawnspeaks on 12/7/16.
 */

public class RetrofitBuilder {

    private static final String someURL = "https://swapi.co/";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder;


    public static ApiService makeService() {
        if (retrofit == null) {
            builder = new Retrofit.Builder()
                    .baseUrl(someURL)
                    .addConverterFactory(GsonConverterFactory.create());
        }
        retrofit = builder.build();
        return retrofit.create(ApiService.class);
    }
}
