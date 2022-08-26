package com.fahamin.gallearyapp.roomdb;


import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.fahamin.gallearyapp.model.UnsplashModel;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class GalaryDatabaseTest extends TestCase {
    GalaryDatabase database;
    GalrayDao dao;


    @Before
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, GalaryDatabase.class).build();
        dao = database.galrayDao();
    }


    @After
    void closeDb() {
        database.close();
    }

    @Test
    void WriteAndReadGallary() {
        UnsplashModel model = new UnsplashModel();

        model.setId("imae1");
        model.setHeight(897);
        dao.insertSingle(model);

        List<UnsplashModel> list = dao.getAllImageFromDb();

        assertTrue(list.contains(model));
    }
}