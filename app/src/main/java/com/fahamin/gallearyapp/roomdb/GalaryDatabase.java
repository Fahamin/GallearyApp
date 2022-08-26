package com.fahamin.gallearyapp.roomdb;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.fahamin.gallearyapp.model.UnsplashModel;


@Database(entities = {UnsplashModel.class}, version = 2, exportSchema = false)
public abstract class GalaryDatabase extends RoomDatabase {

    public abstract GalrayDao galrayDao();

    public static GalaryDatabase instance;

    public static GalaryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            GalaryDatabase.class, "dbgallary")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build();

        }

        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }
}
