package com.fahamin.gallearyapp.roomdb.TypeConverters;

import androidx.room.TypeConverter;

import com.fahamin.gallearyapp.model.TopicSubmissions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;

public class TopicSubmissionypeConverters {

    @TypeConverter
    public static TopicSubmissions storedStringToMyObjects(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return (TopicSubmissions) Collections.emptyList();
        }
        Type listType = new TypeToken<TopicSubmissions>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(TopicSubmissions myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}