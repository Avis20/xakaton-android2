package com.example.myapplication2.rest;

import com.example.myapplication2.rest.DTOs.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("/bins/ovdb8")
    public Call<PostResponse> getData();

}
