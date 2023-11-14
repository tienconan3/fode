package com.t3h.myapplication.api;

import com.t3h.myapplication.model.StackOverflowQuestions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackoverflowAPI {
    @GET("/2.2/search")
    Call<StackOverflowQuestions> search(@Query("order") String order,
                            @Query("sort") String sort,
                            @Query("tagged") String tagged,
                            @Query("site") String site);
    @GET("/2.2/login")
    Call<StackOverflowQuestions> login(@Query("order") String order,
                                        @Query("sort") String sort,
                                        @Query("tagged") String tagged,
                                        @Query("site") String site);
    @GET("/2.2/getList")
    Call<StackOverflowQuestions> getList(@Query("order") String order,
                                        @Query("sort") String sort,
                                        @Query("tagged") String tagged,
                                        @Query("site") String site);
}
