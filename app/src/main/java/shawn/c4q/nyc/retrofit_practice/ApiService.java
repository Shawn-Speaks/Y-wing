package shawn.c4q.nyc.retrofit_practice;

import retrofit2.Call;
import retrofit2.http.GET;
import shawn.c4q.nyc.retrofit_practice.POJOS.HeaderPojo;

/**
 * Created by shawnspeaks on 12/7/16.
 */

public interface ApiService {

    @GET("api/starships/")
    Call<HeaderPojo> pojoGetter();


}
