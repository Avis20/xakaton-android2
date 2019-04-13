package com.example.myapplication.rest;

import com.example.myapplication.rest.DTOs.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("/bins/cceqs/")
    public Call<PostResponse> getPostWithID();
}

public interface JSONRecipetsAPI {
    @GET("/bins/fv2xg/")
    public Call<PostResponse> getPostWithID();
}