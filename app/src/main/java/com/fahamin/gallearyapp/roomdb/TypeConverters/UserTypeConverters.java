package com.fahamin.gallearyapp.roomdb.TypeConverters;

import androidx.room.TypeConverter;

import com.fahamin.gallearyapp.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;

public class UserTypeConverters {

    @TypeConverter
    public static User storedStringToMyObjects(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return (User) Collections.emptyList();
        }
        Type listType = new TypeToken<User>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(User myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}