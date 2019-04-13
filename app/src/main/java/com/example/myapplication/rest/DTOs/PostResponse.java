package com.example.myapplication.rest.DTOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostResponse {
    @SerializedName("test12")
    @Expose
    private String test12;

    public String getTest12() {
        return test12;
    }

    public void setTest12(String test12) {
        this.test12 = test12;
    }

    private List<Data> Recipes;

    public List<Data> getRecipe() {
        return Recipes;
    }

    public class Data {
        @SerializedName("name")
        private String name;

        @SerializedName("time")
        private String time;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}