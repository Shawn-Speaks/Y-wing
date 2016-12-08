package shawn.c4q.nyc.retrofit_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shawn.c4q.nyc.retrofit_practice.POJOS.HeaderPojo;
import shawn.c4q.nyc.retrofit_practice.POJOS.Result;

public class MainActivity extends AppCompatActivity {
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView1 = (TextView) findViewById(R.id.tv_1);
        TextView textView2 = (TextView) findViewById(R.id.tv_2);
        TextView textView3 = (TextView) findViewById(R.id.tv_3);
        TextView textView4 = (TextView) findViewById(R.id.tv_4);


        ApiService service = RetrofitBuilder.makeService();
        Call<HeaderPojo> callApi = service.pojoGetter();
        callApi.enqueue(new Callback<HeaderPojo>() {
            @Override
            public void onResponse(Call<HeaderPojo> call, Response<HeaderPojo> response) {

                HeaderPojo headerPojo = response.body();
                List<Result> results = headerPojo.getResults();
                textView1.setText(results.get(3).getName());
            }

            @Override
            public void onFailure(Call<HeaderPojo> call, Throwable t) {

            }
        });

    }
}
