package com.vaibhavtraders.gstapp.retrofit;

import com.google.gson.Gson;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Base64;

public class RetrofitService {

    private Retrofit retrofit;

    public RetrofitService() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        // Encode username:password in Base64
        String credentials = "vaibhav:12345";
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

        // Create an Interceptor to add authentication and x-api-key
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", basicAuth) // Adding Basic Auth
                        .header("x-api-key", "vtb8C90x7tU") // Adding x-api-key
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        };

        // Attach interceptor to OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .build();

        // Initialize Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.29.36:9001/") // Replace with actual API URL
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client) // Attach OkHttpClient with headers
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
