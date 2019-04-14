package com.example.myapplication2;

import com.example.myapplication2.rest.DTOs.PostResponse;

import java.util.HashMap;
import java.util.Map;

public class HTTPRequestHelper {

    private static Map<Integer, PostResponse> responseMap = new HashMap<>();

    public static void put(Integer key, PostResponse value) {
        responseMap.put(key, value);
    }

    public static PostResponse getValue(Integer key) {
        return responseMap.get(key);
    }

    public static  Map<Integer, PostResponse> getAll() {
        return responseMap;
    }
}
