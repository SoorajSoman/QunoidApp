package com.project.sooraj.qunoidapp.restservice;

import com.project.sooraj.qunoidapp.model.UnSplash;

import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by skynet on 6/25/18.
 */

public class RestService {

    public static RestApiInterface apiInterface;

    public static RestApiInterface getClient(String baseapi) {

        if (apiInterface == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            //logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);


            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.interceptors().add(logging);
            builder.addInterceptor(logging);
            OkHttpClient httpClient = builder.build();


            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseapi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
            apiInterface = client.create(RestApiInterface.class);
        }
        return apiInterface;
    }

    public interface RestApiInterface {

        @GET("photos/")
        Call<List<UnSplash>> getListUnSplash(@Query("client_id") String user);

        //@GET("photos/?options")
       // Call<List<UnSplash>> getListUnSplash(@Path("options") Map<String, String> options, @Query());
    }
}
