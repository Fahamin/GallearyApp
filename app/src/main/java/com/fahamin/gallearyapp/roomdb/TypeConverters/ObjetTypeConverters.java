package com.fahamin.gallearyapp.roomdb.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;

public class ObjetTypeConverters {

    @TypeConverter
    public static Object storedStringToMyObjects(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<Object>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(Object myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}