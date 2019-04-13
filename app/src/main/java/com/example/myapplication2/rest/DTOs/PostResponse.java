package com.example.myapplication2.rest.DTOs;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostResponse {
    @SerializedName("test12")
    @Expose
    private String test12;

    public String getTest12() { return test12; }

    public void setTest12(String test12) {
        this.test12 = test12;
    }

    @SerializedName("Recipes")
    @Expose
    private ArrayList<DataObject> Recipes;

    public ArrayList<DataObject> getRecipes() {
        return Recipes;
    }
    public void setRecipes(ArrayList<DataObject> recipes) {
        Recipes = recipes;
    }

    public class DataObject {
        @SerializedName("recipeName")
        @Expose
        private String recipeName;

        @SerializedName("cookTime")
        @Expose
        private String cookTime;

        public String RecipeName() {
            return recipeName;
        }
        public void RecipeName(String name) {
            this.recipeName = recipeName;
        }

        public String getCookTime() {
            return cookTime;
        }
        public void setCookTime(String cookTime) {
            this.cookTime = cookTime;
        }
    }
}