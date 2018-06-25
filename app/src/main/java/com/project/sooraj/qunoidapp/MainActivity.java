package com.project.sooraj.qunoidapp;

import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.project.sooraj.qunoidapp.adapter.ProfileRecyclerAdapter;
import com.project.sooraj.qunoidapp.model.UnSplash;
import com.project.sooraj.qunoidapp.restservice.RestService;

import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public  static  String URL="https://api.unsplash.com/";
    ProfileRecyclerAdapter profileRecyclerAdapter;
    private static  String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        setAdapter();
    }

    private void setAdapter() {
        RestService.RestApiInterface service = RestService.getClient(URL);

        Call<List<UnSplash>>unSplash=service.getListUnSplash("8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8");
        unSplash.enqueue(new Callback<List<UnSplash>>() {
            @Override
            public void onResponse(Call<List<UnSplash>> call, Response<List<UnSplash>> response) {
                ProfileRecyclerAdapter recyclerAdapter=new ProfileRecyclerAdapter(response.body(),MainActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<UnSplash>> call, Throwable t) {
                Log.v(TAG,t.getMessage());

            }
        });
    }
}
