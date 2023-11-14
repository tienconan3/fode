package com.t3h.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.t3h.myapplication.api.RestClient;
import com.t3h.myapplication.api.StackoverflowAPI;
import com.t3h.myapplication.model.StackOverflowQuestions;
import com.t3h.myapplication.model.Topic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
     private  static  final  String  TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            // 1. tao retrofit
        Retrofit retrofit = RestClient.getRetrofit();
         // 2. khoi tao API
        StackoverflowAPI api = retrofit.create(StackoverflowAPI.class);
        // 3. tao request api

        Call<StackOverflowQuestions> callSearch = api.search("desc", "activity", "Android", "stackoverflow");

        //4. thuc hien call api

        callSearch.enqueue(new Callback<StackOverflowQuestions>() {
            @Override
            public void onResponse(Call<StackOverflowQuestions> call, Response<StackOverflowQuestions> response) {
                if (response.isSuccessful()) {
                    List<Topic> result = response.body().items ;
                    Log.d(TAG, "onResponse: size: " + result.size());
                    if (!result.isEmpty()) {
                        Log.d(TAG, "onResponse: title: " + result.get(0).title);
                        Log.d(TAG, "onResponse: link: " + result.get(0).link);
                    }
                } else {
                    Log.d(TAG, "onResponse error: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<StackOverflowQuestions> call, Throwable t) {
                   t.printStackTrace();
            }
        });
    }


}