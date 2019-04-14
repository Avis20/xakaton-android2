package com.example.myapplication2.rest;

import com.example.myapplication2.rest.DTOs.PostRequest;
import com.example.myapplication2.rest.DTOs.PostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JSONPlaceHolderApi {
//    @GET("/bins/ovdb8")
    @POST("/spring-test/cookHelper/recipeList")
    public Call<PostResponse> getData(@Body PostRequest Data);


    public interface JSONtest {
        @POST("/alaram")
        public Call<PostResponse> getData(@Body PostRequest Data);
    }
}

