package com.fahamin.gallearyapp.roomdb.TypeConverters;

import androidx.room.TypeConverter;

import com.fahamin.gallearyapp.model.Urls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;

public class UrlTypeConverters {

    @TypeConverter
    public static Urls storedStringToMyObjects(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return (Urls) Collections.emptyList();
        }
        Type listType = new TypeToken<Urls>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(Urls myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}