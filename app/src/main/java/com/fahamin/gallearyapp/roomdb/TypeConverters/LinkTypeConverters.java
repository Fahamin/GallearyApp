package com.fahamin.gallearyapp.roomdb.TypeConverters;

import androidx.room.TypeConverter;

import com.fahamin.gallearyapp.model.Links;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;

public class LinkTypeConverters {

    @TypeConverter
    public static Links storedStringToMyObjects(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return (Links) Collections.emptyList();
        }
        Type listType = new TypeToken<Links>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(Links myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}